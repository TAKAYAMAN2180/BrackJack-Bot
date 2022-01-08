package Brackjack.master;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    static final int numOfSet = 6;
    private static ArrayList<Integer> deckSeq = new ArrayList<>();
    // Card card = new Card();

    public static int getNumOfSet() {
        return numOfSet;
    }

    //デッキはcardNumSeqの中に収納してあるよ
    static void makeDeck() {
        deckSeq.clear();
        for (int i = 0; i < numOfSet; i++) {
            for (int j = 0; j < 52; j++) {
                deckSeq.add(j);
            }
        }
        Collections.shuffle(deckSeq);
    }

    public ArrayList<Integer> getDeckSeq() {
        return deckSeq;
    }

    public static void resetDeck(){
        deckSeq.clear();
    }

}

