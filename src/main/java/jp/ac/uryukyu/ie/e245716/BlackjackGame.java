package main.java.jp.ac.uryukyu.ie.e245716;

public class BlackjackGame {
    public static void main(String[] args) {
        System.out.println("ゲームを開始します");
        Deck deck = new Deck();
        Player player = new Player();
        Dealer dealer = new Dealer();
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
                break;
            }
            player.getHand().addCard(deck.drawCard());
            System.out.println("あなたが引いたカードは " + player.getHand().getCards().get(player.getHand().getCards().size() - 1));
            if (player.getHand().isBusted()) {
                System.out.println("残念、バーストしてしまいました。");
                return;
            }
        }
        dealer.play(deck);
        if (dealer.getHand().isBusted()) {
            System.out.println("ディーラーがバーストしました！あなたの勝ちです！");
            return;
        }
        int playerPoints = player.getHand().calculatePoints();
        int dealerPoints = dealer.getHand().calculatePoints();
        System.out.println("あなたのポイント: " + playerPoints);
        System.out.println("ディーラーのポイント: " + dealerPoints);
        if (playerPoints > dealerPoints) {
            System.out.println("あなたの勝ちです！");
        } else if (playerPoints < dealerPoints) {
            System.out.println("あなたの負けです...");
        } else {
            System.out.println("引き分けです。");
        }
    }
}