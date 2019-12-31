package com.yg2288.pokerodds;

import java.util.Collections;
import java.util.List;

public class HighCard extends PlayingHand implements Comparable<HighCard> {
    public final HandEnum type = HandEnum.HIGHCARD;

    public HighCard(List<Card> cards) {
        super(cards);
        this.cards.sort(Collections.reverseOrder());
    }

    public Card highCard() {
        return Collections.max(cards);
    }

    public Card lowCard() {
        return Collections.min(cards);
    }

    @Override
    public int compareTo(HighCard highCard) {
        if (this.size() > highCard.size())
            return 1;
        if (this.size() < highCard.size())
            return -1;
        for (int i=0; i<this.size(); i++) {
            int cmp = this.getCard(i).compareTo(highCard.getCard(i));
            if (cmp != 0)
                return cmp;
        }
        return 0;
    }
}
