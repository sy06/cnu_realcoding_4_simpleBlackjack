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
        this.hit_or_stand();
        System.out.println();
        this.result();
    }

    public void result() {
        playerMap.forEach((name, player) ->{
            boolean win = this.compare_score_and_batcount(player, name);
            System.out.println("---------------------------------------");
        });
    }

    private boolean compare_score_and_batcount(Player player, String name){
        int playerMoney = player.cal_BetMoney(batting_count(player, name));
        input.AppIO_CurrentAsset(playerMoney,name);
        if (playerMoney == 0) {
            input.AppIO_msg_WasteMoney(name);
        }
        return true;

    }

    //hitCard() = 덱에서 카드 한장을 뽑아서 사용자의 카드 리스트에 추가해준다.
    //맨 처음에만 호출하는거
    public void dealCardToPlayers() {
        playerMap.forEach((name, player) -> {
            player.hitCard();
            player.hitCard();
        });
    }

    public void hit_or_stand() {
        //player가 hit을 하면 카드를 주고 그렇지 않으면 주지 않는다.
        dealer.setDealerScore(); //딜러 점수 세팅

        playerMap.forEach((name, player) -> {
            int score = player.cardlist_score_count();
            if (score == 21) {
                player.getHand().stateOfPlayerHand(name);
                this.blackjack(name, player);
            } else if (score < 17) {
                player.getHand().stateOfPlayerHand(name);
                while(score < 17){
                    player.hitCard();
                    input.AppIO_msg_UserHit(name);
                    player.getHand().stateOfPlayerHand(name);
                    score = player.cardlist_score_count();
                }
                input.AppIO_msg_UserStand(name);
            }
            System.out.println();
            System.out.println("*** 최종결과 ***");
            player.getHand().stateOfPlayerHand(name);
            input.AppIO_msg_ShowPlayerScore(score,name);
            input.AppIO_msg_ShowDealerScore(dealer.getDealerScore()); //딜러 점수 보여주기
            System.out.println("---------------------------------------");
        });
    }

    private void blackjack(String name, Player player) {
        player.setBalance(player.getBalance() + player.getCurrentBet() * 2);
        player.setCurrentBet(0);
        input.AppIO_msg_WinBlackjack_Player(name);
    }

    public int batting_count(Player player, String name) {
        //returnBet은 batting에서 딴 금액이다.
        //사용자가 이겼을때 원래 배팅한 금액을 돌려주고, returnBet을 더해준다.
        int returnBet = 0;
        /*
        7. 배팅금액 지불
            -> player가 블랙잭일 경우
            -> 딜러가 우승했을 경우
            -> player가 우승했을 경우
            -> 딜러가 21이 넘을경우 무조건 패배
            -> 딜러랑 플레이어의 카드 총 합이 같을 경우 패배
         */

        // 딜러가 21이 넘을 경우
        if(dealer.getDealerScore() > 21){
            if (player.cardlist_score_count() > 21) { //둘 다 21점이 넘을 경우
                returnBet = player.getCurrentBet();
                input.AppIO_msg_SameBurst(name);
            }
            else {//딜러만 21이 넘을 경우
                returnBet = player.getCurrentBet();
                input.AppIO_msg_Over21byDealer();
            }
        }
        //player만 21이 넘을 경우
        else if(player.cardlist_score_count() > 21){
            returnBet = 0;
            input.AppIO_msg_Over21byPlayer(name);
        }

        else if (dealer.getDealerScore() == player.cardlist_score_count()) {//딜러와 플레이어의 카드 총 합이 같을 경우
            returnBet = 0;
            input.AppIO_msg_DealerWinWhenSameScore(name);
        }
        // player가 블랙잭일 경우
        else if(player.cardlist_score_count() == 21 && player.getHand().getCardList().size() == 2){
            returnBet = player.getCurrentBet()*2;
            input.AppIO_msg_WinBlackjack_Player(name);
        }

        else if (dealer.getDealerScore() == 21) {   //딜러가 블랙잭일 경우
            returnBet = 0;
            input.AppIO_msg_WinBlackjack_Dealer();
        }
        else {
            if (dealer.getDealerScore() > player.cardlist_score_count()) {
                returnBet = 0;
                input.AppIO_DealerWinandPoint(dealer.getDealerScore(), player.cardlist_score_count());
            } else {
                returnBet = player.getCurrentBet();
                input.AppIO_PlayWinandPoint(player.cardlist_score_count(), dealer.getDealerScore(), name);
            }
        }
        return returnBet;
    }

}
