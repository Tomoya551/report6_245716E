package org.example.jp.ac.uryukyu.ie.e245716;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Deck {
    private List<Card> cards;
    private int currentIndex;

    public Deck() {
        cards = new ArrayList<>();
        initializeDeck();
        shuffleDeck();
        currentIndex = 0;
    }

    private void initializeDeck() {
        String[] suits = {"クラブ", "ダイヤ", "ハート", "スペード"};
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        int[] points = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};

        for (String suit : suits) {
            for (int i = 0; i < ranks.length; i++) {
                cards.add(new Card(suit, ranks[i], points[i]));
            }
        }
    }

    private void shuffleDeck() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        if (currentIndex < cards.size()) {
            return cards.get(currentIndex++);
        } else {
            throw new IllegalStateException("山札が空です！");
        }
    }
}