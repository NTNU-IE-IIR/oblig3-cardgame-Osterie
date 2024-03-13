package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.Collection;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CardGameView extends Application{
    private CardGameController controller;

    private HBox cardsContainer;

    private BorderPane rootNode;
    
    private TextField sumOfFacesField;
    private TextField cardsOfHeartField;
    private TextField isFlushField;
    private TextField hasQueenOfSpadesField;

    public CardGameView() {
    }

    @Override
    public void start(Stage stage) {
        this.controller = new CardGameController(this);
        
        rootNode = new BorderPane();

        this.createCardDisplayArea();
        this.createDealCheckHandArea();
        this.createInfoAboutHandArea();


        
        Scene scene = new Scene(rootNode, 500, 500);
        scene.getStylesheets().add(getClass().getResource("resources/style.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("MVC exmaple");
        stage.show();
    }

    private void createCardDisplayArea() {
        this.cardsContainer = new HBox();
        this.cardsContainer.setAlignment(Pos.CENTER);
        rootNode.setCenter(this.cardsContainer);
        this.cardsContainer.setSpacing(10);
    }

    private void createDealCheckHandArea() {
        VBox dealCheckHand = new VBox();
        dealCheckHand.setAlignment(Pos.CENTER);
        rootNode.setRight(dealCheckHand);

        Button dealHandButton = new Button("Deal hand");
        dealHandButton.setOnAction((ActionEvent event) -> {
            this.controller.dealHand();
        });
        dealCheckHand.getChildren().add(dealHandButton);

        
        Button checkHandButton = new Button("Check hand");
        checkHandButton.setOnAction((ActionEvent event) -> {
            controller.analyzeHand();
        });
        dealCheckHand.getChildren().add(checkHandButton);
    }

    private void createInfoAboutHandArea() {

        VBox infoAboutHandArea = new VBox();
        infoAboutHandArea.setAlignment(Pos.CENTER);
        rootNode.setBottom(infoAboutHandArea);
        infoAboutHandArea.setSpacing(10);

        FlowPane horizontalContainer = new FlowPane();
        infoAboutHandArea.getChildren().add(horizontalContainer);



        Label sumOfFacesLabel = new Label("Sum of faces: ");
        horizontalContainer.getChildren().add(sumOfFacesLabel);

        this.sumOfFacesField = new TextField();
        this.sumOfFacesField.setText("");
        this.sumOfFacesField.setEditable(false);
        horizontalContainer.getChildren().add(this.sumOfFacesField);

        Label cardsOfHeartLabel = new Label("Cards of heart: ");
        horizontalContainer.getChildren().add(cardsOfHeartLabel);

        this.cardsOfHeartField = new TextField();
        this.cardsOfHeartField.setText("");
        this.cardsOfHeartField.setEditable(false);
        horizontalContainer.getChildren().add(this.cardsOfHeartField);

        Label isFlushLabel = new Label("Flush: ");
        horizontalContainer.getChildren().add(isFlushLabel);

        this.isFlushField = new TextField();
        this.isFlushField.setText("");
        this.isFlushField.setEditable(false);
        horizontalContainer.getChildren().add(this.isFlushField);

        Label hasQueenOfSpadesLabel = new Label("Queen of spades: ");
        horizontalContainer.getChildren().add(hasQueenOfSpadesLabel);

        this.hasQueenOfSpadesField = new TextField();
        this.hasQueenOfSpadesField.setText("");
        this.hasQueenOfSpadesField.setEditable(false);
        horizontalContainer.getChildren().add(this.hasQueenOfSpadesField);
    }

    public void setSumOfFaces(int sumOfFaces){
        this.sumOfFacesField.setText(Integer.toString(sumOfFaces));
    }

    public void setCardsOfHeart(String cardsOfHeart){
        this.cardsOfHeartField.setText(cardsOfHeart);
    }

    public void setIsFlush(boolean isFlush){
        this.isFlushField.setText(Boolean.toString(isFlush));
    }

    public void setHasQueenOfSpades(boolean hasQueenOfSpades){
        this.hasQueenOfSpadesField.setText(Boolean.toString(hasQueenOfSpades));
    }

    // TODO if this were to follow best practices and such, i would instead give a collection of string instead of playingCard, but i will not change this.
    public void setHand(Hand hand){
        this.cardsContainer.getChildren().clear();
        for (PlayingCard card : hand.getCards()) {
            Label cardLabel = new Label(card.getAsString());
            this.cardsContainer.getChildren().add(cardLabel);
        }
    }

    public static void appMain(String[] args) {
        launch(args);
    }

}