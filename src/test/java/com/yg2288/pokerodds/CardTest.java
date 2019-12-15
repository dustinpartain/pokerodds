package com.yg2288.pokerodds;

import org.junit.Assert;
import org.junit.Test;

public class CardTest {
    @Test
    public void cardTest1() {
        Card card = new Card(Suit.DIAMONDS, CardValue.ACE);
        Assert.assertTrue(card.toString().equals("ACE of DIAMONDS"));
    }

    @Test
    public void cardTest2() {
        Card card = new Card(Suit.CLUBS, CardValue.TWO);
        Assert.assertTrue(card.toString().equals("2 of CLUBS"));
    }

    @Test
    public void cardTest3() {
        Card card = new Card(Suit.HEARTS, CardValue.TEN);
        Assert.assertTrue(card.toString().equals("10 of HEARTS"));
    }

    @Test
    public void cardTest4() {
        Assert.assertTrue(CardValue.TEN.getValue() == 10);
    }

    @Test
    public void cardTest5() {
        Assert.assertTrue(CardValue.ACE.getValue() == 14);
    }
}
