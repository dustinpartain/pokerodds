package com.yg2288.pokerodds;

import java.util.Collections;
import java.util.List;

public class StartingHand extends Hand {
    public StartingHand() { }

    public StartingHand(List<Card> cards) {
        super(cards);
        if (cards.size() > 2)
            throw new IllegalArgumentException("Cannot have more than 2 cards in starting hand. ");
    }

    @Override
    public boolean addCard(Card card) {
        if (this.size() == 2)
            return false;
        cards.add(card);
        return true;
    }

    public Card highCard() {
        return Collections.max(cards);
    }

    public Card lowCard() {
        return Collections.min(cards);
    }

    public boolean isPocketPair() {
        if (this.size() < 2)
            return false;
        if (cards.get(0).getRank() == cards.get(1).getRank())
            return true;
        return false;
    }
}
