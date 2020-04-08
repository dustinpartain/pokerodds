package com.yg2288.pokerodds;

import com.yg2288.pokerodds.deck.Card;
import com.yg2288.pokerodds.hand.HandEnum;
import com.yg2288.pokerodds.hand.StartingHand;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.LongAdder;

public class PokerSimulator {
    private StartingHand playerHand;
    private List<StartingHand> opponentHands;
    private List<Card> board;

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
        playerHandStats.clear();
        playerHandCounts.clear();
    }

    public int getGamesPlayed() {
        return playerHandCounts.computeIfAbsent("gamesPlayed", k -> new LongAdder()).intValue();
    }

    public int getGamesWon() {
        return playerHandCounts.computeIfAbsent("gamesWon", k -> new LongAdder()).intValue();
    }

    public int getOffSuit() {
        return playerHandCounts.computeIfAbsent("offSuit", k -> new LongAdder()).intValue();
    }

    public int getSuited() {
        return playerHandCounts.computeIfAbsent("suited", k -> new LongAdder()).intValue();
    }

    public int getPocketPair() {
        return playerHandCounts.computeIfAbsent("pocketPair", k -> new LongAdder()).intValue();
    }

    public float getWinPercentage() {
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
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        RecursiveSimulator task = new RecursiveSimulator(games, playerHand, opponentHands, board, playerHandCounts, playerHandStats);
        commonPool.execute(task);
        task.join();
    }

    public void printStats() {
        System.out.println("Games played: " + getGamesPlayed());
        System.out.println("Games won: " + getGamesWon());
        System.out.println("Win percentage: %" + getWinPercentage()*100);
        System.out.println("Number of suited starting hands: " + getSuited());
        System.out.println("Number of pocket pairs: " + getPocketPair());
        System.out.println("Number of suited starting hands: " + getSuited());
        System.out.println("Number of pocket pairs: " + getPocketPair());
        for (HandEnum handEnum : HandEnum.values()) {
            if (handEnum == HandEnum.UNRANKED) continue;
            System.out.println(String.format("Number of %s: %s", handEnum, getHandStat(handEnum)));
        }
    }
}
