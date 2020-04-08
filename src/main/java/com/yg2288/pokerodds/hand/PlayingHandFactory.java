package com.yg2288.pokerodds.hand;

import com.yg2288.pokerodds.deck.Card;

import java.util.ArrayList;
import java.util.List;

public class PlayingHandFactory {
    public static PlayingHand getBestHand(List<Card> cards) {
        List<List<Card>> l = getCombinations(cards, 5);
        List<PlayingHand> hands = new ArrayList<>();
        for (List<Card> c : l)
            hands.add(PlayingHandFactory.findHand(c));
        PlayingHand hand = hands.stream().max(new PlayingHandComparator()).get();
        return hand;
    }

    public static List<List<Card>> getCombinations(List<Card> cards, int size) {
        List<List<Card>> l = new ArrayList<>();
        List<Card> c = new ArrayList<>(cards);
        c.sort(null);
        int[] used = new int[c.size()];
        helper(c, l, new ArrayList<>(), used, size, 0);
        return l;
    }

    public static void helper(List<Card> cards, List<List<Card>> l, List<Card> cur, int[] used, int size, int start) {
        if (cur.size() == size) {
            l.add(new ArrayList<>(cur));
            return;
        }
        for (int i=start; i<cards.size(); i++) {
            if (i > 0 && cards.get(i).equals(cards.get(i-1)) && used[i-1] == 0)
                continue;
            used[i] = 1;
            cur.add(cards.get(i));
            helper(cards, l, cur, used, size, i+1);
            cur.remove(cur.size()-1);
            used[i] = 0;
        }
    }

    public static PlayingHand findHand(List<Card> cards) {
        if (StraightFlush.isValid(cards))
            return new StraightFlush(cards);
        if (FourOfAKind.isValid(cards))
            return new FourOfAKind(cards);
        if (FullHouse.isValid(cards))
            return new FullHouse(cards);
        if (Flush.isValid(cards))
            return new Flush(cards);
        if (Straight.isValid(cards))
            return new Straight(cards);
        if (ThreeOfAKind.isValid(cards))
            return new ThreeOfAKind(cards);
        if (TwoPair.isValid(cards))
            return new TwoPair(cards);
        if (OnePair.isValid(cards))
            return new OnePair(cards);
        return new HighCard(cards);
    }
}
