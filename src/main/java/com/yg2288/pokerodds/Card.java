package com.yg2288.pokerodds;

public class Card implements Comparable<Card>{
    public enum Suit {
        CLUBS,
        SPADES,
        HEARTS,
        DIAMONDS
    }

    public enum Rank {
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(11),
        QUEEN(12),
        KING(13),
        ACE(14);

        private int value;

        private Rank(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    }

    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public String toString() {
        String faceValue;
        switch (rank) {
            case TWO:
                faceValue = "2";
                break;
            case THREE:
                faceValue = "3";
                break;
            case FOUR:
                faceValue = "4";
                break;
            case FIVE:
                faceValue = "5";
                break;
            case SIX:
                faceValue = "6";
                break;
            case SEVEN:
                faceValue = "7";
                break;
            case EIGHT:
                faceValue = "8";
                break;
            case NINE:
                faceValue = "9";
                break;
            case TEN:
                faceValue = "10";
                break;
            default:
                faceValue = rank.toString();
        }
        return faceValue + " of " + suit.toString();
    }

    public int compareTo(Card anotherCard) {
        return rank.compareTo(anotherCard.rank);
    }

}
