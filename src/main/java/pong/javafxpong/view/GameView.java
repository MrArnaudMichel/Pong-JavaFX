package pong.javafxpong.view;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import pong.javafxpong.controller.GameController;
import pong.javafxpong.model.Pong;
import pong.javafxpong.model.entity.Ball;
import pong.javafxpong.model.entity.Racket;
import pong.javafxpong.view.components.BallView;
import pong.javafxpong.view.components.RacketView;

public class GameView extends BorderPane {
    private final Pong pong;
    private GameController gameController;
    private final RacketView racketView1;
    private final RacketView racketView2;
    private final BallView ballView;


    public GameView(Pong pong) {
        super();
        this.pong = pong;
        gameController = new GameController(this, pong);
        racketView1 = new RacketView(pong.getPlayer1().getRacket());
        racketView2 = new RacketView(pong.getPlayer2().getRacket());
        ballView = new BallView(pong.getBall());
        this.getChildren().addAll(racketView1, racketView2, ballView);

        gameController.startGame();

    }

    public void update() {
        racketView1.updatePosition();
        racketView2.updatePosition();
        ballView.updatePosition();
    }
}