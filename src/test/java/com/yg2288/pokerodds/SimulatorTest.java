package com.yg2288.pokerodds;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SimulatorTest {
    @Test
    public void dealPlayerHand1() {
        StartingHand player = new StartingHand();
        List<StartingHand> opponents = new ArrayList<>();
        List<Card> board = new ArrayList<>();
        opponents.add(new StartingHand());
        opponents.add(new StartingHand());
        opponents.add(new StartingHand());
        PokerSimulator p = new PokerSimulator(player, opponents, board);
        Deck deck = new Deck();
        List<Card> playerCards = p.dealPlayerHand(player, deck);
        List<List<Card>> opponentCards = p.dealOpponentHands(opponents, deck);
        assertEquals(2, playerCards.size());
        assertEquals(3, opponentCards.size());
        for (List<Card> c : opponentCards)
            assertEquals(2, c.size());
        assertEquals(44, deck.size());
    }
}
