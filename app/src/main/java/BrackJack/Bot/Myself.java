package Brackjack.master;

public class Myself extends Player {
    Chip chip = new Chip();

    int play(Companion companion) {
        super.drawFirstCard(2);
        showHand();
        chip.Bet();
        int i = 0;
        while (i == 0) {
           // System.out.println("０：STAND(そのまま)\n１：HIT(もう一枚引く)");
            int choice;
            //choice = Structure.input(1, 0);

            if (getSumOfGotCardFigure() >= 17 && getSumOfGotCardFigure() <= 21) {
                choice = 0;
            } else if (getSumOfGotCardFigure() >= 12 && getSumOfGotCardFigure() <= 16) {
                if (companion.getSumOfGotCardFigure() >= 2 && companion.getSumOfGotCardFigure() <= 6) {
                    choice = 0;
                } else {
                    choice = 1;
                }
            }else{
                choice = 1;
            }
            System.out.println("choice:" + choice);

            if (choice == 1) {
                //(HIT)dealカードからカードを引いてhandByArrayに入れる

                handsList.add(new Card(Dealer.dealCard(1)[0]));
                showLastCard();
                System.out.print("を引きました。");
                if (getSumOfGotCardFigure() == 21) {
                    System.out.println("ナチュラル！！！");
                }



            } else if (choice == 0) {
                i++;//(STAND)操作終了
            }
            System.out.println("あなたの手札は");
            showHand();
            System.out.println("です");
            if (checkBurst(getSumOfGotCardFigure())) {
                i++;
            }
        }
        return returnValuedFigure(getSumOfGotCardFigure());
    }
}






