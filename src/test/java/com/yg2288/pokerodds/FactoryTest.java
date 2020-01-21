package com.yg2288.pokerodds;

import static com.yg2288.pokerodds.Card.Rank.*;
import static com.yg2288.pokerodds.Card.Suit.*;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FactoryTest {
    protected List<Card> getCards1() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(CLUBS, NINE));
        cards.add(new Card(CLUBS, EIGHT));
        cards.add(new Card(CLUBS, SEVEN));
        cards.add(new Card(CLUBS, SIX));
        cards.add(new Card(CLUBS, FIVE));
        cards.add(new Card(CLUBS, FOUR));
        cards.add(new Card(CLUBS, THREE));
        return cards;
    }

    protected List<Card> getCards2() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(CLUBS, THREE));
        cards.add(new Card(CLUBS, FOUR));
        cards.add(new Card(CLUBS, FIVE));
        return cards;
    }

    protected List<Card> getCards3() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(CLUBS, THREE));
        cards.add(new Card(CLUBS, THREE));
        cards.add(new Card(CLUBS, THREE));
        return cards;
    }

    @Test
    public void combinationTest1() {
        List<Card> cards = getCards1();
        // 7 choose 5 = 21
        List<List<Card>> l = PlayingHandFactory.getCombinations(cards, 5);
        assertEquals(21, l.size());
        // 7 choose 7 = 1
        l = PlayingHandFactory.getCombinations(cards, 7);
        assertEquals(1, l.size());
    }

    @Test
    public void combinationTest2() {
        List<Card> cards = getCards2();
        List<List<Card>> l = PlayingHandFactory.getCombinations(cards, 2);
        assertEquals(3, l.size());
        List<List<Card>> r = new ArrayList<>();
        r.add(Arrays.asList(cards.get(0), cards.get(1)));
        r.add(Arrays.asList(cards.get(0), cards.get(2)));
        r.add(Arrays.asList(cards.get(1), cards.get(2)));
        for (int i=0; i<l.size(); i++) {
            assertEquals(2, l.get(i).size());
            assertEquals(r.get(i).get(0), l.get(i).get(0));
            assertEquals(r.get(i).get(1), l.get(i).get(1));
        }
    }

    @Test
    public void combinationTest3() {
        List<Card> cards = getCards3();
        List<List<Card>> l = PlayingHandFactory.getCombinations(cards, 2);
        assertEquals(1, l.size());
        assertEquals(2, l.get(0).size());
    }
}

class ListComparator<T extends Comparable<T>> implements Comparator<List<T>> {
    public int compare(List<T> a, List<T> b) {
        a = new ArrayList<>(a);
        b = new ArrayList<>(b);
        a.sort(null);
        b.sort(null);
        for (int i=0; i<a.size(); i++) {
            if (a.get(i).compareTo(b.get(i)) != 0)
                return a.get(i).compareTo(b.get(i));
        }
        return 0;
    }
}