package com.yg2288.pokerodds;

import java.util.ArrayList;
import java.util.List;

public class PlayingHand extends Hand {
    public PlayingHand(List<Card> cards) {
        super(cards);
        if (cards.size() > 5)
            throw new IllegalArgumentException("Playing hand can not be larger than 5 cards");
    }

    protected int[] getProfile() {
        int[] count = new int[13];
        for (Card c : cards)
            count[c.getRank().ordinal()]++;
        int[] profile = new int[5];
        for (int i : count)
            profile[i]++;
        return profile;
    }

    protected List<List<Card>> getBuckets() {
        List<List<Card>> buckets = new ArrayList<>();
        for (int i=0; i<13; i++)
            buckets.add(new ArrayList<>());
        for (Card c : cards)
            buckets.get(c.getRank().ordinal()).add(c);
        return buckets;
    }

    @Override
    public boolean addCard(Card c) {
        if (this.size() < 5){
            return super.addCard(c);
        }
        return false;
    }
}
