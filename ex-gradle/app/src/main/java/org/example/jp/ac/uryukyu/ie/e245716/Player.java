package org.example.jp.ac.uryukyu.ie.e245716;

import java.util.Scanner;

class Player {
    private Hand hand;

    public Player() {
        hand = new Hand();
    }

    public Hand getHand() {
        return hand;
    }

    public boolean decideToDraw() {
        System.out.println("カードを引きますか？ Yes:y or No:n");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        return "y".equalsIgnoreCase(input);
    }
}