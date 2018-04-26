package com.cnu.blackjack;

public class Application {
    public static void main(String[] args) {
        Deck deck = new Deck(1);
        Game game = new Game(deck);

        game.addPlayer("player1", 5000);
        game.addPlayer("player2", 10000);

        game.start();
    }
    //addplayer를 호출한다.
    //addDealer를 호출한다.
    //game.start를 호출한다.
}