package com.yg2288.pokerodds;

import java.util.List;

public class PlayingHand extends Hand {
    public PlayingHand(List<Card> cards) {
        super(cards);
        if (cards.size() > 5)
            throw new IllegalArgumentException("Playing hand can not be larger than 5 cards");
    }

    @Override
    public boolean addCard(Card c) {
        if (this.size() < 5){
            return super.addCard(c);
        }
        return false;
    }
}
