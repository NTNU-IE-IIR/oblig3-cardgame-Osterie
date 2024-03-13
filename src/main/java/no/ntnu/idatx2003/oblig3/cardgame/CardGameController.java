package no.ntnu.idatx2003.oblig3.cardgame;

public class CardGameController {
    private final CardGameView cardGameView;
    private final DeckOfCards deckOfCards;

    public CardGameController(CardGameView cardGameView) {
        deckOfCards = new DeckOfCards();
        this.cardGameView = cardGameView;
    }

    public void DealHand(){
        cardGameView.SetHand(deckOfCards.dealHand(5));
        deckOfCards.resetCards();
    }
}
