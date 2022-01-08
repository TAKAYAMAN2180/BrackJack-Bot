package Brackjack.master;

//トランプに書いてある数字はfigureとする
public class Card {
    private String cardMark = null;
    private String cardFigure;
    private int cardValuedFigure;

    Card(int num) {
        //Aを11として扱うときの操作
        if (num == Deck.getNumOfSet() * 13 * 4 + 1) {
            this.cardValuedFigure = 11;
        }
        int cardNum = num % 13;
        switch (cardNum) {
            case 1:
                this.cardFigure = "A" + "\u001b[00m";
                this.cardValuedFigure = 11;
                break;
            case 11:
                this.cardFigure = "J" + "\u001b[00m";
                this.cardValuedFigure = 10;
                break;
            case 12:
                this.cardFigure = "Q" + "\u001b[00m";
                this.cardValuedFigure = 10;
                break;
            case 0:
                this.cardFigure = "K" + "\u001b[00m";
                this.cardValuedFigure = 10;
                break;
            default:
                this.cardFigure = String.valueOf(cardNum) + "\u001b[00m";
                this.cardValuedFigure = cardNum;
                break;
        }
        if (num <= 13) {
            this.cardMark = "\u001b[00;31m" + "Heart";
        } else if (num <= 13 * 2) {
            this.cardMark = "\u001b[00;31m" + "Diamond";
        } else if (num <= 13 * 3) {
            this.cardMark = "Spade";
        } else if (num <= 13 * 4) {
            this.cardMark = "Clover";
        }
    }

    int getCardValuedFigure() {
        return cardValuedFigure;
    }

    String getCardMarkAndFigure() {
        String cardMarkAndFigure = cardMark + " " + cardFigure;
        return cardMarkAndFigure;
    }

    public String getCardFigure() {
        return cardFigure;
    }
}
