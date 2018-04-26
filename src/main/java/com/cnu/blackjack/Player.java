package com.cnu.blackjack;

import com.cnu.blackjack.exceptions.NotEnoughBalanceException;
import lombok.Data;

@Data
public class Player {

    private int balance;
    private int currentBet;
    private Hand hand;

    public Player(int seedMoney, Hand hand) {
        this.balance = seedMoney;
        this.hand = hand;
    }

    public void placeBet(int bet) {
        if (balance < bet) {
            throw new NotEnoughBalanceException();
        }
        balance -= bet;
        currentBet = bet;
    }
    //결과에 따라서 해당 배팅금액을 player에게 지불하는 메소드
    public void resultBet(){
        
    }

    //덱에서 카드를 받아오는것
    public Card hitCard() {
        return hand.drawCard();
    }
}
