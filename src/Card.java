
public class Card implements Comparable<Card> {
    char suit;
    int rank;

    public Card(char c , int r){
        this.rank = r;
        this.suit = c;
    }

    public Card(){

    }


    public String toString() {

        return (suit+"" + rank);
    }

    @Override
    public int compareTo(Card o) {
        if (this.rank != o.rank)
            return this.rank - o.rank;
        else{
            return (this.suit - o.suit);
        }
    }
}
