package Brackjack.master;

public class Chip {
    static private final int firstMoney = 1000;
    static long money;
    static private int BetPrice;

    //勝ったらtrue負けたら、false
    Chip() {
        money = firstMoney;
    }

    //勝ったら０、引き分けは１、負けは２
    static void dealOrRemoveMoney(int result) {

        System.out.println(result);
        if (result == 0) {
            money = money + BetPrice * 2;
        } else if (result == 2) {
            money = money - BetPrice;
        }

        System.out.println("現在のチップ数は" + money + "です");
    }

    void Bet() {
        System.out.println("ベット金額を決めてください(所持" + money + ")");
        //BetPrice = Structure.input(money, 1);

        BetPrice = (int) (money * 0.1);
        System.out.println(BetPrice);
    }
}


