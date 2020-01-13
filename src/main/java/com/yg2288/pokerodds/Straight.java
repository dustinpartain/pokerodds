package com.yg2288.pokerodds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Straight extends PlayingHand implements Comparable<Straight> {
    public static final HandEnum type = HandEnum.STRAIGHT;

    public static boolean isValid(List<Card> cards) {
        if (cards.size() != 5)
            return false;
        ArrayList<Card> c = new ArrayList<>(cards);
        Collections.sort(c, Collections.reverseOrder());
        if (c.get(0).getRank() == Card.Rank.ACE) {
            if (c.get(1).getRank() == Card.Rank.KING || c.get(1).getRank() == Card.Rank.FIVE ) {
                for (int i=1; i<4; i++) {
                    if (c.get(i).getRank().compareTo(c.get(i + 1).getRank()) != 1)
                        return false;
                }
                return true;
            } else {
                return false;
            }
        }
        for (int i=0; i<4; i++) {
            if (c.get(i).getRank().compareTo(c.get(i+1).getRank()) != 1)
                return false;
        }
        return true;
    }

    public Straight(List<Card> cards) {
        super(cards);
        if (!isValid(this.cards))
            throw new IllegalArgumentException("Must be a straight. ");
        Collections.sort(this.cards, Collections.reverseOrder());
    }

    public Card getHighCard() {
        if (cards.get(0).getRank() == Card.Rank.ACE) {
            if (cards.get(1).getRank() == Card.Rank.KING)
                return cards.get(0);
            return cards.get(1);
        }
        return cards.get(0);
    }

    @Override
    public int compareTo(Straight anotherStraight) {
        return this.getHighCard().getRank().compareTo(anotherStraight.getHighCard().getRank());
    }
}
