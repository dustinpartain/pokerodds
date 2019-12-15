package java.com.yg2288.pokerodds;

public class Card {
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
            default:
                faceValue = value.toString();
        }
        return faceValue + " of " + suit.toString();
    }

}
