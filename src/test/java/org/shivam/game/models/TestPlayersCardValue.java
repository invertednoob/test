package org.shivam.game.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class TestPlayersCardValue {
	
	@Test
    public void testGetPlayerName() {
		
		CardDeck cardDeck=new CardDeck();
		String playerName= "PLAYER1";
    	PlayersCardValue hand = new PlayersCardValue(cardDeck,playerName);
        assertEquals("PLAYER1", hand.getPlayerName());
    }
	
	@Test
    public void testGetCards() {
		
		CardDeck cardDeck=new CardDeck();
		String playerName= "PLAYER1";
    	PlayersCardValue hand = new PlayersCardValue(cardDeck,playerName);
        assertEquals(3, hand.getCards().length);
    }
	
	@Test
    public void testGetValue() {
		
		CardDeck cardDeck=new CardDeck();
		String playerName= "PLAYER1";
    	PlayersCardValue hand = new PlayersCardValue(cardDeck,playerName);
        assertEquals(4, hand.getValue().length);
    }

}
