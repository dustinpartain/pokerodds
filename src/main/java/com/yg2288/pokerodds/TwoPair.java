package com.yg2288.pokerodds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TwoPair extends PlayingHand implements Comparable<TwoPair> {
    public static final HandEnum type = HandEnum.TWOPAIR;

    private List<Card> pair1;
    private List<Card> pair2;
    private Card kicker;

    protected boolean isPair(List<Card> pair) {
        if (pair.size() != 2)
            return false;
        if (pair.get(0).getRank() != pair.get(1).getRank())
            return false;
        return true;
    }

    public TwoPair(List<Card> pair1, List<Card> pair2, Card kicker) {
        super(pair1);
        if (!isPair(pair1) || !isPair(pair2))
            throw new IllegalArgumentException("Must have two pairs. ");
        for (Card card : pair2)
            this.addCard(card.clone());
        this.addCard(kicker.clone());
        this.pair1 = this.cards.subList(0, 2);
        this.pair2 = this.cards.subList(2, 4);
        this.kicker = this.cards.get(4);
    }

    public List<Card> getHighPair() {
        if (pair1.get(0).compareTo(pair2.get(0)) > 0)
            return pair1;
        return pair2;
    }

    public List<Card> getLowPair() {
        if (pair1.get(0).compareTo(pair2.get(0)) < 0)
            return pair1;
        return pair2;
    }

    @Override
    public int compareTo(TwoPair twoPair) {
        int cmp = this.getHighPair().get(0).compareTo(twoPair.getHighPair().get(0));
        if (cmp != 0)
            return cmp;
        cmp = this.getLowPair().get(0).compareTo(twoPair.getLowPair().get(0));
        if (cmp != 0)
            return cmp;
        return this.kicker.compareTo(twoPair.kicker);
    }
}
