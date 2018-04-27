package com.cnu.blackjack;

import com.cnu.blackjack.exceptions.NotEnoughBalanceException;
import lombok.Data;

import java.util.List;
import java.util.Scanner;

@Data
public class Player {

    private int balance;
    private int currentBet;
    private Hand hand;
    private int cardlist_score;

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

    //덱에서 카드를 받아오는것
    public Card hitCard() {
        return hand.drawCard();
    }

    public int cardlist_score_count(){
        //카드 스코어를 계산하여 리턴
        List<Card> playerCardList = hand.getCardList();
        cardlist_score=0;

        for(int i=0;i<playerCardList.size();i++){
            cardlist_score += playerCardList.get(i).getRank();
        }

        return cardlist_score;
    }
}
