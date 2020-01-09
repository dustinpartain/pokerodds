package com.yg2288.pokerodds;

import java.util.Arrays;
import java.util.List;

public class TwoPair extends PlayingHand implements Comparable<TwoPair> {
    public static final HandEnum type = HandEnum.TWOPAIR;

    private List<Card> pair1;
    private List<Card> pair2;
    private Card kicker;

    public static boolean isValid(List<Card> cards) {
        if (cards.size() != 5)
            return false;
        int[] profile = {10, 1, 2, 0, 0};
        if (!Arrays.equals(profile, PlayingHand.getProfile(cards)))
            return false;
        return true;
    }

    protected boolean isPair(List<Card> pair) {
        if (pair.size() != 2)
            return false;
        if (pair.get(0).getRank() != pair.get(1).getRank())
            return false;
        return true;
    }

    public TwoPair(List<Card> cards) {
        super(cards);
        if (!isValid(this.cards))
            throw new IllegalArgumentException("Must have two pairs. ");
        List<List<Card>> bucket = PlayingHand.getBuckets(this.cards);
        for (List<Card> l : bucket) {
            if (l.size() == 2) {
                if (pair2 == null) pair2 = l;
                else pair1 = l;
            } else if (l.size() == 1)
                kicker = l.get(0);
        }
    }

    protected Card.Rank getHighPairRank() {
        return pair1.get(0).getRank();
    }

    protected Card.Rank getLowPairRank() {
        return pair2.get(0).getRank();
    }

    @Override
    public int compareTo(TwoPair twoPair) {
        if (getHighPairRank() != twoPair.getHighPairRank())
            return getHighPairRank().compareTo(twoPair.getHighPairRank());
        if (getLowPairRank() != twoPair.getLowPairRank())
            return getLowPairRank().compareTo(twoPair.getLowPairRank());
        return kicker.getRank().compareTo(twoPair.kicker.getRank());
    }
}
