package com.yg2288.pokerodds;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards = new ArrayList<>();

    public Deck() {
        fillDeck();
    }

    private void fillDeck() {
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    public int size() {
        return cards.size();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public void reset() {
        cards.clear();
        fillDeck();
    }

    public String toString() {
        return "Deck with " + size() + " cards.";
    }
}
