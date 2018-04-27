package com.cnu.blackjack;

import java.util.concurrent.ThreadLocalRandom;

public class Dealer {

    //덱을 가질 수 있는 생성자 만들어주기
    //evaluator에서 사용한다.
    private int score = 17; //초기세팅

    public void setDealerScore() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        score = random.nextInt(17, 25);
    }

    public int getDealerScore(){
        return score;
    }
}
