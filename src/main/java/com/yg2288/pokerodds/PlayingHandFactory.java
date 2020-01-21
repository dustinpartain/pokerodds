package com.yg2288.pokerodds;

import java.util.ArrayList;
import java.util.List;

public class PlayingHandFactory {
    public static PlayingHand getBestHand(List<Card> cards) {
        return null;
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

    public static PlayingHand bestHand(List<Card> cards) {
        return null;
    }
}
