package com.yg2288.pokerodds;

import java.util.Collections;
import java.util.List;

import static com.yg2288.pokerodds.Card.*;

public class StraightFlush extends PlayingHand {
    public static final HandEnum type = HandEnum.STRAIGHTFLUSH;

    public static boolean isStraightFlush(List<Card> cards) {
        if (Flush.isFlush(cards) && Straight.isStraight(cards))
            return true;
        return false;
    }

    protected Card highCard;

    public StraightFlush(List<Card> cards) {
        super(cards);
        if (!isStraightFlush(cards))
            throw new IllegalArgumentException("Not a straight flush. ");
        Collections.sort(this.cards, Collections.reverseOrder());
        highCard = this.cards.get(0);
    }

    public Rank getStraightFlushRank() {
        return highCard.getRank();
    }
}
