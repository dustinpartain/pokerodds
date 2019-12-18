package com.yg2288.pokerodds;

import java.util.ArrayList;
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

    public boolean inDeck(Card card) {
        for (Card c : cards) {
            if (c.equals(card)) return true;
        }
        return false;
    }

    public boolean addCard(Card card) {
        if (inDeck(card)) return false;
        cards.add(card);
        return true;
    }

    public boolean removeCard(Card card) {
        for (Card c : cards) {
            if (c.equals(card)) {
                cards.remove(c);
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "Deck with " + size() + " cards.";
    }
}
