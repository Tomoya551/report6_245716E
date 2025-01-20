package org.example.jp.ac.uryukyu.ie.e245716;

public class BlackjackGame {
    private Deck deck;
    private Player player;
    private Dealer dealer;
    public BlackjackGame() {
        this.deck = new Deck();
        this.player = new Player();
        this.dealer = new Dealer();}
    public void start() {
        System.out.println("ゲームを開始します");
        player.getHand().addCard(deck.drawCard());
        dealer.getHand().addCard(deck.drawCard());
        player.getHand().addCard(deck.drawCard());
        dealer.getHand().addCard(deck.drawCard());
        System.out.println("あなたの1枚目のカードは " + player.getHand().getCards().get(0));
        System.out.println("ディーラーの1枚目のカードは " + dealer.getHand().getCards().get(0));
        System.out.println("あなたの2枚目のカードは " + player.getHand().getCards().get(1));
        System.out.println("ディーラーの2枚目のカードは秘密です。");
        while (true) {
            System.out.println("あなたの現在のポイントは " + player.getHand().calculatePoints() + " です。");
            if (!player.decideToDraw()) {
                break;}
            player.getHand().addCard(deck.drawCard());
            System.out.println("あなたが引いたカードは " + player.getHand().getCards().get(player.getHand().getCards().size() - 1));
            if (player.getHand().isBusted()) {
                System.out.println("残念、バーストしてしまいました。");
                return;}
        }
        dealer.play(deck);
        if (dealer.getHand().isBusted()) {
            System.out.println("ディーラーがバーストしました！あなたの勝ちです！");
            return;}
        int playerPoints = player.getHand().calculatePoints();
        int dealerPoints = dealer.getHand().calculatePoints();
        System.out.println("あなたのポイント: " + playerPoints);
        System.out.println("ディーラーのポイント: " + dealerPoints);
        if (playerPoints > dealerPoints) {
            System.out.println("あなたの勝ちです！");
        } else if (playerPoints < dealerPoints) {
            System.out.println("あなたの負けです...");
        } else {
            System.out.println("引き分けです。");}
    }
    public Player getPlayer() {
        return player;}
    public Dealer getDealer() {
        return dealer;}
    public Deck getDeck() {
        return deck;}
}
