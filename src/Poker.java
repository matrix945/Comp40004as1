import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Poker {
    public static void readCard() {
        ArrayList allGames = new ArrayList();

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Mao\\eclipse-workspace\\Comp4004a1\\data"))) {
            String line;
            String[] tempArray;
            while ((line = br.readLine()) != null) {
                ArrayList oneGames = new ArrayList();
                ArrayList<Card> hand = new ArrayList<Card>();
                ArrayList<Card> init = new ArrayList<Card>();
                ArrayList<Card> exchange = new ArrayList<Card>();

                System.out.println(line);
                tempArray = line.split(" ");

                for (int i = 0; i < 5; i++) {
                    Card a = new Card();
                    a.suit = tempArray[i].charAt(0);
                    a.rank = convert(tempArray[i]);
                    hand.add(a);
                }
                for (int i = 5; i < 10; i++) {
                    Card a = new Card();
                    a.suit = tempArray[i].charAt(0);
                    a.rank = convert(tempArray[i]);
                    init.add(a);
                }
                for (int i = 10; i < 12; i++) {
                    Card a = new Card();
                    a.suit = tempArray[i].charAt(0);
                    a.rank = convert(tempArray[i]);
                    exchange.add(a);
                }
                Collections.sort(hand, Card::compareTo);
                Collections.sort(init, Card::compareTo);
                Collections.sort(exchange, Card::compareTo);
                oneGames.add(hand);
                oneGames.add(init);
                oneGames.add(exchange);
                allGames.add(oneGames);

                System.out.println("this is all games");
                System.out.println(allGames);
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }





}
