package com.yg2288.pokerodds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OnePair extends PlayingHand implements Comparable<OnePair> {
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

    public Card.Rank getPairRank() {
        return this.getPair().get(0).getRank();
    }

    @Override
    public int compareTo(OnePair onePair) {
        int cmp = this.getPairRank().compareTo(onePair.getPairRank());
        if (cmp != 0)
            return cmp;
        for (int i=0; i<rest.size(); i++) {
            cmp = rest.get(i).getRank().compareTo(onePair.rest.get(i).getRank());
            if (cmp != 0)
                return cmp;
        }
        return 0;
    }
}
