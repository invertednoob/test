package org.shivam.game.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class TestCard {
	
	@Test
    public void testGetRank() {
		
		Card c=new Card(0,0);
        assertEquals(0, c.getRank());
    }
	
	@Test
    public void testGetSuit() {
		
		Card c=new Card(0,0);
        
        assertNotEquals(1, c.getSuit());
    }


}
