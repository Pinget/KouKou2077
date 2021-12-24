import java.util.ArrayList;

public class Player {
    public Card card;
    public Boolean hasPassedFour = false;
    public static int goodFourPass;
    public static int badFourPass;
    public static int fourLoss;

    public static ArrayList<Player> losingList = new ArrayList<>();

    public static void passCard(ArrayList<Player> playerList) {

        for (int i = 0; i <= playerList.size() - 1; i++) {
            if (i == playerList.size() - 1) {
                if (playerList.get(i).card.cardNum <= 4) {
                    playerList.get(i).card = new Card();
                    System.out.println("Spigned");
                }

            } else {
                Player nextPlayer = playerList.get(i + 1);
                Player current = playerList.get(i);

                if (current.card.cardNum <= 4) {
                    if (current.card.cardNum == 4) {
                        current.hasPassedFour = true;
                        if (nextPlayer.card.cardNum >= 4) {
                            goodFourPass++;
                        } else {
                            badFourPass++;
                        }
                    }

                    Card tempcard = current.card;
                    current.card = nextPlayer.card;
                    nextPlayer.card = tempcard;
                    System.out.println("Passed");
                }


            }
        }

    }

    public static void checkLosingPlayers(ArrayList<Player> list) {

        int lowestNum = 10;
        for (int i = 0; i <= 1; i++) {
            for (Player player : list) {
                if (i == 0) {
                    if (player.card.cardNum <= lowestNum) {
                        lowestNum = player.card.cardNum;
                    }
                } else {
                    if (player.card.cardNum == lowestNum) {
                        losingList.add(player);
                    }
                }

            }
        }
    }

    public static void losingFourPassers(ArrayList<Player> losers) {
        for (Player loser : losers) {
            if (loser.hasPassedFour) {
                fourLoss++;
            }
        }
    }

    public Player() {
        card = new Card();
    }
}
