package com.yg2288.pokerodds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PokerSimulator {
    private StartingHand playerHand;
    private List<StartingHand> opponentHands;
    private List<Card> board;

    private int gamesPlayed;
    private int gamesWon;
    private HashMap<HandEnum, Integer> playerHandStats;

    public PokerSimulator(StartingHand playerHand, List<StartingHand> opponentHands, List<Card> board) {
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
        gamesPlayed = gamesWon = 0;
        playerHandStats.clear();
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public float getWinPercentage() {
        return (float)gamesWon / gamesPlayed;
    }

    public HashMap<HandEnum, Integer> getHandStats() {
        return playerHandStats;
    }

    public int getHandStat(HandEnum type) {
        return playerHandStats.getOrDefault(type, 0);
    }

    public void simulate(int games) {

    }

    protected List<Card> dealPlayerHand(StartingHand hand, Deck deck) {
        List<Card> c = hand.getCards();
        while (c.size() < 2 && deck.size() > 0)
            c.add(deck.draw());
        return c;
    }

    protected List<List<Card>> dealOpponentHands(List<StartingHand> hands, Deck deck) {
        List<List<Card>> l = new ArrayList<>();
        for (StartingHand hand : hands) {
            List<Card> c = hand.getCards();
            while (c.size() < 2 && deck.size() > 0)
                c.add(deck.draw());
            l.add(c);
        }
        return l;
    }
}
