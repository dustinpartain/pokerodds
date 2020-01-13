package com.yg2288.pokerodds;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FullHouse extends PlayingHand implements Comparable<FullHouse> {
    public static final HandEnum type = HandEnum.FULLHOUSE;

    private List<Card> triplet;
    private List<Card> pair;

    public static boolean isValid(List<Card> cards) {
        if (cards.size() != 5)
            return false;
        int[] profile = {11, 0, 1, 1, 0};
        if (!Arrays.equals(profile, PlayingHand.getProfile(cards)))
            return false;
        return true;
    }

    public FullHouse(List<Card> cards) {
        super(cards);
        if (!isValid(this.cards))
            throw new IllegalArgumentException("Not a full house. ");
        List<List<Card>> bucket = PlayingHand.getBuckets(this.cards);
        for (List<Card> l : bucket) {
            if (l.size() == 3)
                this.triplet = l;
            if (l.size() == 2)
                this.pair = l;
        }
    }

    public Card.Rank getTripletRank() {
        return this.triplet.get(0).getRank();
    }

    public Card.Rank getPairRank() {
        return this.pair.get(0).getRank();
    }

    @Override
    public int compareTo(FullHouse anotherFullHouse) {
        if (getTripletRank() != anotherFullHouse.getTripletRank())
            return getTripletRank().compareTo(anotherFullHouse.getTripletRank());
        if (getPairRank() != anotherFullHouse.getPairRank())
            return getPairRank().compareTo(anotherFullHouse.getPairRank());
        return 0;
    }
}
