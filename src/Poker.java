import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Poker {



    //three card in a seq
    public boolean threeInSeq(ArrayList<Card> t){
        if ( (t.get(0).rank == t.get(1).rank + 1) && (t.get(1).rank == t.get(2).rank + 1) ){
            return true;
        }
        if ( (t.get(1).rank == t.get(2).rank + 1) && (t.get(2).rank == t.get(3).rank + 1) ){
            return true;
        }

        if ( (t.get(2).rank == t.get(3).rank + 1) && (t.get(3).rank == t.get(4).rank + 1) ){
            return true;
        }
        return false;
    }



    //3 cards same rank AAAXX
    public boolean threeSameRank(ArrayList<Card> t){
        //AAABC
        if ((t.get(0).rank == t.get(1).rank) && (t.get(1).rank == t.get(2).rank) ){
            return true;
        }
        //BAAAC
        if ((t.get(1).rank == t.get(2).rank) && (t.get(2).rank == t.get(3).rank) ){
            return true;
        }
        //BCAAA
        if ((t.get(2).rank == t.get(3).rank) && (t.get(3).rank == t.get(4).rank) ){
            return true;
        }
        return false;
    }



    //one away from straight 12349
    //bug didn't handle 14567
    public boolean oneAwayStraight(ArrayList<Card> t){
        int counter =0;
        int position=0;
        for (int i = 0; i < 5; i++) {
            if (t.get(0).rank != t.get(i).rank + i) {
                counter = counter +1 ;
                position = i;
            }
        }
        if (counter ==1){
            return true;
        }
        else{
            return false;
        }

    }


    public boolean oneAwayFlush(ArrayList<Card> t){
        int counter =0;
        int position=0;
        for (int i = 0; i < 5; i++) {
            if (t.get(0).suit != t.get(i).suit) {
                counter = counter +1;
                position = i;
            }
        }
        if (counter == 1){
            return true;
        }
        else{
            return false;
        }

    }




    //AABBC
    //AAABC
    public static boolean oneAwayFullHouse(ArrayList<Card> t) {
        //AAABC
        if ((t.get(0).rank == t.get(1).rank) && (t.get(1).rank == t.get(2).rank) ){
            return true;
        }
        //BAAAC
        if ((t.get(1).rank == t.get(2).rank) && (t.get(2).rank == t.get(3).rank) ){
            return true;
        }
        //BCAAA
        if ((t.get(2).rank == t.get(3).rank) && (t.get(3).rank == t.get(4).rank) ){
            return true;
        }

        //AABBC
        if ((t.get(0).rank == t.get(1).rank) && (t.get(2).rank == t.get(3).rank) ){
            return true;
        }
        //AACBB
        if ((t.get(0).rank == t.get(1).rank) && (t.get(3).rank == t.get(4).rank) ){
            return true;
        }
        //CAABB
        if ((t.get(1).rank == t.get(2).rank) && (t.get(3).rank == t.get(4).rank) ){
            return true;
        }
        return false;
    }


    public static boolean betterThanStraight(ArrayList<Card> t) {
        return ( checkStraight(t) || checkFlush(t) || checkFourOfAKind(t) || checkFullHouse(t) );
    }



    public static boolean checkCard(ArrayList<Card> t){
        return t.size() == 52;
    }

    //11134
    public static boolean checkThreeAKind(ArrayList<Card> t) {
        //11134
        if ( (t.get(0).rank == t.get(1).rank) && (t.get(1).rank == t.get(2).rank) && (t.get(2).rank != t.get(3).rank)
                && (t.get(2).rank != t.get(4).rank) && (t.get(3).rank != t.get(4).rank)){
            return true;
        }
        //13334
        if ( (t.get(1).rank == t.get(2).rank) && (t.get(2).rank == t.get(3).rank) && (t.get(3).rank != t.get(4).rank)
                && (t.get(3).rank != t.get(0).rank) && (t.get(0).rank != t.get(4).rank)){
            return true;
        }
        //14555
        if ( (t.get(2).rank == t.get(3).rank) && (t.get(3).rank == t.get(4).rank) && (t.get(0).rank != t.get(1).rank)
                && (t.get(1).rank != t.get(2).rank) && (t.get(0).rank != t.get(2).rank)){
            return true;
        }

        return false;
    }


    public static boolean checkRoyalFlush(ArrayList<Card> t) {
        if ( (t.get(0).rank == 1) && (t.get(1).rank == 10) && (t.get(2).rank == 11)&& (t.get(3).rank == 12)
                && (t.get(4).rank == 13)  && ( checkFlush(t))){
            return true;
        }
        return false;
    }


    // 12345
    // AAAAA
    public static boolean checkStrightFlush(ArrayList<Card> t) {
        return (checkFlush(t) && checkStraight(t));
    }

    //Four of a kind: 4+1
    public static boolean checkFourOfAKind(ArrayList<Card> t) {

        if ( (t.get(0).rank == t.get(1).rank) && (t.get(1).rank == t.get(2).rank) && (t.get(2).rank == t.get(3).rank)){
            return true;
        }
        if ( (t.get(1).rank == t.get(2).rank) && (t.get(2).rank == t.get(3).rank) && (t.get(3).rank == t.get(4).rank)){
            return true;
        }
        return false;
    }

    //Full house: same 3+2
    public static boolean checkFullHouse(ArrayList<Card> t) {

        if ( (t.get(0).rank == t.get(1).rank) && (t.get(1).rank == t.get(2).rank) && (t.get(3).rank == t.get(4).rank) ){
            return true;
        }
        if ( (t.get(0).rank == t.get(1).rank) && (t.get(2).rank == t.get(3).rank) && (t.get(3).rank == t.get(4).rank) ){
            return true;
        }
        return false;
    }



    public static boolean checkStraight(ArrayList<Card> t) {
        //special case
        if ( (t.get(0).rank == 1) && (t.get(1).rank == 10) && (t.get(2).rank == 11)&& (t.get(3).rank == 12) && (t.get(4).rank == 13) ){
            return true;
        }

        for (int i = 0; i < 5; i++) {
            if (t.get(i).rank != t.get(0).rank + i) {
                return false;
            }
        }
        return true;
    }

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

        try (BufferedReader br = new BufferedReader(new FileReader("data"))) {
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
