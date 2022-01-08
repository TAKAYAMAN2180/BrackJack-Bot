package Brackjack.master;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Structure {
    //数字以外の入力に対応し、maxNumからminiNumの入力しか受け付けないメソッド
    public static int input(int maxNum, int miniNum) {
        int i = 0;
        int j = 0;
        int value = 0;
        Scanner sc = new Scanner(System.in);
        while (j == 0) {
            while (i < 1) {
                try {
                    value = sc.nextInt();
                    i++;
                } catch (InputMismatchException e) {
                    System.out.println("半角の数値を入力してください");
                    continue;
                }
            }

            if (value > maxNum || value < miniNum) {
                System.out.println(miniNum + "?" + maxNum + "の数字を入力してください");
                value = sc.nextInt();
            } else {
                j++;
            }
        }
        return value;
    }

    public static boolean checkA(ArrayList<Card> cards) {
        boolean check = false;
        for (Card card : cards) {
            if (card.getCardValuedFigure() == 1) {
                check = true;
            }
        }
        return check;
    }

    public static int showResult(int valueOfMyself, int valueOfCompanion) {
        if (valueOfCompanion > valueOfMyself) {
            System.out.println("あなたの負け");
            return 2;
        } else if (valueOfCompanion == valueOfMyself) {
            System.out.println("引き分け");
            return 1;
        } else{
            System.out.println("あなたの勝ち");
            return 0;
        }
    }


    /*

    public static int countNumOfA(ArrayList<Card> cards) {
        int numOfA = 0;
        for (Card card : cards) {
            if (card.getCardValuedFigure() == 1) {
                numOfA++;
            }
        }
        return numOfA;
    }

    //Aのインデックス番号を検索して、置き換える
    public static ArrayList<Card> changeAFor11(ArrayList<Card> cards) {
        ArrayList<Integer> numOfIndexLocatedAByArray = new ArrayList<>();
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getCardValuedFigure() == 1) {
                numOfIndexLocatedAByArray.add(i);
            }
        }
        cards.set(numOfIndexLocatedAByArray.get(0), new Card(Deck.getNumOfSet() * 13 * 4 + 1));
        return cards;
    }*/
}

