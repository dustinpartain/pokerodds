package com.yg2288.pokerodds;

import java.util.List;

public class ThreeOfAKind extends PlayingHand {
    List<Card> three;
    List<Card> rest;

    protected boolean isThree(List<Card> three) {
        if (three.size() != 3)
            return false;
        if (three.get(0).getRank() != three.get(1).getRank() &&
            three.get(1).getRank() != three.get(2).getRank())
            return false;
        return true;
    }

    public ThreeOfAKind(List<Card> three, List<Card> rest) {
        super(three);
        if (!isThree(three))
            throw new IllegalArgumentException("Not three of a kind. ");
        if (rest.size() != 2)
            throw new IllegalArgumentException("Hand must be 5 cards. ");
        for (Card c : rest)
            cards.add(c.clone());
    }
}
