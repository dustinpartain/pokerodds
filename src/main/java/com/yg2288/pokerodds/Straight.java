package com.yg2288.pokerodds;

import java.util.Collections;
import java.util.List;

public class Straight extends PlayingHand {
    public static final HandEnum type = HandEnum.STRAIGHT;

    public Straight(List<Card> cards) {
        super(cards);
        Collections.sort(this.cards, Collections.reverseOrder());
    }

    public Card getHighCard() {
        return cards.get(0);
    }
}
