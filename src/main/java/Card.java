import java.util.concurrent.ThreadLocalRandom;

public class Card {
    static int[] basCards = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
            copCards = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
            denCards = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
            spaCards = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    static int[][] cardList = {basCards, copCards, denCards, spaCards};

    public static void reset(){
                basCards = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
                copCards = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
                denCards = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
                spaCards = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    }

    int cardNum;

    String cardsDeckName;

    public Card() {
        while (true) {
            int deckPick = ThreadLocalRandom.current().nextInt(3) + 1;
            int cardPick = ThreadLocalRandom.current().nextInt(9) + 1;
            if (cardList[deckPick][cardPick] != 0) {
                cardNum = cardList[deckPick][cardPick];
                cardList[deckPick][cardPick] = 0;
                //System.out.println("Released card deck " + deckPick + " and number " + cardPick);
                break;
            } //else {System.out.println("Card is already out");}


        }


    }
}
