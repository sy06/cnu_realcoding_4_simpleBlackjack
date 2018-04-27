package com.cnu.blackjack;

import java.util.Map;

public class Evaluator {

    private Map<String, Player> playerMap;
    private Map<String, Player> hitplayerMap;
    private Dealer dealer;

    public Evaluator(Map<String, Player> playerMap) {
        this.playerMap = playerMap;
        dealer = new Dealer();
        dealCardToPlayers();

    }

    public void start() {
        hit_or_stand();
        result();
    }

    private void result() {
        int dealer_score = this.dealer.getDealerScore();
        playerMap.forEach((name, player) ->{
            boolean win = this.compare_score_and_batcount(dealer_score, player.cardlist_score_count(), player);
        });
    }

    private boolean compare_score_and_batcount(int dealerscore, int playerscore, Player player){
        this.batting_count(player);
        return true;

    }

    //hitCard() = 덱에서 카드 한장을 뽑아서 사용자의 카드 리스트에 추가해준다.
    //맨 처음에만 호출하는거
    private void dealCardToPlayers() {
        playerMap.forEach((name, player) -> {
            player.hitCard();
            player.hitCard();
        });
    }

    public void hit_or_stand() {
        //player가 hit을 하면 카드를 주고 구렇지 않으면 주지 않는다.
        /*1. player중 한명이라도 hit을 원하면 hit을 하는 조건문으로 들어감
          2. 전체 playerlist를 순회하면서 hit을 원하는 player만 따로 list생성
          3. 해당 player에게 hit메소드 호출
          4. 딜러에게도 hit메소드 호출
          5. 모든 사람이 stop을 외칠때까지 반복
        */
    }

    public int batting_count(Player player) {
        //returnBet은 batting에서 딴 금액이다.
        //사용자가 이겼을때 원래 배팅한 금액을 돌려주고, returnBet을 더해준다.
        int returnBet = 0;
        /*
        7. 배팅금액 지불
            -> player가 블랙잭일 경우
            -> 딜러가 우승했을 경우
            -> player가 우승했을 경우
            -> 딜러가 21이 넘을경우 무조건 패배
         */

        // 딜러가 21이 넘을 경우
        if(dealer.getDealerScore() > 21){
            returnBet = player.getCurrentBet();
        }
        //player가 21이 넘을 경우
        else if(player.cardlist_score_count() > 21){
            returnBet = 0;
        }
        // player가 블랙잭일 경우
        else if(player.cardlist_score_count() == 21 && player.getHand().getCardList().size() == 2){
                returnBet = player.getCurrentBet()*2;
        }
        else{
            if(dealer.getDealerScore() > player.cardlist_score_count())
                returnBet = 0;
            else
                returnBet = player.getCurrentBet();
            
        }
        return returnBet;
    }

}
