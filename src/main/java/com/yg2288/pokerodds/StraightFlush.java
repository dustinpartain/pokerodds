package com.yg2288.pokerodds;

import java.util.Collections;
import java.util.List;

import static com.yg2288.pokerodds.Card.*;

public class StraightFlush extends PlayingHand implements Comparable<StraightFlush> {
    public static final HandEnum type = HandEnum.STRAIGHTFLUSH;

    public static boolean isValid(List<Card> cards) {
        if (Flush.isValid(cards) && Straight.isValid(cards))
            return true;
        return false;
    }

    protected Card highCard;

    public StraightFlush(List<Card> cards) {
        super(cards);
        if (!isValid(this.cards))
            throw new IllegalArgumentException("Not a straight flush. ");
        Collections.sort(this.cards, Collections.reverseOrder());
        highCard = getHighCard();
        setType(HandEnum.STRAIGHTFLUSH);
    }

    public Card getHighCard() {
        if (cards.get(0).getRank() == Rank.ACE) {
            if (cards.get(1).getRank() == Rank.FIVE)
                return cards.get(1);
            return cards.get(0);
        }
        return cards.get(0);
    }

    public Rank getStraightFlushRank() {
        return highCard.getRank();
    }

    @Override
    public int compareTo(StraightFlush anotherStraight) {
        return this.highCard.compareTo(anotherStraight.highCard);
    }
}
