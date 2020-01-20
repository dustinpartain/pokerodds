package com.yg2288.pokerodds;

import java.util.Collections;
import java.util.List;

public class Flush extends PlayingHand implements Comparable<Flush> {
    private Card.Suit flushSuit;

    public static boolean isValid(List<Card> cards) {
        if (cards.size() != 5)
            return false;
        return cards.stream().allMatch(c -> c.getSuit() == cards.get(0).getSuit());
    }

    public Flush(List<Card> cards) {
        super(cards);
        if (!isValid(this.cards))
            throw new IllegalArgumentException("Not a flush. ");

        Collections.sort(this.cards, Collections.reverseOrder());
        flushSuit = this.cards.get(0).getSuit();
        setType(HandEnum.FLUSH);
    }

    public Card.Suit getFlushSuit() {
        return flushSuit;
    }

    @Override
    public int compareTo(Flush anotherFlush) {
        for (int i=0; i<cards.size(); i++) {
            if (cards.get(i).getRank() != anotherFlush.getCard(i).getRank())
                return cards.get(i).getRank().compareTo(anotherFlush.getCard(i).getRank());
        }
        return 0;
    }
}
