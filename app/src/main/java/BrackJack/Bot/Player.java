package Brackjack.master;

import java.util.ArrayList;

public class Player {
    protected int sumOfGotCardFigure = 0;//いままででたカードの目を合計
    protected ArrayList<Card> handsList = new ArrayList<>();

    //任意の枚数（numOfFirstCard）をhandSeqByArrayにいれる
    void drawFirstCard(int numOfFirstCard) {
        int[] cardSeqBySeq = Dealer.dealCard(numOfFirstCard);
        for (int i : cardSeqBySeq) {
            this.handsList.add(new Card(i));
        }
    }

    int getSumOfGotCardFigure() {
        sum();
        return this.sumOfGotCardFigure;

    }

    void showHand() {
        for (Card card : this.handsList) {
           // System.out.println(card.getCardMarkAndFigure());
        }
    }

    void burst() {
        System.out.println("合計" + sumOfGotCardFigure + "でバーストしました");
    }

    ArrayList<Card> draw(ArrayList<Card> cards) {
        Card card = new Card(Dealer.dealCard(1)[0]);
        cards.add(card);
        return cards;
    }


    void sum() {
        sumOfGotCardFigure = 0;
        for (Card card : this.handsList) {
            this.sumOfGotCardFigure += card.getCardValuedFigure();
        }
    }

    void showLastCard() {
        //System.out.println(handsList.get(handsList.size() - 1).getCardMarkAndFigure());
    }


    //バーストした場合はtrueを返す、そうでない場合はfalse
    boolean checkBurst(int sum) {
        if (sum > 21) {
            return true;
        } else {
            return false;
        }
    }

    //バーストしたなら、Aがあるかを確かめて、あるなら-10して値を評価する
    int returnValuedFigure(int sum) {
        if (checkBurst(sum)) {
            if (Structure.checkA(handsList)) {
                while (sum - 10 <= 16) {
                    handsList = draw(handsList);
                }
                if (checkBurst(sum)) {
                    burst();
                    return 0;
                }
                return sum - 10;
            } else {
                //System.out.println("合計" + sum + "でバーストしてしまいました");
                return 0;
            }
        } else {
            return sum;
        }
    }

    void restart() {
        this.handsList = new ArrayList<Card>();
    }
}

