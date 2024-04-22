package pong.javafxpong.view.components;

import javafx.scene.shape.Circle;
import pong.javafxpong.model.entity.Ball;

public class BallView extends Circle implements ViewComponent {
    private final Ball ball;

    public BallView(Ball ball) {
        super(ball.getX(), ball.getY(), ball.getWidth(), ball.getColor());
        this.ball = ball;
        this.getStyleClass().add("ball");
        System.out.println(this);

    }

    public void updatePosition() {
        this.setCenterX(ball.getX());
        this.setCenterY(ball.getY());
    }
}
