package com.yg2288.pokerodds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PokerSimulator {
    private StartingHand playerHand;
    private List<StartingHand> opponentHands;
    private List<Card> board;

//    private int gamesPlayed;
//    private int gamesWon;
//    private int offSuit;
//    private int suited;
//    private int pocketPair;
    //private HashMap<HandEnum, Integer> playerHandStats = new HashMap<>();
    private ConcurrentHashMap<HandEnum, LongAdder> playerHandStats = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, LongAdder> playerHandCounts = new ConcurrentHashMap<>();

    public PokerSimulator(StartingHand playerHand, List<StartingHand> opponentHands, List<Card> board) {
        this.playerHand = playerHand;
        this.opponentHands = opponentHands;
        this.board = board;
    }

    public PokerSimulator(StartingHand playerHand, int opponents, List<Card> board) {
        if (opponents > 7)
            throw new IllegalArgumentException("Number of opponents cannot be greater than 7. ");
        List<StartingHand> opponentHands = new ArrayList<>();
        for (int i=0; i<opponents; i++)
            opponentHands.add(new StartingHand());
        this.playerHand = playerHand;
        this.opponentHands = opponentHands;
        this.board = board;
    }

    public List<StartingHand> getOpponentHands() {
        return opponentHands;
    }

    public void setOpponentHands(List<StartingHand> opponentHands) {
        this.opponentHands = opponentHands;
    }

    public void setOpponentHands(int i, StartingHand opponentHand) {
        if (i < 0 || i >= opponentHands.size())
            throw new IllegalArgumentException("Invalid opponent number. ");
        opponentHands.set(i, opponentHand);
    }

    public int getNumOpponents() {
        return opponentHands.size();
    }

    public StartingHand getPlayerHand() {
        return playerHand;
    }

    public void setPlayerHand(StartingHand playerHand) {
        this.playerHand = playerHand;
    }

    public List<Card> getBoard() {
        return board;
    }

    public void setBoard(List<Card> board) {
        this.board = board;
    }

    public void setBoard(int i, Card card) {
        if (i < 0 || i >= board.size())
            throw new IllegalArgumentException("Invalid card number. ");
        board.set(i, card);
    }

    public void resetStats() {
        // gamesPlayed = gamesWon = 0;
        playerHandStats.clear();
        playerHandCounts.clear();
    }

    public int getGamesPlayed() {
//        return gamesPlayed;
        return playerHandCounts.computeIfAbsent("gamesPlayed", k -> new LongAdder()).intValue();
    }

    public int getGamesWon() {
//        return gamesWon;
        return playerHandCounts.computeIfAbsent("gamesWon", k -> new LongAdder()).intValue();
    }

    public int getOffSuit() {
//        return offSuit;
        return playerHandCounts.computeIfAbsent("offSuit", k -> new LongAdder()).intValue();
    }

    public int getSuited() {
//        return suited;
        return playerHandCounts.computeIfAbsent("suited", k -> new LongAdder()).intValue();
    }

    public int getPocketPair() {
//        return pocketPair;
        return playerHandCounts.computeIfAbsent("pocketPair", k -> new LongAdder()).intValue();
    }

    public float getWinPercentage() {
//        return (float)gamesWon / gamesPlayed;
        int gamesPlayed = getGamesPlayed();
        int gamesWon = getGamesWon();
        if (gamesPlayed == 0)
            return 0;
        return (float)gamesWon / gamesPlayed;
    }

    protected ConcurrentHashMap<HandEnum, LongAdder> getHandStats() {
        return playerHandStats;
    }

    public int getHandStat(HandEnum type) {
        return playerHandStats.computeIfAbsent(type, k -> new LongAdder()).intValue();
    }

    public void simulate(int games) {
//        for (int i=0; i<games; i++)
//            simulateOneGame(playerHand, opponentHands, board);
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        RecursiveSimulator task = new RecursiveSimulator(games, playerHand, opponentHands, board, playerHandCounts, playerHandStats);
        commonPool.execute(task);
        task.join();
    }

    public void simulateOneGame(StartingHand player, List<StartingHand> opponents, List<Card> board) {
        // Build deck excluding existing cards
        List<Card> exclude = new ArrayList<>();
        exclude.addAll(player.getCards());
        exclude.addAll(board);
        for (StartingHand o : opponents)
            exclude.addAll(o.getCards());
        Deck deck = new Deck(exclude);
        deck.shuffle();
        // Deal cards to all players and the board
        StartingHand dPlayerHand = dealPlayerHand(player, deck);
        List<StartingHand> dOpponentHands = dealOpponentHands(opponents, deck);
        List<Card> playerCards = dPlayerHand.getCards();
        List<List<Card>> opponentCards = new ArrayList<>();
        for (StartingHand o : dOpponentHands)
            opponentCards.add(o.getCards());
        List<Card> boardCards = dealBoard(board, deck);
        // Get the best hand for each player
        PlayingHand playerHand = PlayingHandFactory.getBestHand(Stream.concat(playerCards.stream(), boardCards.stream()).collect(Collectors.toList()));
        List<PlayingHand> opponentHands = new ArrayList<>();
        for (List<Card> c : opponentCards) {
            PlayingHand hand = PlayingHandFactory.getBestHand(Stream.concat(c.stream(), boardCards.stream()).collect(Collectors.toList()));
            opponentHands.add(hand);
        }
        // update player hand stats
/*        playerHandStats.put(playerHand.getType(), playerHandStats.getOrDefault(playerHand.getType(), 0) + 1);
        if (dPlayerHand.isOffSuit()) {
            offSuit++;
            if (dPlayerHand.isPocketPair())
                pocketPair++;
        } else {
            suited++;
        }
        // update games played and wins
        gamesPlayed++;
        PlayingHandComparator handComparator = new PlayingHandComparator();
        if (opponentHands.stream().allMatch(x -> handComparator.compare(playerHand, x) > 0))
            gamesWon++;*/
    }

    protected StartingHand dealPlayerHand(StartingHand hand, Deck deck) {
        StartingHand playerHand = new StartingHand(hand.getCards());
        while (playerHand.size() < 2 && deck.size() > 0)
            playerHand.addCard(deck.draw());
        return playerHand;
    }

    protected List<StartingHand> dealOpponentHands(List<StartingHand> hands, Deck deck) {
        List<StartingHand> l = new ArrayList<>();
        for (StartingHand hand : hands) {
            StartingHand opponentHand = new StartingHand(hand.getCards());
            while (opponentHand.size() < 2 && deck.size() > 0)
                opponentHand.addCard(deck.draw());
            l.add(opponentHand);
        }
        return l;
    }

    protected List<Card> dealBoard(List<Card> board, Deck deck) {
        List<Card> l = new ArrayList<>(board);
        while (l.size() < 5 && deck.size() > 0)
            l.add(deck.draw());
        return l;
    }

    public void printStats() {
        System.out.println("Games played: " + getGamesPlayed());
        System.out.println("Games won: " + getGamesWon());
        System.out.println("Win percentage: %" + getWinPercentage()*100);
//        System.out.println("Number of suited starting hands: " + suited);
//        System.out.println("Number of pocket pairs: " + pocketPair);
        System.out.println("Number of suited starting hands: " + getSuited());
        System.out.println("Number of pocket pairs: " + getPocketPair());
        for (HandEnum handEnum : HandEnum.values()) {
            if (handEnum == HandEnum.UNRANKED) continue;
            System.out.println(String.format("Number of %s: %s", handEnum, getHandStat(handEnum)));
        }
    }
}
