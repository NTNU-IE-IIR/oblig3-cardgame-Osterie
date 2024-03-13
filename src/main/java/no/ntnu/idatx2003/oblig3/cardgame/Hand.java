package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.ArrayList;

public class Hand {
    
    private final ArrayList<PlayingCard> hand;
    
    public Hand() {
        this.hand = new ArrayList<PlayingCard>();
    }
    
    public void addCard(PlayingCard card) {
        this.hand.add(card);
    }
    
    public PlayingCard getCard(int index) {
        return this.hand.get(index);
    }

    public ArrayList<PlayingCard> getCards(){
        return this.hand;
    }
    
    public void clearHand() {
        this.hand.clear();
    }

    public int sumOfFaces() {
        int sum = 0;
        for (PlayingCard card : this.hand) {
            sum += card.getFace();
        }
        return sum;
    }

    public ArrayList<String> cardsOfHeart() {
        ArrayList<String> cardsOfHeartStrings = new ArrayList<String>();
        for (PlayingCard card : this.hand) {
            if (card.getSuit() == 'H') {
                cardsOfHeartStrings.add(card.getAsString());
            }
        }
        return cardsOfHeartStrings;
    }

    public boolean isFlush() {
        char suit = this.hand.get(0).getSuit();

        boolean isFlush = true;
        for (PlayingCard card : this.hand) {
            if (card.getSuit() != suit) {
                isFlush = false;
            }
        }
        return isFlush;
    }

    public boolean hasQueenOfSpades() {

        boolean hasQueenOfSpades = false;
        for (PlayingCard card : this.hand) {
            if (card.getSuit() == 'S' && card.getFace() == 12) {
                hasQueenOfSpades = true;
            }
        }
        return hasQueenOfSpades;
    }
}
