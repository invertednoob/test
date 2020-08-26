package org.shivam.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.shivam.game.models.Card;
import org.shivam.game.models.CardDeck;
import org.shivam.game.models.PlayersCardValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CardGame {
	
	//private static final Logger logger = LoggerFactory.getLogger(CardGame.class);
	public static void main(String[] args) {
		CardDeck cardDeck = new CardDeck();
		
		
        // Shuffle the deck
		cardDeck.shuffle();
        
        int players = 4; // number of players
        
        Map<String,PlayersCardValue> playerMap = new HashMap<>();
        
        
        // Give cards to players and show each players card details
        for (int i = 1; i <= players; i++) {
        	String playerName= "PLAYER" + i;
        	PlayersCardValue hand = new PlayersCardValue(cardDeck,playerName);
        	System.out.println(playerName + " :");
        	
            hand.showCards();
            hand.showResult();
            playerMap.put(playerName, hand);        
            }
        
        String player= getResult(playerMap);
        int[] values=  playerMap.get(player).getValue();
        if(values[0] == 1) {
        	
        	System.out.println("Result is high card, so checking for uniqueness ");
        	
        	int highRank = values[1];
        	
        	List<String> commonHighPlayers = new ArrayList<>();
        	
        	for(PlayersCardValue p: playerMap.values()) {
    			int[] pvalues=  p.getValue();
    			if(highRank == pvalues[1]) {
    				commonHighPlayers.add(p.getPlayerName());
    			}
    			
    			
        	}
        	if(commonHighPlayers.size()>1) {
        		
        		Map<Integer,String> playerHighCardRankMap= new HashMap<>();
        		Set<Integer> uniqueRank = new HashSet<>();
        		while(true) {
        			
        			for(String playerN: commonHighPlayers) {
        				Card c = cardDeck.getCard();
        				playerHighCardRankMap.put(c.getRank(),playerN);
        				uniqueRank.add(c.getRank());
        			}
        			if(playerHighCardRankMap.size()>1) {
        				int maxRank=0;
        				for(Map.Entry<Integer, String> e: playerHighCardRankMap.entrySet()) {
        					if(e.getKey()>maxRank) {
        						player= e.getValue();
        					}
        				}
        				break;
        			}
        		}
        	}
        }
        
        System.out.println("Winner is: "+player);
    }
	
	public static String getResult(Map<String,PlayersCardValue> playerMap) {
		
		String playerName="";
		
		int maxHandType = 0;
		int maxHandTypeHigh1 = -1;
		int maxHandTypeHigh2 = -1;
		
		for(PlayersCardValue p: playerMap.values()) {
			int[] values=  p.getValue();
			if(values[0]>maxHandType) {
				maxHandType = values[0];
				playerName = p.getPlayerName();
				
				switch(values[0]) {
		            case 1:
		                maxHandTypeHigh1 = values[1];
		                break;
		            case 2:
		            	maxHandTypeHigh1 = values[1];
		            	maxHandTypeHigh2 = values[2];
		                break;
		            case 3:
		            	maxHandTypeHigh1 = values[1];
		                break;
		            case 4:
		            	maxHandTypeHigh1 = values[1];
		                break;
		            default:
		                break;
		        }
			} else if(values[0] == maxHandType) {
				
				switch(values[0]) {
		            case 1://for high card
		                if(maxHandTypeHigh1 < values[1]) {
		                	playerName = p.getPlayerName();
		                	maxHandTypeHigh1 = values[1];
		                }
		                break;
		            case 2://for pair
		            	maxHandTypeHigh1 = values[1];
		            	maxHandTypeHigh2 = values[2];
		            	if(maxHandTypeHigh1 < values[1]) {
		                	playerName = p.getPlayerName();
		                	maxHandTypeHigh1 = values[1];
		                	maxHandTypeHigh2 = values[2];
		                } else if(maxHandTypeHigh1 == values[1] && maxHandTypeHigh2 < values[2]) {
		                	playerName = p.getPlayerName();
		                	maxHandTypeHigh1 = values[1];
		                	maxHandTypeHigh2 = values[2];
		                }
		                break;
		            case 3://for straight
		            	if(maxHandTypeHigh1 < values[1]) {
		                	playerName = p.getPlayerName();
		                	maxHandTypeHigh1 = values[1];
		                }
		                break;
		            case 4://for triplet
		            	if(maxHandTypeHigh1 < values[1]) {
		                	playerName = p.getPlayerName();
		                	maxHandTypeHigh1 = values[1];
		                }
		                break;
		            default:
		                break;
		        }
				
			}
			
		}
		
		
		
		return playerName;
	}
}
