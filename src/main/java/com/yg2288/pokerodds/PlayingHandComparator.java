package com.yg2288.pokerodds;

import java.util.Comparator;

public class PlayingHandComparator implements Comparator<PlayingHand> {
    public int compare(PlayingHand one, PlayingHand two) {
        if (one.getType() != two.getType())
            return one.getType().compareTo(two.getType());
        if (one instanceof HighCard)
            return ((HighCard) one).compareTo((HighCard) two);
        if (one instanceof OnePair)
            return ((OnePair) one).compareTo((OnePair) two);
        if (one instanceof TwoPair)
            return ((TwoPair) one).compareTo((TwoPair) two);
        if (one instanceof ThreeOfAKind)
            return ((ThreeOfAKind) one).compareTo((ThreeOfAKind) two);
        if (one instanceof Straight)
            return ((Straight) one).compareTo((Straight) two);
        if (one instanceof Flush)
            return ((Flush) one).compareTo((Flush) two);
        if (one instanceof FullHouse)
            return ((FullHouse) one).compareTo((FullHouse) two);
        if (one instanceof FourOfAKind)
            return ((FourOfAKind) one).compareTo((FourOfAKind) two);
        if (one instanceof StraightFlush)
            return ((StraightFlush) one).compareTo((StraightFlush) two);
        return 0;
    }
}
