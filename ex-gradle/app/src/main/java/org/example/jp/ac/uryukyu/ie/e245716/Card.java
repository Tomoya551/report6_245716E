package org.example.jp.ac.uryukyu.ie.e245716;

public class Card {
    private String suit;
    private String rank;
    private int point;

    public Card(String suit, String rank, int point) {
        this.suit = suit;
        this.rank = rank;
        this.point = point;
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    public int getPoint() {
        return point;
    }

    @Override
    public String toString() {
        return suit + "の" + rank;
    }
}