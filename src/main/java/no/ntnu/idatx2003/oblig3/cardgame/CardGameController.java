package no.ntnu.idatx2003.oblig3.cardgame;

public class CardGameController {
    private final CardGameView cardGameView;
    private final DeckOfCards deckOfCards;
    private Hand hand;

    public CardGameController(CardGameView cardGameView) {
        this.deckOfCards = new DeckOfCards();
        this.cardGameView = cardGameView;
        this.hand = new Hand();
    }

    public void dealHand(){
        this.hand = deckOfCards.dealHand(5);
        this.cardGameView.setHand(hand);
        this.deckOfCards.resetCards();
    }

    public void analyzeHand(){

        this.cardGameView.setSumOfFaces(this.hand.sumOfFaces());
        String cardsOfHeartAsString = "";
        for (String card : this.hand.cardsOfHeart()) {
            cardsOfHeartAsString += card + " ";
        }
        this.cardGameView.setCardsOfHeart(cardsOfHeartAsString);
        this.cardGameView.setIsFlush(this.hand.isFlush());
        this.cardGameView.setHasQueenOfSpades(this.hand.hasQueenOfSpades());

    }
}
