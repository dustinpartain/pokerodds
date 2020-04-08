package com.yg2288.pokerodds;

import com.yg2288.pokerodds.deck.Card;
import com.yg2288.pokerodds.deck.Deck;
import com.yg2288.pokerodds.hand.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RecursiveSimulator extends RecursiveAction {
    private int work;
    private static final int THRESHOLD = 5;

    StartingHand playerHand;
    List<StartingHand> opponentHands;
    List<Card> board;
    ConcurrentHashMap<String, LongAdder> handCounts;
    ConcurrentHashMap<HandEnum, LongAdder> handStats;

    public RecursiveSimulator(int n, StartingHand playerHand, List<StartingHand> opponentHands, List<Card> board,
                              ConcurrentHashMap<String, LongAdder> handCounts, ConcurrentHashMap<HandEnum, LongAdder> handStats) {
        this.work = n;
        this.playerHand = playerHand;
        this.opponentHands = opponentHands;
        this.board = board;
        this.handCounts = handCounts;
        this.handStats = handStats;
    }

    @Override
    protected void compute() {
        if (work > THRESHOLD)
            ForkJoinTask.invokeAll(createSubtasks());
        else simulateGames();
    }

    private Collection<RecursiveSimulator> createSubtasks() {
        List<RecursiveSimulator> l = new ArrayList<>();
        l.add(new RecursiveSimulator(work/2, playerHand, opponentHands, board, handCounts, handStats));
        l.add(new RecursiveSimulator(work - work/2, playerHand, opponentHands, board, handCounts, handStats));
        return l;
    }

    private void simulateGames() {
        for (; work > 0; work--)
            simulateOneGame(playerHand, opponentHands, board, handCounts, handStats);
    }

    private void simulateOneGame(StartingHand player, List<StartingHand> opponents, List<Card> board,
                                 ConcurrentHashMap<String, LongAdder> playerHandCounts,
                                 ConcurrentHashMap<HandEnum, LongAdder> playerHandStats) {
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
        playerHandStats.computeIfAbsent(playerHand.getType(), k -> new LongAdder()).increment();
        if (dPlayerHand.isOffSuit()) {
            playerHandCounts.computeIfAbsent("offSuit", k -> new LongAdder()).increment();
            if (dPlayerHand.isPocketPair())
                playerHandCounts.computeIfAbsent("pocketPair", k -> new LongAdder()).increment();
        } else {
            playerHandCounts.computeIfAbsent("suited", k -> new LongAdder()).increment();
        }
        // update games played and wins
        playerHandCounts.computeIfAbsent("gamesPlayed", k -> new LongAdder()).increment();
        PlayingHandComparator handComparator = new PlayingHandComparator();
        if (opponentHands.stream().allMatch(x -> handComparator.compare(playerHand, x) > 0))
            playerHandCounts.computeIfAbsent("gamesWon", k -> new LongAdder()).increment();
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
}
