package com.yg2288.pokerodds;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class RecursiveSimulator extends RecursiveAction {
    private int work;
    private static final int THRESHOLD = 5;

    StartingHand playerHand;
    List<StartingHand> opponentHands;
    List<Card> board;
    ConcurrentHashMap<String, Integer> handCounts;
    ConcurrentHashMap<HandEnum, Integer> handStats;

    public RecursiveSimulator(int n, StartingHand playerHand, List<StartingHand> opponentHands, List<Card> board,
                              ConcurrentHashMap<String, Integer> handCounts, ConcurrentHashMap<HandEnum, Integer> handStats) {
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
        return null;
    }

    private void simulateGames() {

    }
}
