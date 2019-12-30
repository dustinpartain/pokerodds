package com.yg2288.pokerodds;

import java.util.Collections;
import java.util.List;

public class HighCard extends PlayingHand {
    public final HandEnum type = HandEnum.HIGHCARD;

    public HighCard(List<Card> cards) {
        super(cards);
    }

    public Card highCard() {
        return Collections.max(cards);
    }

    public Card lowCard() {
        return Collections.min(cards);
    }
}
