package com.yg2288.pokerodds;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SimulatorTest {
    protected PokerSimulator setupPlayers(int n) {
        StartingHand player = new StartingHand();
        List<StartingHand> opponents = new ArrayList<>();
        for (int i=0; i<n; i++)
            opponents.add(new StartingHand());
        List<Card> board = new ArrayList<>();
        PokerSimulator p = new PokerSimulator(player, opponents, board);
        return p;
    }

    @Test
    public void dealPlayerHand1() {
        PokerSimulator p = setupPlayers(3);
        Deck deck = new Deck();
        List<Card> playerCards = p.dealPlayerHand(p.getPlayerHand(), deck);
        List<List<Card>> opponentCards = p.dealOpponentHands(p.getOpponentHands(), deck);
        assertEquals(2, playerCards.size());
        assertEquals(3, opponentCards.size());
        for (List<Card> c : opponentCards)
            assertEquals(2, c.size());
        assertEquals(44, deck.size());
    }

    @Test
    public void simulateGame1() {
        PokerSimulator p = setupPlayers(1);
        p.simulate(1);
        assertEquals(1, p.getGamesPlayed());
    }

    @Test
    public void simulateGame2() {
        PokerSimulator p = setupPlayers(1);
        p.simulate(1000);
        // One player vs one opponent, play from scratch - win percent should be close to .5
        p.printStats();
        assertTrue(Math.abs(p.getWinPercentage() - 0.5) < 0.1);
    }

    @Test
    public void simulateGame3() {
        StartingHand player = new StartingHand();
        player.addCard(new Card(Card.Suit.SPADES, Card.Rank.ACE));
        player.addCard(new Card(Card.Suit.CLUBS, Card.Rank.ACE));
        List<StartingHand> opponents = new ArrayList<>();
        opponents.add(new StartingHand());
        opponents.add(new StartingHand());
        List<Card> board = new ArrayList<>();
        board.add(new Card(Card.Suit.DIAMONDS, Card.Rank.ACE));
        PokerSimulator p = new PokerSimulator(player, opponents, board);
        p.simulate(1000);
        p.printStats();
    }
}
