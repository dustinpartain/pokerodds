package com.yg2288.pokerodds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand {
    protected List<Card> cards = new ArrayList<>();

    public Hand() { }

    public Hand(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        if (cards.size() == 0) {
            return "Hand is empty.";
        }
        StringBuilder s = new StringBuilder();
        for (Card c : cards) {
            s.append(c.toString());
        }
        return s.toString();
    }

    public int size() {
        return cards.size();
    }

    public boolean addCard(Card c) {
        cards.add(c);
        return true;
    }

    public Card getCard(int i) {
        return cards.get(i);
    }

}
