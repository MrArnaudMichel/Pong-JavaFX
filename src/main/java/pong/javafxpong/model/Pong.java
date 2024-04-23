package pong.javafxpong.model;

import javafx.scene.paint.Color;
import pong.javafxpong.model.entity.Ball;
import pong.javafxpong.model.entity.Player;
import pong.javafxpong.model.entity.Racket;

public class Pong {
    private final Ball ball;
    private final Player player1;
    private final Player player2;
    private double width = 1000;
    private double height = 600;
    private final Options options;

    public Pong(int width, int height) {
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
                3,
                width,
                height);
        this.ball = new Ball(width / 2, height / 2, options.ballSpeed, options.ballSpeedIncrease, options.nbBouncesBeforeSpeedIncrease);
        Racket racket1 = new Racket(50, height / 2, options.playerWidth, options.playerHeight, options.playerSpeed, Color.AQUAMARINE);
        Racket racket2 = new Racket(width - 50, height / 2, options.playerWidth, options.playerHeight, options.playerSpeed, Color.CHARTREUSE);
        this.player1 = new Player(racket1, options.player1Name, Side.LEFT);
        this.player2 = new Player(racket2, options.player2Name, Side.RIGHT);
        this.width = width;
        this.height = height;
        reset();
    }

    public void reset() {
        ball.reset(width / 2, height / 2);
        player1.getRacket().reset(50, height / 2);
        player2.getRacket().reset(width - 50, height / 2);
    }

    public Options GetOptions() {
        return options;
    }

    public Ball getBall() {
        return ball;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void startGame() {
        updateComponents();
        ball.start();
        player1.start();
        player2.start();
    }

    private void updateComponents() {
        ball.setSpeed(options.ballSpeed);
        ball.setIncreaseSpeed(options.ballSpeedIncrease);
        ball.setNbBouncesBeforeSpeedIncrease(options.nbBouncesBeforeSpeedIncrease);
        player1.getRacket().setWidth(options.playerWidth);
        player1.getRacket().setHeight(options.playerHeight);
        player1.getRacket().setSpeed(options.playerSpeed);
        player2.getRacket().setWidth(options.playerWidth);
        player2.getRacket().setHeight(options.playerHeight);
        player2.getRacket().setSpeed(options.playerSpeed);
    }

    public void stopGame() {
        ball.stop();
        player1.stop();
        player2.stop();
    }


}
