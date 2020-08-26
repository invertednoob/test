package org.shivam.game.models;

import java.util.ArrayList;
import java.util.Collections;

public class CardDeck {

	

	private ArrayList<Card> cards;

	public CardDeck() {
        cards = new ArrayList<>();
        
        //Add all possible combination of cards in the carddeck
        for (short a = 0; a <= 3; a++) {
            for (short b = 0; b <= 12; b++) {
                cards.add(new Card(a,b));
            }
        }
    }
	
	//method to shuffle the carddeck
    public void shuffle() {
        Collections.shuffle(cards);
    }
    
    
    public Card getCard() {
        return cards.remove(cards.size()-1);
    }
    
    public ArrayList<Card> getCards() {
		return cards;
	}
	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}

}
