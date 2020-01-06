package com.yg2288.pokerodds;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FullHouse extends PlayingHand {
    public static final HandEnum type = HandEnum.FULLHOUSE;

    private List<Card> triplet;
    private List<Card> pair;

    public static boolean isFullHouse(List<Card> cards) {
        if (cards.size() != 5)
            return false;
        int[] count = new int[15];
        for (Card c: cards) {
            count[c.getRank().ordinal()]++;
        }
        boolean hasTriplet = false;
        boolean hasPair = false;
        for (int i : count) {
            if (i == 2)
                hasPair = true;
            if (i == 3)
                hasTriplet = true;
        }
        return hasPair && hasTriplet;
    }

    public FullHouse(List<Card> cards) {
        super(cards);
        if (!isFullHouse(cards))
            throw new IllegalArgumentException("Not a full house. ");
        this.triplet = findPair(this.cards, 3);
        this.pair = findPair(this.cards, 2);
    }

    protected List<Card> findPair(List<Card> cards, int count) {
        List<List<Card>> triplet = new ArrayList<>();
        for (int i=0; i<15; i++)
            triplet.add(new ArrayList<>());
        for (int i=0; i<cards.size(); i++) {
            Card c = cards.get(i);
            if (triplet.get(c.getRank().ordinal()) == null)
                triplet.set(c.getRank().ordinal(), new ArrayList<>());
            triplet.get(c.getRank().ordinal()).add(c);
        }
        for (List<Card> cardList : triplet) {
            if (cardList.size() == count)
                return cardList;
        }
        return null;
    }

    public Card.Rank getTripletRank() {
        return this.triplet.get(0).getRank();
    }

    public Card.Rank getPairRank() {
        return this.pair.get(0).getRank();
    }
}
