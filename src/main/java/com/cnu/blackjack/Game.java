package com.cnu.blackjack;

import com.cnu.blackjack.exceptions.DuplicatePlayerException;
import com.cnu.blackjack.exceptions.NotEveyonePlacedBetException;
import com.cnu.blackjack.exceptions.PlayerDoesNotExistException;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {

    private Map<String, Player> playerList = new HashMap<>();
    private Deck deck;
    private Evaluator evaluator;

    public Game(Deck deck) {
        this.deck = deck;
    }

    //새로운 player를 생성한다.
    public void addPlayer(String playerName, int seedMoney) {
        Player player = new Player(seedMoney, new Hand(deck));
        if (playerList.get(playerName) != null) {
            throw new DuplicatePlayerException();
        }
        playerList.put(playerName, player);
    }


    public Map<String, Player> getPlayerList() {
        return playerList;
    }

    public void start() {

        Scanner sc = new Scanner(System.in);
        playerList.forEach((name, player) -> {
            //player에게 현재 배팅할 금액을 입력받는다
            System.out.println(name+": 배팅할 금액을 입력하세요");
            int initialbetmoney = sc.nextInt();
            placeBet(name,initialbetmoney);

            //placeBet가 범위를 넘어갈 때도 test해줘야함. (추가해야함.)
            if (player.getCurrentBet() == 0) {
                throw new NotEveyonePlacedBetException();
            }
        });
        //evaluator를 생성하여 실행한다.
        evaluator.start();

    }

    public void placeBet(String name, int bet) {
        Player player = playerList.get(name);
        if (player == null) {
            throw new PlayerDoesNotExistException();
        }
        player.placeBet(bet);
    }
}
