package com.cnu.blackjack;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class EvaluatorTest {
    Hand hand;
    @Before
    public void setUp() {
        hand = new Hand(new Deck(1));
    }

    @Test
    public void 게임초기화시_모든플레이어는_2장의카드를_받는다() {
    }

    @Test
    public void 각_플레이어는_16이하면_히트한다() {
        Map<String, Player> playerlist = new HashMap<>();
        Player player = new Player(5000, hand);
        playerlist.put("player1", player);
        Evaluator evl = new Evaluator(playerlist);
        player.setCardlist_score(16);
        evl.hit_or_stand();
        assertTrue(player.getHand().getCardList().size() == 3);
    }

    @Test
    public void 블랙잭이나오면_2배로_보상받고_해당_플레이어의_턴은_끝난다() {
        Map<String, Player> playerlist = new HashMap<>();
        Player player1 = new Player(5000, hand);
        player1.placeBet(1000);
        playerlist.put("player1", player1);
        Evaluator evl = new Evaluator(playerlist);
        player1.setCardlist_score(21);
        evl.hit_or_stand();
        assertTrue(player1.getBalance() == 6000);
    }

    @Test
    public void 각_플레이어는_17이상이면_스테이한다() {
        Map<String, Player> playerlist = new HashMap<>();
        Player player1 = new Player(5000, hand);
        playerlist.put("player1", player1);
        Evaluator evl = new Evaluator(playerlist);
        player1.setCardlist_score(17);
        evl.hit_or_stand();
        assertTrue(player1.getCardlist_score() == 17);
    }
}
