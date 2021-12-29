import java.util.ArrayList;

public class Player {
    public Card card;
    public Boolean hasPassedMax = false;
    public static int goodMaxPass;
    public static int badMaxPass;
    public static int maxLoss;

    public static int maxPass = 3; //max lol

    public static ArrayList<Player> losingList = new ArrayList<>();

    public static void passCard(ArrayList<Player> playerList) {

        for (int i = 0; i <= playerList.size() - 1; i++) {
            Player currentPlayer = playerList.get(i);

            if (i > 0) {
                if (currentPlayer.card.cardNum != 10) {
                    if ((playerList.get(i - 1).card.cardNum < playerList.get(i).card.cardNum) && playerList.get(i - 1).card.cardNum != 10) {
                        System.out.println("I received a card bigger than mine, " + playerList.get(i).card.cardNum);
                        continue;
                    }
                }
            }

            if (i == playerList.size() - 1) {
                if (currentPlayer.card.cardNum <= maxPass) {
                    currentPlayer.card = new Card();
                    System.out.println("Player spigned " + currentPlayer.card.cardNum);
                }

            } else {
                Player nextPlayer = playerList.get(i + 1);
                if (nextPlayer.card.cardNum == 10) {
                    System.out.println("CUCKOO!");
                    continue;
                }


                if (currentPlayer.card.cardNum <= maxPass) {
                    if (currentPlayer.card.cardNum == maxPass) {
                        currentPlayer.hasPassedMax = true;
                        if (nextPlayer.card.cardNum >= maxPass) {
                            goodMaxPass++;
                        } else {
                            badMaxPass++;
                        }
                    }
                    System.out.println("Player " + i + " passed a " + currentPlayer.card.cardNum + " and received a " + nextPlayer.card.cardNum);
                    Card tempcard = currentPlayer.card;
                    currentPlayer.card = nextPlayer.card;
                    nextPlayer.card = tempcard;
                } else {
                    System.out.println("Staying with " + currentPlayer.card.cardNum);
                }
            }
        }
    }

    public static void checkLosingPlayers(ArrayList<Player> list) {

        int lowestNum = 10;
        for (int i = 0; i <= 1; ++i) {
            for (Player player : list) {
                if (i == 0) {
                    if (player.card.cardNum < lowestNum) {
                        lowestNum = player.card.cardNum;
                    }
                } else {
                    //if (i == 1) {
                    if (player.card.cardNum == lowestNum) {
                        System.out.println("Losing card is " + player.card.cardNum);
                        losingList.add(player);
                    }
                    //}
                }

            }
        }
        System.out.println(losingList.toString());
    }

    public static void losingMaxPassers(ArrayList<Player> losers) {
        for (Player loser : losers) {
            if (loser.hasPassedMax) {
                maxLoss++;
            }
            System.out.println("Player lost with " + loser.card.cardNum);
        }
    }

    public Player() {
        card = new Card();
        System.out.println("My card is " + card.cardNum);

    }
}
