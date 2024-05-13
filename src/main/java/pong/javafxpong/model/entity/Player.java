package pong.javafxpong.model.entity;

import javafx.scene.control.skin.TableHeaderRow;
import javafx.scene.input.KeyCode;
import pong.javafxpong.model.Side;

public class Player extends Entity {
    private final Side side;
    public RacketMovementHandler racketMovementHandler;
    private Racket racket;
    private int score;
    private String name;
    public volatile boolean running = true;

    public Player(Racket racket, String name, Side side) {
        super(racket.getX(), racket.getY(), racket.getWidth(), racket.getHeight());
        this.racket = racket;
        this.name = name;
        this.score = 0;
        this.side = side;

        awake();
    }

    @Override
    public void resizeWidth(double factor) {
        this.racket.resizeWidth(factor);
    }

    @Override
    public void resizeHeight(double factor) {
        this.racket.resizeHeight(factor);
    }

    @Override
    void awake() {
        if (side == Side.LEFT) {
            racketMovementHandler = new RacketMovementHandler(KeyCode.Z, KeyCode.S);
        } else {
            racketMovementHandler = new RacketMovementHandler(KeyCode.O, KeyCode.L);
        }
        start();
    }

    @Override
    public void start() {
        running = true;
    }

    @Override
    public void update() {
        int direction = racketMovementHandler.update();
        if (direction == -1) {
            racket.moveUp();
        } else if (direction == 1) {
            racket.moveDown();
        }

    }

    @Override
    public void stop() {
        running = false;
    }

    @Override
    void reset(double x, double y) {
        this.racket.reset(x, y);
    }

    public Racket getRacket() {
        return racket;
    }

    public void setRacket(Racket racket) {
        this.racket = racket;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Side getSide() {
        return side;
    }

    @Override
    public double getX() {
        return racket.getX();
    }

    @Override
    public double getY() {
        return racket.getY();
    }

    @Override
    public double getWidth() {
        return racket.getWidth();
    }

    @Override
    public double getHeight() {
        return racket.getHeight();
    }
}
