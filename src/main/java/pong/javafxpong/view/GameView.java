package pong.javafxpong.view;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import pong.javafxpong.controller.GameController;
import pong.javafxpong.model.Pong;
import pong.javafxpong.view.components.BallView;
import pong.javafxpong.view.components.RacketView;

public class GameView extends BorderPane {
    private final Pong pong;
    private final RacketView racketView1;
    private final RacketView racketView2;
    private final BallView ballView;
    private final GameController gameController;
    private final StackPane stackPane;

    public GameView(Pong pong) {
        super();
        this.pong = pong;
        gameController = new GameController(this, pong);
        racketView1 = new RacketView(pong.getPlayer1().getRacket());
        racketView2 = new RacketView(pong.getPlayer2().getRacket());
        ballView = new BallView(pong.getBall());
        this.getChildren().addAll(racketView1, racketView2, ballView);
        stackPane = new StackPane();

        this.setCenter(stackPane);
        gameController.startGame();

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
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), e -> {
            stackPane.getChildren().remove(label);
        }));
        timeline.play();


    }

}
