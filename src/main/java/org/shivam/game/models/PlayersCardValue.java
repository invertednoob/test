package org.shivam.game.models;

public class PlayersCardValue {
	private Card[] cards;
    private int[] value;
    private String playerName;

    public PlayersCardValue(CardDeck d,String name) {
    	this.playerName=name;
        value = new int[4];
        cards = new Card[3];
        
        //get 3 cards for player from given deck
        for (int x = 0; x < 3; x++) {
            cards[x] = d.getCard();
        }
//        cards[0] = new Card(0,0);
//        cards[1] = new Card(1,0);
//        cards[2] = new Card(2,12);

        
        //to store player has which ranks of cards
        int[] ranks = new int[14];
        
        //to store high to low sequence card of player
        int[] orderedRanks = new int[3];
        
        boolean straight = false;
        
        //to store max number of same rank card
        int sameCards = 1;
        
        //to store no of cards of same rank
        int groupRank = 0;
        int index = 0;
        
        //to store highest value in a straight type hand
        int topStraightValue = 0;
        
        // logic to calculate the poker hand
        for (int x = 0; x <= 13; x++) {
            ranks[x] = 0;
        }
        
        
        for (int x = 0; x <= 2; x++) {
            ranks[cards[x].getRank()]++;
        }

        for (int x = 13; x >= 0; x--) {
            if (ranks[x] > sameCards) {
                if (sameCards == 1) {
                	groupRank = x;
                }

                sameCards = ranks[x];
            } 

        }
        if (ranks[0] == 1) {
            orderedRanks[index] = 14;
            index++;
        }
        for (int x = 13; x >= 1; x--) {
            if (ranks[x] == 1) {
                orderedRanks[index] = x;
                index++;
            }
        }
        for (int x = 0; x <= 10; x++) {
            if (ranks[x] == 1 && ranks[x+1] == 1 && ranks[x+2] == 1 ) {
                straight=true;
                topStraightValue = x + 2;
                break;
            }
        }
        if ( ranks[11] == 1 && ranks[12] == 1 && ranks[0] == 1) {
            straight = true;
            topStraightValue = 13;
        }
        for (int x = 0; x <= 3; x++) {
            value[x] = 0;
        }

        // start hand evaluation
        // High Card
        if (sameCards == 1) {
            value[0] = 1;
            value[1] = orderedRanks[0];
            value[2] = orderedRanks[1];
            value[3] = orderedRanks[2];
            
        }
        // Pair
        if (sameCards == 2 ) {
            value[0] = 2;
            value[1] = groupRank; //rank of pair
            value[2] = orderedRanks[0];
            
        }
        
        // Straight
        if (straight ) {
            value[0] = 3;
            value[1] = topStraightValue;
        }
        
        // Three of a kind
        if (sameCards == 3 ) {
            value[0] = 4;
            value[1] = groupRank;
            
        }
        
        
    }

    public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public void showResult() {
        String s;
        switch(value[0]) {
            case 1:
                s = "High Card";
                break;
            case 2:
                s = "Pair of " + Card.getRank(value[1]) + "s";
                break;
            case 3:
            	s = Card.getRank(value[1]) + " high Straight";
                break;
            case 4:
                s = "Three of a kind: " + Card.getRank(value[1]) + "s";
                break;
            default:
                s = "Invalid hand";
        }
        System.out.println("Hand Result: " + s+"\n");
    }

    public void showCards() {
        for (int x = 0; x < 3; x++)
            System.out.println(cards[x]);
    }

	public Card[] getCards() {
		return cards;
	}

	public void setCards(Card[] cards) {
		this.cards = cards;
	}

	public int[] getValue() {
		return value;
	}

	public void setValue(int[] value) {
		this.value = value;
	}
}
