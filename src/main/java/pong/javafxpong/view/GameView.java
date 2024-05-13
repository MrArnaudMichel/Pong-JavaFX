package pong.javafxpong.view;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import pong.javafxpong.controller.GameController;
import pong.javafxpong.model.Pong;
import pong.javafxpong.view.components.BallView;
import pong.javafxpong.view.components.RacketView;

import java.sql.SQLException;

public class GameView extends BorderPane {
    private final Pong pong;
    private final RacketView racketView1;
    private final RacketView racketView2;
    private final BallView ballView;
    private final GameController gameController;
    private final StackPane stackPane;
    private Label score;

    public GameView(Pong pong) {
        super();
        this.pong = pong;
        gameController = pong.getGameController();
        gameController.setGameController(this, pong);
        racketView1 = new RacketView(pong.getPlayer1().getRacket());
        racketView2 = new RacketView(pong.getPlayer2().getRacket());
        ballView = new BallView(pong.getBall());
        this.getChildren().addAll(racketView1, racketView2, ballView);
        stackPane = new StackPane();
        score = new Label("0 - 0");
        score.setAlignment(Pos.CENTER);
        score.setStyle("-fx-font-size: 50px; -fx-text-fill: white; -fx-font-weight: bold;");

        Button saveButton = new Button("Save Game [Serializable]");
        saveButton.setOnAction(e -> {
            gameController.saveGame();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Game Saved");
            alert.setHeaderText(null);
            alert.setContentText("Your game has been saved!");
            alert.showAndWait();
        });

        Button saveButton2 = getButton();

        VBox vBox = new VBox();
        vBox.getChildren().addAll(score, saveButton, saveButton2);
        vBox.setAlignment(Pos.CENTER);
        this.setCenter(stackPane);
        this.setBottom(vBox);
        gameController.startGame();

    }

    private Button getButton() {
        Button saveButton2 = new Button("Save Game [Database]");
        saveButton2.setOnAction(e -> {
            try {
                gameController.saveGameToDatabase();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Game Saved");
            alert.setHeaderText(null);
            alert.setContentText("Your game has been saved!");
            alert.showAndWait();
        });
        return saveButton2;
    }

    public void update() {
        racketView1.updatePosition();
        racketView2.updatePosition();
        ballView.updatePosition();
    }

    public void displayMessage(String s) {
        Label label = new Label(s);
        label.setStyle("-fx-font-size: 50px; -fx-text-fill: white; -fx-font-weight: bold;");
        stackPane.getChildren().add(label);
        StackPane.setAlignment(label, Pos.TOP_CENTER);
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1.5), e -> {
            stackPane.getChildren().remove(label);
        }));
        timeline.play();
        score.setText(pong.getPlayer1().getScore() + " - " + pong.getPlayer2().getScore());
    }
}
