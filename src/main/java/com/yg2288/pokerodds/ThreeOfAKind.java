package com.yg2288.pokerodds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeOfAKind extends PlayingHand implements Comparable<ThreeOfAKind> {
    private List<Card> triplet;
    private List<Card> rest;

    public static boolean isValid(List<Card> cards) {
        if (cards.size() != 5)
            return false;
        int[] profile = {10, 2, 0, 1, 0};
        if (!Arrays.equals(profile, PlayingHand.getProfile(cards)))
            return false;
        return true;
    }

    public ThreeOfAKind(List<Card> cards) {
        super(cards);
        if (!isValid(this.cards))
            throw new IllegalArgumentException("Not three of a kind. ");
        List<List<Card>> bucket = PlayingHand.getBuckets(this.cards);
        rest = new ArrayList<>();
        for (List<Card> l : bucket) {
            if (l.size() == 3)
                triplet = l;
            else if (l.size() == 1)
                rest.addAll(l);
        }
        Collections.sort(rest, Collections.reverseOrder());
        setType(HandEnum.THREEOFAKIND);
    }

    public List<Card> getTriplet() {
        return triplet;
    }

    protected Card.Rank getTripletRank() {
        return triplet.get(0).getRank();
    }

    @Override
    public int compareTo(ThreeOfAKind threeOfAKind) {
        if (this.getTripletRank() != threeOfAKind.getTripletRank())
            return this.getTripletRank().compareTo(threeOfAKind.getTripletRank());
        for (int i=0; i<2; i++) {
            if (this.rest.get(i).getRank() != threeOfAKind.rest.get(i).getRank())
                return this.rest.get(i).getRank().compareTo(threeOfAKind.rest.get(i).getRank());
        }
        return 0;
    }
}
