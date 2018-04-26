package com.cnu.blackjack;

import java.util.Map;

public class Evaluator {

    private Map<String, Player> playerMap;
    private Dealer dealer;

    public Evaluator(Map<String, Player> playerMap) {
        this.playerMap = playerMap;
        dealer = new Dealer();
        dealCardToPlayers();
    }

    public void start() {
        hitting();
        counting();
        batting_count();
    }

    //hitCard() = 덱에서 카드 한장을 뽑아서 사용자의 카드 리스트에 추가해준다.
    //맨 처음에만 호출하는거
    private void dealCardToPlayers() {
        playerMap.forEach((name, player) -> {
            player.hitCard();
            player.hitCard();
        });
    }

    public void hitting() {
        /*1. player중 한명이라도 hit을 원하면 hit을 하는 조건문으로 들어감
          2. 전체 playerlist를 순회하면서 hit을 원하는 player만 따로 list생성
          3. 해당 player에게 hit메소드 호출
          4. 딜러에게도 hit메소드 호출
          5. 모든 사람이 stop을 외칠때까지 반복
        */
    }

    public void counting() {
        /*  6. 모든 카드를 공개하고 딜러 카드와 비교하여 승패 결정 */
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
