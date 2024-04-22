package pong.javafxpong.model;

import javafx.scene.paint.Color;
import pong.javafxpong.model.entity.Ball;
import pong.javafxpong.model.entity.Player;
import pong.javafxpong.model.entity.Racket;

public class Pong {
    private Ball ball;
    private Player player1;
    private Player player2;
    private double width = 1000;
    private double height = 600;
    private Options options;

    public Pong() {
        this.options = new Options(
                5,
                50,
                10,
                "Player 1",
                "Player 2",
                5,
                10,
                1,
                3,
                3);
        this.ball = new Ball(width / 2, height / 2, options.ballSpeed, options.ballSpeedIncrease, options.nbBouncesBeforeSpeedIncrease);
        Racket racket1 = new Racket(50, height / 2, options.playerWidth, options.playerHeight, options.playerSpeed, Color.AQUAMARINE);
        Racket racket2 = new Racket(width - 50, height / 2, options.playerWidth, options.playerHeight, options.playerSpeed, Color.CHARTREUSE);
        this.player1 = new Player(racket1, options.player1Name, Side.LEFT);
        this.player2 = new Player(racket2, options.player2Name, Side.RIGHT);
        reset();
    }

    public void reset() {
        ball.reset(width / 2, height / 2);
        player1.getRacket().reset(50, height / 2);
        player2.getRacket().reset(width - 50, height / 2);
    }
}
