package com.yg2288.pokerodds;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static com.yg2288.pokerodds.Card.*;

public class ThreeOfAKindTest {
    protected ThreeOfAKind getHand1() {
        List<Card> triplet = new ArrayList<>();
        triplet.add(new Card(Suit.CLUBS, Rank.ACE));
        triplet.add(new Card(Suit.DIAMONDS, Rank.ACE));
        triplet.add(new Card(Suit.HEARTS, Rank.ACE));
        List<Card> rest = new ArrayList<>();
        rest.add(new Card(Suit.CLUBS, Rank.KING));
        rest.add(new Card(Suit.HEARTS, Rank.FIVE));
        return new ThreeOfAKind(triplet, rest);
    }

    protected ThreeOfAKind getHand2() {
        List<Card> triplet = new ArrayList<>();
        triplet.add(new Card(Suit.CLUBS, Rank.KING));
        triplet.add(new Card(Suit.DIAMONDS, Rank.KING));
        triplet.add(new Card(Suit.HEARTS, Rank.KING));
        List<Card> rest = new ArrayList<>();
        rest.add(new Card(Suit.CLUBS, Rank.QUEEN));
        rest.add(new Card(Suit.HEARTS, Rank.TEN));
        return new ThreeOfAKind(triplet, rest);
    }

    protected ThreeOfAKind getHand3() {
        List<Card> triplet = new ArrayList<>();
        triplet.add(new Card(Suit.CLUBS, Rank.ACE));
        triplet.add(new Card(Suit.DIAMONDS, Rank.ACE));
        triplet.add(new Card(Suit.HEARTS, Rank.ACE));
        List<Card> rest = new ArrayList<>();
        rest.add(new Card(Suit.CLUBS, Rank.KING));
        rest.add(new Card(Suit.HEARTS, Rank.SIX));
        return new ThreeOfAKind(triplet, rest);
    }

    @Test(expected = IllegalArgumentException.class)
    public void threeKindTest1() {
        List<Card> triplet = new ArrayList<>();
        triplet.add(new Card(Suit.CLUBS, Rank.ACE));
        triplet.add(new Card(Suit.DIAMONDS, Rank.TEN));
        triplet.add(new Card(Suit.HEARTS, Rank.TEN));
        List<Card> rest = new ArrayList<>();
        rest.add(new Card(Suit.CLUBS, Rank.KING));
        rest.add(new Card(Suit.HEARTS, Rank.SIX));
        ThreeOfAKind hand = new ThreeOfAKind(triplet, rest);
    }

    @Test
    public void threeKindTest2() {
        ThreeOfAKind hand = getHand1();
        assertEquals(hand.getTripletRank(), Rank.ACE);
    }
}
