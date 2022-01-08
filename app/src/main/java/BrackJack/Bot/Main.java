package Brackjack.master;

public class Main {
    public static void main(String[] args) {
        int choice = 0;
        Deck.makeDeck();
        Companion companion = new Companion();
        Myself myself = new Myself();
        //勝ちは0で負けは1番目
        int winCount = 0;
        int looseCount = 0;
        int winPlayCount = 0;
        int loosePlayCount = 0;

        for (int turnCount = 0; turnCount < 100; turnCount++) {
            Chip.money = 1000;
            boolean continuePlaying = true;
        int gameCount = 0;
            choice = 0;
            while (continuePlaying) {
                //敵と自分を生成
                companion.drawFirstCard();
                int numOfMyself = myself.play(companion);
                int numOfCompanion = companion.play();
                int result = Structure.showResult(numOfMyself, numOfCompanion);

                if (result == 0) {
                    winPlayCount++;
                } else if (result == 1) {
                    loosePlayCount++;
                }

                Chip.dealOrRemoveMoney(result);

                companion.restart();
                myself.restart();

                //System.out.println("現在の枚数" + Dealer.sumOfDealtCard);

                //配った枚数がデッキの半分を超えてたら、リセット
                if (Dealer.sumOfDealtCard > 156) {
                    Deck.makeDeck();
                    Dealer.sumOfDealtCard = 0;
                }

                //System.out.println("続ける場合は0を、やめる場合は１を入力してください");
                gameCount++;
                //choice = Structure.input(1, 0);

                if (gameCount == 100) {
                    choice = 1;
                    System.out.println(Chip.money);
                    if (Chip.money > 1000) {
                        winCount++;
                    } else {
                        looseCount++;
                    }

                } else if (Chip.money < 10) {
                    System.out.println(gameCount + "回目で破産しました");
                    choice = 1;
                    looseCount++;
                }

                //System.out.println(gameCount+"gamemw");

                if (choice == 1) {
                    continuePlaying = false;
                }

            }
        }

        System.out.println("勝ち:" + winCount + "回" + "負け:" + looseCount + "回");
        System.out.println("ゲーム勝ち:" + winPlayCount + "回" + "ゲーム負け:" + loosePlayCount + "回");
    }
}


