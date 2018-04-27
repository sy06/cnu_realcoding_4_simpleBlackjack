package com.cnu.blackjack;

import org.junit.Before;
import org.junit.Test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

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
        //dealcardtoplayer함수를 사용
        Game game = new Game(new Deck(1));
        Evaluator evaluator = new Evaluator(game.getPlayerList());
        evaluator.start();
        game.getPlayerList().forEach((name, player) -> {

            assertThat(player.getHand().getCardList().size(),is(2));

        });

    }

    @Test
    public void 각_플레이어는_16이하면_히트한다() {
        Map<String, Player> playerlist = new HashMap<>();
        Player player = new Player(5000, hand);
        player.setCardlist_score(16);
        playerlist.put("player1", player);
        Evaluator evl = new Evaluator(playerlist);
        evl.hit_or_stand();
        assertTrue(player.getHand().getCardList().size() == 3);
    }

    @Test
    public void 블랙잭이나오면_2배로_보상받고_해당_플레이어의_턴은_끝난다() {
        Player player = new Player(5000, hand);

    }

    @Test
    public void 각_플레이어는_17이상이면_스테이한다() {
        Player player = new Player(5000, hand);
    }
}
