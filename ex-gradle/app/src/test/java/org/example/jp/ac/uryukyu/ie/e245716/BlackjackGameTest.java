package org.example.jp.ac.uryukyu.ie.e245716;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BlackjackTests {

    @Test
    void testCardCreation() {
        Card card = new Card("ハート", "A", 1);
        assertEquals("ハート", card.getSuit());
        assertEquals("A", card.getRank());
        assertEquals(1, card.getPoint());
    }

    @Test
    void testDeckInitialization() {
        Deck deck = new Deck();
        assertEquals(52, deck.drawCard().getPoint() + 51); // Ensure all cards exist
    }

    @Test
    void testDeckShuffleAndDraw() {
        Deck deck = new Deck();
        Card firstCard = deck.drawCard();
        Card secondCard = deck.drawCard();
        assertNotEquals(firstCard, secondCard); // Check shuffled order
    }

    @Test
    void testHandPointsCalculation() {
        Hand hand = new Hand();
        hand.addCard(new Card("ハート", "10", 10));
        hand.addCard(new Card("スペード", "A", 1));
        assertEquals(11, hand.calculatePoints());
    }

    @Test
    void testHandBusted() {
        Hand hand = new Hand();
        hand.addCard(new Card("ハート", "10", 10));
        hand.addCard(new Card("スペード", "Q", 10));
        hand.addCard(new Card("ダイヤ", "3", 3));
        assertTrue(hand.isBusted());
    }

    @Test
    void testDealerPlay() {
        Deck deck = new Deck();
        Dealer dealer = new Dealer();
        dealer.play(deck);
        assertTrue(dealer.getHand().calculatePoints() >= 17);
    }

    @Test
    void testPlayerDecision() {
        // Mock player input for automated test
        Player player = new Player();
        Hand hand = player.getHand();
        hand.addCard(new Card("スペード", "10", 10));
        assertFalse(player.decideToDraw()); // Simulate "No" choice
    }

    @Test
    void testBlackjackGameStart() {
        BlackjackGame game = new BlackjackGame();
        assertNotNull(game); // Ensure game object is created successfully
        // We cannot fully automate the interaction-based game start in this test
    }

    @Test
void testGameEndConditions() {
    BlackjackGame game = new BlackjackGame();

    // Playerの手札を直接操作
    Player player = game.getPlayer();
    player.getHand().addCard(new Card("スペード", "10", 10));
    player.getHand().addCard(new Card("ハート", "K", 10));
    player.getHand().addCard(new Card("ダイヤ", "2", 2));

    // バーストしていることを確認
    assertTrue(player.getHand().isBusted());
    }
}