package com.cnu.blackjack;

import com.cnu.blackjack.exceptions.NoMoreCardException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
    private final int number;
    private final List<Card> cardList;

    public Deck(int number) {
        this.number = number;
        this.cardList = new ArrayList<Card>();
        createCards(number);
        Collections.shuffle(cardList);
    }

    private void createCards(int number) {
        // create card for single deck
        for (int j = 0; j < number; j++) {
            for (Suit suit : Suit.values()) {
                for (int i = 1 ; i < 14; i++) {
                    Card card = new Card(i, suit);
                    cardList.add(card);
                }
            }
        }
    }

    public int getTotalCard() {
        return cardList.size();
    }

    public Card drawCard() {
        if (cardList.size() == 0) {
            throw new NoMoreCardException();
        }
        return cardList.remove(0);
    }

    public void shuffle() {
	for (int i = 51 ; i > 0 ; i--) {
	    Random ran = new Random();
	    int random = ran.nextInt() % (i+1);
	    Card temp = cardList.get(i);
	    cardList.set(i, cardList.get(random));
	    cardList.set(random, temp);
	}
    }
}
