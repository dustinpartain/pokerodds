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

    protected StartingHand getPocketAces() {
        StartingHand hand = new StartingHand();
        hand.addCard(new Card(Card.Suit.SPADES, Card.Rank.ACE));
        hand.addCard(new Card(Card.Suit.CLUBS, Card.Rank.ACE));
        return hand;
    }

    @Test
    public void dealPlayerHand1() {
        PokerSimulator p = setupPlayers(3);
        Deck deck = new Deck();
        StartingHand dPlayerHand = p.dealPlayerHand(p.getPlayerHand(), deck);
        List<StartingHand> dOpponentHands = p.dealOpponentHands(p.getOpponentHands(), deck);
        List<Card> playerCards = dPlayerHand.getCards();
        List<List<Card>> opponentCards = new ArrayList<>();
        for (StartingHand o : dOpponentHands)
            opponentCards.add(o.getCards());
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
        System.out.println();
        assertTrue(Math.abs(p.getWinPercentage() - 0.5) < 0.1);
    }

    @Test
    public void simulateGame3() {
        StartingHand player = getPocketAces();
        List<StartingHand> opponents = new ArrayList<>();
        opponents.add(new StartingHand());
        opponents.add(new StartingHand());
        List<Card> board = new ArrayList<>();
        board.add(new Card(Card.Suit.DIAMONDS, Card.Rank.ACE));
        PokerSimulator p = new PokerSimulator(player, opponents, board);
        p.simulate(1000);
        p.printStats();
        System.out.println();
        // At minimum we have three of a kind
        assertEquals(0, p.getHandStat(HandEnum.HIGHCARD));
        assertEquals(0, p.getHandStat(HandEnum.ONEPAIR));
        assertEquals(0, p.getHandStat(HandEnum.TWOPAIR));
    }

    @Test
    public void simulateCreateDefaultOpponents() {
        StartingHand player = getPocketAces();
        List<Card> board = new ArrayList<>();
        board.add(new Card(Card.Suit.DIAMONDS, Card.Rank.ACE));
        PokerSimulator p = new PokerSimulator(player, 2, board);
        assertEquals(2, p.getOpponentHands().size());
    }
}
