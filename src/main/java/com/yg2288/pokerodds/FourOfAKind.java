package com.yg2288.pokerodds;

import static com.yg2288.pokerodds.Card.*;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class FourOfAKind extends PlayingHand implements Comparable<FourOfAKind> {
    public static final HandEnum type = HandEnum.FOUROFAKIND;

    public static boolean isFourOfAKind(List<Card> cards) {
        if (cards.size() != 5)
            return false;
        int[] count = new int[13];
        for (Card c : cards)
            count[c.getRank().ordinal()]++;
        for (int i : count)
            if (i == 4)
                return true;
        return false;
    }

    protected List<Card> quad;
    protected Card kicker;

    public FourOfAKind(List<Card> cards) {
        super(cards);
        if (!isFourOfAKind(cards))
            throw new IllegalArgumentException("Not four of a kind. ");
        quad = findSame(this.cards, 4);
        kicker = findSame(this.cards, 1).get(0);
    }

    protected List<Card> findSame(List<Card> cards, int count) {
        List<List<Card>> l = new ArrayList<>();
        for (int i=0; i<13; i++) {
            l.add(new ArrayList<>());
        }
        for (Card c : cards)
            l.get(c.getRank().ordinal()).add(c);
        for (List<Card> c : l)
            if (c.size() == count)
                return c;
        return null;
    }

    protected Rank getQuadRank() {
        return quad.get(0).getRank();
    }

    protected Rank getKickerRank() {
        return kicker.getRank();
    }

    @Override
    public int compareTo(FourOfAKind anotherFour) {
        if (this.getQuadRank() != anotherFour.getQuadRank())
            return this.getQuadRank().compareTo(anotherFour.getQuadRank());
        return this.kicker.compareTo(anotherFour.kicker);
    }
}
