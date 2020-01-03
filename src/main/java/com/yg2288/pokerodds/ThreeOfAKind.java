package com.yg2288.pokerodds;

import java.util.Collections;
import java.util.List;

public class ThreeOfAKind extends PlayingHand {
    private List<Card> triplet;
    private List<Card> rest;

    protected boolean isThree(List<Card> triplet) {
        if (triplet.size() != 3)
            return false;
        if (triplet.get(0).getRank() != triplet.get(1).getRank() ||
                triplet.get(1).getRank() != triplet.get(2).getRank())
            return false;
        return true;
    }

    public ThreeOfAKind(List<Card> triplet, List<Card> rest) {
        super(triplet);
        if (!isThree(triplet))
            throw new IllegalArgumentException("Not three of a kind. ");
        if (rest.size() != 2)
            throw new IllegalArgumentException("Hand must be 5 cards. ");
        for (Card c : rest)
            cards.add(c.clone());
        Collections.sort(rest);
    }

    public List<Card> getTriplet() {
        return this.triplet;
    }

    protected Card.Rank getTripletRank() {
        return this.triplet.get(0).getRank();
    }
}
