# PokerOdds  
Poker odds using monte carlo simulation  

Specify your starting hand:  
```
// Pocket Aces
StartingHand hand = new StartingHand();
hand.addCard(new Card(SPADES, ACE));
hand.addCard(new Card(CLUBS, ACE));
```

Specify the current board:  
```
// This is the flop
List<Card> board = new ArrayList<>();
board.add(new Card(DIAMONDS, KING));
board.add(new Card(CLUBS, KING));
board.add(new Card(HEARTS, TEN));
```

Simulate 1000 games:  
```
// Heads up (1 other player)
PokerSimulator p = new PokerSimulator(hand, 1, board);
p.simulate(1000);
p.printStats();
```

Results:  
```
Games played: 1000
Games won: 875
Win percentage: %87.5
Number of suited starting hands: 0
Number of pocket pairs: 1000
Number of HIGHCARD: 0
Number of ONEPAIR: 0
Number of TWOPAIR: 833
Number of THREEOFAKIND: 0
Number of STRAIGHT: 19
Number of FLUSH: 0
Number of FULLHOUSE: 145
Number of FOUROFAKIND: 3
Number of STRAIGHTFLUSH: 0
```