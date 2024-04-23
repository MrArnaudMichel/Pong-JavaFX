package pong.javafxpong.view;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import pong.javafxpong.model.Pong;

public class GameOverView extends BorderPane {
    public GameOverView(Pong pong) {
        super();

        VBox vBoxTop = new VBox();
        vBoxTop.setAlignment(javafx.geometry.Pos.CENTER);
        Label gameOverLabel = new Label("Game Over");
        gameOverLabel.getStyleClass().add("game-over-label");
        vBoxTop.getChildren().add(gameOverLabel);
        this.setTop(vBoxTop);

        Label winnerLabel = new Label();
        winnerLabel.getStyleClass().add("score-winners");
        if (pong.getWinner() == 0) {
            winnerLabel.setText("Player 1 wins!");
        } else {
            winnerLabel.setText("Player 2 wins!");
        }

        VBox vBox = new VBox();
        vBox.getChildren().add(winnerLabel);

        Label scoreLabel = new Label("Final Score: " + pong.getPlayer1Score() + " - " + pong.getPlayer2Score());
        scoreLabel.getStyleClass().add("score-label");
        vBox.getChildren().add(scoreLabel);
        vBox.setAlignment(javafx.geometry.Pos.CENTER);

        this.setCenter(vBox);


        VBox bottomBox = new VBox();
        bottomBox.setAlignment(javafx.geometry.Pos.CENTER);
        Button startButton = new Button("Start");
        startButton.setOnAction(e -> {
            pong.globalReset();
            Scene scene = this.getScene();
            scene.setRoot(new MainView(pong));
        });
        bottomBox.getChildren().add(startButton);
        this.setBottom(bottomBox);
    }
}
