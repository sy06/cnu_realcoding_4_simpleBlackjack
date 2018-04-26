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
        //Game객체를 생성해준다. -> 생성자에 새로운 덱을 생성해서 넘겨줌 Game game = new Game(new Deck(number));
        //Game.start를 호출해준다.
    }

    //hitCard() = 덱에서 카드 한장을 뽑아서 사용자의 카드 리스트에 추가해준다.
    //맨 처음에만 호출하는거
    private void dealCardToPlayers() {
        playerMap.forEach((name, player) -> {
            player.hitCard();
            player.hitCard();
        });
    }
}
