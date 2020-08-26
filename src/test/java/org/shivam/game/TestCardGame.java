package org.shivam.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import java.util.HashMap;
import java.util.Map;


import org.shivam.game.models.CardDeck;
import org.shivam.game.models.PlayersCardValue;

public class TestCardGame {
	
	@Test
	public void testGetResult() {
		
		
		
		CardDeck cardDeck = new CardDeck();
		
		cardDeck.shuffle();
		
		Map<String,PlayersCardValue> playerMap = new HashMap<>();
		
		String playerName1= "PLAYER1" ;
    	PlayersCardValue hand1 = new PlayersCardValue(cardDeck,playerName1);
    	
        playerMap.put(playerName1, hand1); 
        
        String playerName2= "PLAYER2" ;
    	PlayersCardValue hand2 = new PlayersCardValue(cardDeck,playerName2);
    	
        playerMap.put(playerName2, hand2); 
        
        assertNotEquals("", CardGame.getResult(playerMap));
	}

}
