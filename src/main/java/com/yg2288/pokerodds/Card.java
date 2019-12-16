package com.yg2288.pokerodds;

public class Card implements Comparable<Card>{
    Suit suit;
    CardValue value;

    public Card(Suit suit, CardValue value) {
        this.suit = suit;
        this.value = value;
    }

    public String toString() {
        String faceValue;
        switch (value) {
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
                faceValue = value.toString();
        }
        return faceValue + " of " + suit.toString();
    }

    public int compareTo(Card anotherCard) {
        return value.compareTo(anotherCard.value);
    }

}
