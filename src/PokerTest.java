import org.junit.After;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class PokerTest {


    @Test
    public void checkCardTest() {
        Card a = new Card('C',4);

        ArrayList<Card> arr = new ArrayList<Card>();
        for(int i =0;i<52;i++){
            arr.add(a);
        }

        boolean z = new Poker().checkCard(arr);
        assertEquals(true, z);
    }




    @Test
    public void test() {
        fail("Not yet implemented");
    }
    @Test
    public void checkFlushTest() {
        Card a = new Card('C',4);
        Card b = new Card('C',6);
        Card c = new Card('C',8);
        Card d = new Card('C',11);
        Card e = new Card('C',12);
        ArrayList<Card> arr = new ArrayList<Card>();
        arr.add(a);
        arr.add(b);
        arr.add(c);
        arr.add(d);
        arr.add(e);

        boolean z = new Poker().checkFlush(arr);
        assertEquals(true, z);
    }

    @Test
    //12345
    //910111213A
    public void checkStraightTest() {
        Card a = new Card('C',1);
        Card b = new Card('P',2);
        Card c = new Card('C',3);
        Card d = new Card('H',4);
        Card e = new Card('C',5);
        ArrayList<Card> arr = new ArrayList<Card>();
        arr.add(a);
        arr.add(b);
        arr.add(c);
        arr.add(d);
        arr.add(e);
        boolean z = new Poker().checkStraight(arr);
        assertEquals(true, z);
    }

    @Test
    public void checkStraightTest2() {
        Card aa = new Card('C',1);
        Card bb = new Card('P',10);
        Card cc = new Card('C',11);
        Card dd = new Card('H',12);
        Card ee = new Card('C',13);
        ArrayList<Card> arr2 = new ArrayList<Card>();
        arr2.add(aa);
        arr2.add(bb);
        arr2.add(cc);
        arr2.add(dd);
        arr2.add(ee);
        boolean z2 = new Poker().checkStraight(arr2);
        assertEquals(true, z2);
    }

    @Test
    public void checkFullHouseTest() {

        Card a = new Card('C',1);
        Card b = new Card('P',1);
        Card c = new Card('h',1);
        Card d = new Card('H',5);
        Card e = new Card('C',5);
        ArrayList<Card> arr = new ArrayList<Card>();
        arr.add(a);
        arr.add(b);
        arr.add(c);
        arr.add(d);
        arr.add(e);
        boolean z = new Poker().checkFullHouse(arr);
        assertEquals(true, z);

    }

    @Test
    public void checkFourOfAKindTest() {
        Card a = new Card('S',1);
        Card b = new Card('H',1);
        Card c = new Card('C',1);
        Card d = new Card('D',1);
        Card e = new Card('C',5);
        ArrayList<Card> arr = new ArrayList<Card>();
        arr.add(a);
        arr.add(b);
        arr.add(c);
        arr.add(d);
        arr.add(e);
        boolean z = new Poker().checkFourOfAKind(arr);
        assertEquals(true, z);
    }

    @Test
    public void checkStrightFlushTest() {
        Card a = new Card('S',1);
        Card b = new Card('S',2);
        Card c = new Card('S',3);
        Card d = new Card('S',4);
        Card e = new Card('S',5);
        ArrayList<Card> arr = new ArrayList<Card>();
        arr.add(a);
        arr.add(b);
        arr.add(c);
        arr.add(d);
        arr.add(e);
        boolean z = new Poker().checkStrightFlush(arr);
        assertEquals(true, z);
    }

    @Test
    public void checkRoyalFlushTest() {
        Card a = new Card('S',1);
        Card b = new Card('S',10);
        Card c = new Card('S',11);
        Card d = new Card('S',12);
        Card e = new Card('S',13);
        ArrayList<Card> arr = new ArrayList<Card>();
        arr.add(a);
        arr.add(b);
        arr.add(c);
        arr.add(d);
        arr.add(e);
        boolean z = new Poker().checkRoyalFlush(arr);
        assertEquals(true, z);
    }

    @Test
    public void checkThreeAKindTest() {
        Card a = new Card('S',1);
        Card b = new Card('H',1);
        Card c = new Card('P',1);
        Card d = new Card('S',12);
        Card e = new Card('S',13);
        ArrayList<Card> arr = new ArrayList<Card>();
        arr.add(a);
        arr.add(b);
        arr.add(c);
        arr.add(d);
        arr.add(e);
        boolean z = new Poker().checkThreeAKind(arr);
        assertEquals(true, z);
    }





//    @After
//    public void after() {
//        System.out.println("after");
//    }


}
