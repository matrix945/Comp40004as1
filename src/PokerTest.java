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

    public void testCheckFlush() {
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


//    @After
//    public void after() {
//        System.out.println("after");
//    }


}
