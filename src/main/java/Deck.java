import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Deck {

    private static ArrayList<Integer> bas = new ArrayList<>();
    private static ArrayList<Integer> cop = new ArrayList<>();
    private static ArrayList<Integer> den = new ArrayList<>();
    private static ArrayList<Integer> spa = new ArrayList<>();

    static ArrayList<ArrayList<Integer>> cardList = new ArrayList<>();

    private static void genSeed(ArrayList<Integer> deck) {
        for (int num = 1; num <= 10; num++) {
            deck.add(num);
        }
    }

    public static void genDeck() {

        genSeed(bas);
        genSeed(cop);
        genSeed(den);
        genSeed(spa);

        cardList.add(bas);
        cardList.add(cop);
        cardList.add(den);
        cardList.add(spa);
    }

    public static int[] getCard() {

        int deckPick;
        int cardPick;
        ArrayList<Integer> chosenDeck;
        do {
            deckPick = ThreadLocalRandom.current().nextInt(4);
            chosenDeck = cardList.get(deckPick);
        } while (chosenDeck.size() == 0);

        cardPick = ThreadLocalRandom.current().nextInt(chosenDeck.size());
        System.out.println("Chosen deck:" + deckPick);

        int[] answer = {deckPick, chosenDeck.get(cardPick)};
        chosenDeck.remove(cardPick);
        return answer;
    }
}
