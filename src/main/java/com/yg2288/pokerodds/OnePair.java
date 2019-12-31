package com.yg2288.pokerodds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OnePair extends PlayingHand {
    public static final HandEnum type = HandEnum.ONEPAIR;

    private List<Card> pair;
    private List<Card> rest;

    public OnePair(List<Card> pair, List<Card> rest) {
        super(pair);
        if (pair.size() != 2 || pair.get(0).getRank() != pair.get(1).getRank())
            throw new IllegalArgumentException("This is not a pair. ");
        if (rest.size() != 3)
            throw new IllegalArgumentException("Hand must be five cards. ");
        rest = new ArrayList<>(rest);
        Collections.sort(rest);
        this.pair = pair;
        this.rest = rest;
        for (Card c : rest)
            this.addCard(c.clone());
    }

    public List<Card> getPair() {
        return pair;
    }
}
