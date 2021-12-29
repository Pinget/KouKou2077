//import java.util.ArrayList;
//import java.util.concurrent.ThreadLocalRandom;

public class Card {

    int cardNum;
    int cardSeed;

    public Card() {
        int[] results = Deck.getCard();
        cardSeed = results[0];
        cardNum = results[1];
    }
}