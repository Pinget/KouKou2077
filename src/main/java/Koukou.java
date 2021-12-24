import java.util.ArrayList;

public class Koukou {
    public static ArrayList<Player> playerList = new ArrayList<>();

    public static int games = 64;

    public static void main(String[] args) {

        System.out.println("Please input number of players, max 39.\n");
        int playerAmount = (InfoGetter.GetPlayers());

        for(int counter = 0; counter < games; counter++){
            playerList.clear();
            Card.reset();
            for (int i = 0; i < playerAmount; i++) {
                playerList.add(new Player());
                System.out.println("Added Player");
            }
            //System.out.println("Passing for every player, for cards <= 4.");

            Player.passCard(playerList);
            Player.checkLosingPlayers(playerList);
            Player.losingFourPassers(Player.losingList);
        }
        System.out.println("Number of games: " + games);
        System.out.println("The amount of players who increased their number by passing with 4: " + Player.goodFourPass);
        System.out.println("The amount of players who decreased their number by passing with 4: " + Player.badFourPass);
        System.out.println("The amount of players who lost by passing 4: " + Player.fourLoss);

    }
}
