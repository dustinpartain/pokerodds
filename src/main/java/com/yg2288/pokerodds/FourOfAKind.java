package com.yg2288.pokerodds;

import static com.yg2288.pokerodds.Card.*;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class FourOfAKind extends PlayingHand implements Comparable<FourOfAKind> {

    public static boolean isValid(List<Card> cards) {
        if (cards.size() != 5)
            return false;
        int[] profile = {11, 1, 0, 0, 1};
        if (!Arrays.equals(profile, PlayingHand.getProfile(cards)))
            return false;
        return true;
    }

    protected List<Card> quad;
    protected Card kicker;

    public FourOfAKind(List<Card> cards) {
        super(cards);
        if (!isValid(this.cards))
            throw new IllegalArgumentException("Not four of a kind. ");
        List<List<Card>> bucket = PlayingHand.getBuckets(this.cards);
        for (List<Card> l : bucket) {
            if (l.size() == 1)
                kicker = l.get(0);
            if (l.size() == 4)
                quad = l;
        }
        setType(HandEnum.FOUROFAKIND);
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
