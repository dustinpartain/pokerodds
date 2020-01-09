package com.yg2288.pokerodds;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static com.yg2288.pokerodds.Card.*;

public class ThreeOfAKindTest {
    protected ThreeOfAKind getHand1() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suit.CLUBS, Rank.ACE));
        cards.add(new Card(Suit.DIAMONDS, Rank.ACE));
        cards.add(new Card(Suit.HEARTS, Rank.ACE));
        cards.add(new Card(Suit.CLUBS, Rank.KING));
        cards.add(new Card(Suit.HEARTS, Rank.FIVE));
        return new ThreeOfAKind(cards);
    }

    protected ThreeOfAKind getHand2() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suit.CLUBS, Rank.KING));
        cards.add(new Card(Suit.DIAMONDS, Rank.KING));
        cards.add(new Card(Suit.HEARTS, Rank.KING));
        cards.add(new Card(Suit.CLUBS, Rank.QUEEN));
        cards.add(new Card(Suit.HEARTS, Rank.TEN));
        return new ThreeOfAKind(cards);
    }

    protected ThreeOfAKind getHand3() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suit.CLUBS, Rank.ACE));
        cards.add(new Card(Suit.DIAMONDS, Rank.ACE));
        cards.add(new Card(Suit.HEARTS, Rank.ACE));
        cards.add(new Card(Suit.CLUBS, Rank.KING));
        cards.add(new Card(Suit.HEARTS, Rank.SIX));
        return new ThreeOfAKind(cards);
    }

    protected ThreeOfAKind getHand4() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suit.SPADES, Rank.ACE));
        cards.add(new Card(Suit.DIAMONDS, Rank.ACE));
        cards.add(new Card(Suit.HEARTS, Rank.ACE));
        cards.add(new Card(Suit.CLUBS, Rank.KING));
        cards.add(new Card(Suit.HEARTS, Rank.SIX));
        return new ThreeOfAKind(cards);
    }

    protected ThreeOfAKind getHand5() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suit.SPADES, Rank.ACE));
        cards.add(new Card(Suit.DIAMONDS, Rank.ACE));
        cards.add(new Card(Suit.HEARTS, Rank.ACE));
        cards.add(new Card(Suit.CLUBS, Rank.QUEEN));
        cards.add(new Card(Suit.HEARTS, Rank.FIVE));
        return new ThreeOfAKind(cards);
    }

    @Test(expected = IllegalArgumentException.class)
    public void threeKindTest1() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suit.CLUBS, Rank.ACE));
        cards.add(new Card(Suit.DIAMONDS, Rank.TEN));
        cards.add(new Card(Suit.HEARTS, Rank.TEN));
        cards.add(new Card(Suit.CLUBS, Rank.KING));
        cards.add(new Card(Suit.HEARTS, Rank.SIX));
        ThreeOfAKind hand = new ThreeOfAKind(cards);
    }

    @Test
    public void threeKindTest2() {
        ThreeOfAKind hand = getHand1();
        assertEquals(hand.getTripletRank(), Rank.ACE);
    }

    @Test
    public void threeKindTest3() {
        ThreeOfAKind hand1 = getHand1();
        ThreeOfAKind hand2 = getHand1();
        assertEquals(hand1.compareTo(hand2), 0);
    }

    @Test
    public void threeKindTest4() {
        ThreeOfAKind hand1 = getHand1();
        ThreeOfAKind hand2 = getHand2();
        assertTrue(hand1.compareTo(hand2) > 0);
    }

    @Test
    public void threeKindTest5() {
        ThreeOfAKind hand1 = getHand1();
        ThreeOfAKind hand2 = getHand3();
        assertTrue(hand1.compareTo(hand2) < 0);
    }

    @Test
    public void threeKindTest6() {
        ThreeOfAKind hand1 = getHand3();
        ThreeOfAKind hand2 = getHand4();
        assertEquals(0, hand1.compareTo(hand2));
    }

    @Test
    public void threeKindTest7() {
        ThreeOfAKind hand1 = getHand1();
        ThreeOfAKind hand2 = getHand5();
        assertTrue(hand1.compareTo(hand2) > 0);
    }
}
