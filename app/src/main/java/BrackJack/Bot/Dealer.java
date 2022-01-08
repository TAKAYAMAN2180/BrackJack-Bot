package Brackjack.master;

public class Dealer {
    static Deck deck = new Deck();
    //↓　配った枚数をsumOfDealtCardで数えるよ
    static int sumOfDealtCard = 0;


    //デッキ(deckSeq)からカードをとって配列に入れて返す
    static int[] dealCard(int numOfWantedCard) {
        int[] dealtCardSeq = new int[numOfWantedCard];
        for (int i = 0; i < numOfWantedCard; i++) {
            dealtCardSeq[i] = deck.getDeckSeq().get(sumOfDealtCard);
            sumOfDealtCard++;
        }
        return dealtCardSeq;
    }

    int getSumOfDealtCard() {
        return sumOfDealtCard;
    }

    public static void main(String[] args) {
        dealCard(2);
        dealCard(3);
        System.out.println(sumOfDealtCard);
    }
}