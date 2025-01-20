package main.java.jp.ac.uryukyu.ie.e245716;

class Dealer {
    private Hand hand;

    public Dealer() {
        hand = new Hand();
    }

    public Hand getHand() {
        return hand;
    }

    public void play(Deck deck) {
        while (hand.calculatePoints() < 17) {
            hand.addCard(deck.drawCard());
        }
    }
}