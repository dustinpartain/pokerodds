package com.yg2288.pokerodds.deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards = new ArrayList<>();

    public Deck() {
        fillDeck();
    }

    public Deck(List<Card> excludeCards) {
        fillDeck(excludeCards);
    }

    private void fillDeck() {
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    private void fillDeck(List<Card> excludeCards) {
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                Card c = new Card(suit, rank);
                if (!(excludeCards.contains(c)))
                    cards.add(c);
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

    public void clear() {
        cards.clear();
    }

    public Card draw() {
        if (cards.size() > 0) {
            return cards.remove(cards.size() - 1);
        }
        return null;
    }

    public List<Card> draw(int n) {
        List<Card> l = new ArrayList<>();
        while (n-- > 0 && cards.size() > 0) {
            l.add(this.draw());
        }
        return l;
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

    @Override
    public String toString() {
        return "Deck with " + size() + " cards.";
    }
}
