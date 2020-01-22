package com.yg2288.pokerodds;

import java.util.List;

public class PokerSimulator {
    StartingHand playerHand;
    List<StartingHand> opponentHands;

    public PokerSimulator(StartingHand playerHand, List<StartingHand> opponentHands) {
        this.playerHand = playerHand;
        this.opponentHands = opponentHands;
    }
}
