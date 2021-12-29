import java.util.ArrayList;

public class Koukou {

    public static ArrayList<Player> playerList = new ArrayList<>();
    public static int games = 100;

    public static void init(){
        playerList.clear();
        Player.losingList.clear();
        Deck.cardList.clear();
        Deck.genDeck();
    }

    public static void main(String[] args) {

        System.out.println("Please input number of players, max 39.\n");
        int playerAmount = (InfoGetter.GetPlayers());

        for (int counter = 0; counter < games; counter++) {

            init();

            for (int i = 0; i < playerAmount; i++) {
                playerList.add(new Player());

            }
            //System.out.println("Passing for every player, for cards <= 4.");

            Player.passCard(playerList);
            Player.checkLosingPlayers(playerList);
            System.out.println("Game Over");
            Player.losingMaxPassers(Player.losingList);


        }

        System.out.println("The amount of players who increased their number by passing with Var: " + Player.goodMaxPass);
        System.out.println("The amount of players who decreased their number by passing with Var: " + Player.badMaxPass);
        System.out.println("The amount of players who lost and have passed Var card: " + Player.maxLoss);
        System.out.println("Number of games: " + games);

    }
}
