package org.shivam.game.models;

public class Card {
	
	private int rank;
	private int suit;
	
	//Default list of values allowed for suites
	static String[] suits = {"HEARTS", "SPADES", "DIAMONDS", "CLUBS"};
	
	//Default list of values allowed for ranks
    static String[] ranks = {"ACE","2", "3", "4", "5", "6", "7", "8", "9", "10", "JACK", "QUEEN", "KING","ACE"};

    public static String getRank(int rank) {
        return ranks[rank];
    }

    Card(int suit, int rank) {
        this.rank = rank;
        this.suit = suit;
    }
    
    //Override toString method to print details of a card
    @Override
    public String toString() {
        return ranks[rank] + " of " + suits[suit];
    }
    public int getRank() {
        return rank;
    }
    public int getSuit() {
        return suit;
    }

}
