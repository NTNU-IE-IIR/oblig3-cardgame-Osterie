package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DeckOfCards {

    private final char[] suits = { 'S', 'H', 'D', 'C' };
    private final int[] faces = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };

    private final ArrayList<PlayingCard> deck = new ArrayList<PlayingCard>();

    public DeckOfCards() {
        this.createDeck();
        this.shuffle();
    }

    public void resetCards(){
        this.deck.clear();
        this.createDeck();
        this.shuffle();
    }

    public Hand dealHand(int numberOfCards){

        Hand hand = new Hand();
        for (int i = 0; i < numberOfCards; i++) {
            // Removes card from deck. This is good if multiple players want to play against eachother.
            hand.addCard(deck.remove(0));
        }

        return hand;
    }

    private void shuffle(){
        Collections.shuffle(deck);
    }

    private void createDeck() {
        for (char suit : suits) {
            for (int face : faces) {
                this.addCard(new PlayingCard(suit, face));
            }
        }
    }

    private void addCard(PlayingCard card) {
        this.deck.add(card);
    }
}
