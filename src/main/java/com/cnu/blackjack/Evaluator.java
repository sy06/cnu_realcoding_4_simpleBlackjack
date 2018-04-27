package com.cnu.blackjack;

import lombok.Data;

import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

@Data
public class Evaluator {

    private Map<String, Player> playerMap;
    private Dealer dealer;
    public AppIO input = new AppIO();

    public Evaluator(Map<String, Player> playerMap) {
        this.playerMap = playerMap;
        dealer = new Dealer();
        dealCardToPlayers();
    }

    public void start(){
        input.AppIO_msg_Welcome();
        this.dealCardToPlayers();
        this.hit_or_stand();
        this.result();
    }

    private void result() {
        int dealer_score = this.dealer.getDealerScore();
        playerMap.forEach((name, player) ->{
            boolean win = this.compare_score_and_batcount(dealer_score, player.cardlist_score_count());
        });
    }

    private boolean compare_score_and_batcount(int dealerscore, int playerscore){
        this.batting_count();
        return true;
    }

    //hitCard() = 덱에서 카드 한장을 뽑아서 사용자의 카드 리스트에 추가해준다.
    //맨 처음에만 호출하는거
    private void dealCardToPlayers() {
        playerMap.forEach((name, player) -> {
            player.hitCard();
            player.hitCard();
            input.AppIO_msg_UserHit(name);
        });
    }

    public void hit_or_stand() {
        //player가 hit을 하면 카드를 주고 그렇지 않으면 주지 않는다.

        playerMap.forEach((name, player) -> {
            int score = player.getCardlist_score();
            if (score == 21) {
                this.blackjack(name, player);
            } else if (score < 17) {
                while(player.getCardlist_score() < 17) {
                    player.hitCard();
                }
                input.AppIO_msg_UserStand(name);
            }
        });
    }

    private void blackjack(String name, Player player) {
        player.setBalance(player.getBalance() + player.getCurrentBet() * 2);
        player.setCurrentBet(0);
        input.AppIO_msg_WinBlackjack_Player(name);
    }

    public void batting_count() {
        /*
        7. 배팅금액 지불
            -> player가 블랙잭일 경우
            -> 딜러가 우승했을 경우
            -> player가 우승했을 경우
            -> 딜러가 17이 넘을경우 무조건 패배
         */
    }
}
