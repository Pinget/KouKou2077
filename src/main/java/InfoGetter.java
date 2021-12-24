import java.util.Scanner;

public class InfoGetter {
    public static int GetPlayers() {
        boolean checking = true;
        int answer;
        Scanner MyGetter = new Scanner(System.in);
        do {
            answer = Integer.parseInt(MyGetter.next());
            if (answer <= 39) {
                MyGetter.close();
                checking = false;
            }
        } while (checking);

        return answer;
    }
}

