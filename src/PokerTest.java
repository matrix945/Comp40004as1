import org.junit.After;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class PokerTest {

    @Test
    public void test() {
        fail("Not yet implemented");
    }

    @Test
    public void checkFlushtest() {
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

        Card aa = new Card('C',10);
        Card bb = new Card('P',11);
        Card cc = new Card('C',12);
        Card dd = new Card('H',13);
        Card ee = new Card('C',1);
        ArrayList<Card> arr2 = new ArrayList<Card>();
        arr.add(aa);
        arr.add(bb);
        arr.add(cc);
        arr.add(dd);
        arr.add(ee);
        boolean z2 = new Poker().checkStraight(arr2);
        assertEquals(true, z);

    }








//    @After
//    public void after() {
//        System.out.println("after");
//    }


}
