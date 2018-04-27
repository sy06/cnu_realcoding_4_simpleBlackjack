package com.cnu.blackjack;

import java.util.concurrent.ThreadLocalRandom;

public class Dealer {

    //덱을 가질 수 있는 생성자 만들어주기
    //evaluator에서 사용한다.

    public int getDealerScore() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int score = random.nextInt(17, 25);
        //System.out.println(score);
        return score;
    }
}
