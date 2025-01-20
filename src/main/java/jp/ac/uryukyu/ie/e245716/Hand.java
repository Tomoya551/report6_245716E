package main.java.jp.ac.uryukyu.ie.e245716;

import java.util.ArrayList;
import java.util.List;

class Hand {
    private List<Card> cards;
public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int calculatePoints() {
        int sum = 0;
        for (Card card : cards) {
            sum += card.getPoint();
        }
        return sum;
    }

    public boolean isBusted() {
        return calculatePoints() > 21;
    }

    public List<Card> getCards() {
        return cards;
    }
}