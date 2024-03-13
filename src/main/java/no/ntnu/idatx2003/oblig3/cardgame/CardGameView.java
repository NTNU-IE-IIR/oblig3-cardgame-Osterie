package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.Collection;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CardGameView extends Application{
    private CardGameController controller;

    private HBox centerContainer;

    public CardGameView() {
    }

    @Override
    public void start(Stage stage) {
        
        this.controller = new CardGameController(this);
        
        BorderPane rootNode = new BorderPane();
        
        this.centerContainer = new HBox();
        this.centerContainer.setAlignment(Pos.CENTER);
        rootNode.setCenter(this.centerContainer);

        VBox rightContainer = new VBox();
        rightContainer.setAlignment(Pos.CENTER);
        rootNode.setRight(rightContainer);

        Button dealHandButton = new Button("Deal hand");
        dealHandButton.setOnAction((ActionEvent event) -> {
            this.controller.DealHand();
        });
        rightContainer.getChildren().add(dealHandButton);

        
        Button checkHandButton = new Button("Check hand");
        checkHandButton.setOnAction((ActionEvent event) -> {
            // controller.drawCard();
        });
        rightContainer.getChildren().add(checkHandButton);






        Label CardExample = new Label("c1");
        this.centerContainer.getChildren().add(CardExample);
        this.centerContainer.setSpacing(10);

        
        Scene scene = new Scene(rootNode, 500, 500);
        stage.setScene(scene);
        stage.setTitle("MVC exmaple");
        stage.show();
    }

    public void SetHand(Collection<PlayingCard> hand){
        this.centerContainer.getChildren().clear();
        for (PlayingCard card : hand) {
            Label cardLabel = new Label(card.getAsString());
            this.centerContainer.getChildren().add(cardLabel);
        }
    }

    public static void appMain(String[] args) {
        launch(args);
    }

}