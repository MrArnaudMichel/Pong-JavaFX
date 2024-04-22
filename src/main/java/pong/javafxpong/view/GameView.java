package pong.javafxpong.view;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import pong.javafxpong.model.Pong;
import pong.javafxpong.model.entity.Ball;
import pong.javafxpong.model.entity.Racket;
import pong.javafxpong.view.components.BallView;
import pong.javafxpong.view.components.RacketView;

public class GameView extends BorderPane {
    public GameView(Pong pong) {
        super();
        RacketView racketView1 = new RacketView(pong.getPlayer1().getRacket());
        RacketView racketView2 = new RacketView(pong.getPlayer2().getRacket());
        BallView ballView = new BallView(pong.getBall());
        StackPane stackPane = new StackPane();
        this.getChildren().addAll(racketView1, racketView2, ballView);
//        this.setCenter(stackPane);

    }
}
