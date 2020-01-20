package com.yg2288.pokerodds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OnePair extends PlayingHand implements Comparable<OnePair> {

    private List<Card> pair;
    private List<Card> rest;

    public static boolean isValid(List<Card> cards) {
        if (cards.size() != 5)
            return false;
        int[] profile = {9, 3, 1, 0, 0};
        if (!Arrays.equals(profile, PlayingHand.getProfile(cards)))
            return false;
        return true;
    }

    public OnePair(List<Card> cards) {
        super(cards);
        if (!OnePair.isValid(this.cards))
            throw new IllegalArgumentException("Not a one pair hand. ");
        List<List<Card>> bucket = PlayingHand.getBuckets(this.cards);
        rest = new ArrayList<>();
        for (List<Card> l : bucket) {
            if (l.size() == 2) pair = l;
            else if (l.size() == 1) rest.addAll(l);
        }
        Collections.sort(rest, Collections.reverseOrder());
        setType(HandEnum.ONEPAIR);
    }

    protected Card.Rank getPairRank() {
        return pair.get(0).getRank();
    }

    @Override
    public int compareTo(OnePair onePair) {
        if (getPairRank() != onePair.getPairRank())
            return getPairRank().compareTo(onePair.getPairRank());
        for (int i=0; i<rest.size(); i++) {
            if (rest.get(i).getRank() != onePair.rest.get(i).getRank())
                return rest.get(i).getRank().compareTo(onePair.rest.get(i).getRank());
        }
        return 0;
    }
}
