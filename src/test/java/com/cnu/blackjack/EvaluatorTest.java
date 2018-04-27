package com.cnu.blackjack;

import org.junit.Before;
import org.junit.Test;

public class EvaluatorTest {
    Hand hand;
    @Before
    public void setUp() {
        hand = new Hand(new Deck(1));
    }

    @Test
    public void 게임초기화시_모든플레이어는_2장의카드를_받는다() {
        Player player = new Player(5000, hand);
        //dealcardtoplayer함수를 사용
        //assertThat(CardList.size(),is(2));
    }

    @Test
    public void 각_플레이어는_16이하면_히트한다() {
        Player player = new Player(5000, hand);
    }

    @Test
    public void 블랙잭이나오면_2배로_보상받고_해당_플레이어의_턴은_끝난다() {
        Player player = new Player(5000, hand);

    }

    @Test
    public void 각_플레이어는_17이상이면_스테이한다() {
        Player player = new Player(5000, hand);
    }

    @Test
    public void 각_플레이어에게_hit을_할_것인지_물어본다(){

    }

    @Test
    public void 각_플레이어가_hit에대해_잘못된_대답을_적었을_경우_다시_물어본다(){

    }

    @Test
    public void 플레이어가_stand를_할_경우_더이상_hit에_대해_물어보지_않는다(){

    }

    @Test
    public void 모든_플레이어가_stand를_할_경우_게임의_결과를_계산한다() {

    }
}
