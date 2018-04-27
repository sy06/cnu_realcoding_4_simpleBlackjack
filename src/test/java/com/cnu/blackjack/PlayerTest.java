package com.cnu.blackjack;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class PlayerTest {

    Hand hand;

    @Before
    public void setUp() {
        hand = new Hand(new Deck(1));
    }

    @Test
    public void 플레이어는_시드머니를_가지고_시작한다() {
        Player player = new Player(5000, hand);
        assertThat(player.getBalance(), is(5000));
    }

    @Test
    public void 플레이어는_배팅을_할수_있어야한다() {
        Player player = new Player(10000, hand);
        player.placeBet(1000);
        int currentBet = player.getCurrentBet();
        assertThat(currentBet, is(1000));
    }

    @Test(expected = Exception.class)
    public void 플레이어는_발란스_이하로_배팅할수_없다() {
        Player player = new Player(5000, hand);
        player.placeBet(6000);
    }

    @Test
    public void 플레이어는_카드를_HIT_할수_있어야한다() {
        Player player = new Player(5000, hand);
        assertThat(player.hitCard(), notNullValue());
    }

    @Test
    public void 플레이어가_받은카드의_rank의합이_플레이어의_카드리스트점수와_같아야한다(){
        Player player = new Player(5000, hand);
        Card tempcard1 = player.hitCard();
        Card tempcard2 = player.hitCard();
        int tempscore = tempcard1.getRank()+tempcard2.getRank();
        assertTrue(player.cardlist_score_count() == tempscore);
    }

}
