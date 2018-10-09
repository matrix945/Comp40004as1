import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Poker {

    //same colour
    public static boolean checkFlush(ArrayList<Card> t) {
//        check the suit not same suit
        for (int i = 0; i < 5; i++) {
            if (t.get(0).suit != t.get(i).suit) {
                return false;
            }
        }
        return true;
    }
















    public static void readCard() {
        ArrayList allGames = new ArrayList();

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Mao\\eclipse-workspace\\Comp40004as1\\data"))) {
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

    //convert A JQK
    public static int convert(String a) {
        if (a.length() == 3) {
            return 10;
        } else {
            if (a.charAt(1) == 74) {
                return 11;
            } else if (a.charAt(1) == 81) {
                return 12;
            } else if (a.charAt(1) == 75) {
                return 13;
            } else if (a.charAt(1) == 65) {
                return 1;
            } else {
                int k = a.charAt(1) - 48;
                return k;
            }
        }
    }

    public static void main(String[] args) {
        readCard();


    }


}