package Brackjack.master;

//便宜上、敵とDealerは別であるとみなす
public class Companion extends Player {


    //もし、エースがでたら、まずは11として扱い、最終的にオーバーした場合は１として扱う
// また、２枚以上のAが含まれているなら、ぜったいにAを２枚とも１１として考えることはないので、
//一枚は１１として、二枚以降は１として考える。
    void drawFirstCard() {
        super.drawFirstCard(1);
        System.out.println("相手の最初の手札は");
        showLastCard();
        System.out.println("です");
    }

    int play() {
        //16になるまで加えて、加えたら加えたカードを表示する
        while (getSumOfGotCardFigure() <= 16) {
            handsList= draw(handsList);
        }
        System.out.println("相手の手札は");
        showHand();
        System.out.println("で、合計"+getSumOfGotCardFigure()+"です");
        return returnValuedFigure(getSumOfGotCardFigure());
    }

}





