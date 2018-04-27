package com.cnu.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private Deck deck;
    private List<Card> cardList = new ArrayList<Card>();

    public Hand(Deck deck) {
        this.deck = deck;
    }

    public Card drawCard() {
        Card card = deck.drawCard();
        cardList.add(card);
        return card;
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public void stateOfPlayerHand(String name) { //현재 플레이어 손에 있는 카드들을 출력하는 함수
        System.out.println("-플레이어 " + name + "의 카드-");
        for (int i = 0 ; i < cardList.size() ; i++) {
            System.out.print("[" + cardList.get(i).getSuit() + " " + cardList.get(i).getRank() + "]");
            System.out.print(" ");
        }
    }
}
