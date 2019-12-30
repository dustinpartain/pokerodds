package com.yg2288.pokerodds;

import java.util.List;

public class StartingHand extends Hand {
    public StartingHand(List<Card> cards) {
        super(cards);
        if (cards.size() > 2)
            throw new IllegalArgumentException("Cannot have more than 2 cards in starting hand. ");
    }
}
