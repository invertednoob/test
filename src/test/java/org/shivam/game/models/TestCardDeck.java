package org.shivam.game.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class TestCardDeck {
	
	@Test
    public void testGetCards() {
		
		CardDeck c=new CardDeck();
        assertEquals(52, c.getCards().size());
    }
	
	@Test
    public void testGetCard() {
		
		CardDeck cd=new CardDeck();
		Card c =cd.getCard();
        assertEquals(51, cd.getCards().size());
    }

}
