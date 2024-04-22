package pong.javafxpong.model.Entity;

import javafx.scene.input.KeyCode;
import pong.javafxpong.model.Side;

public class Player extends Entity {
    private Racket racket;
    private int score;
    private String name;
    private final Side side;
    private volatile boolean running = true;
    private RacketMovementHandler racketMovementHandler;

    public Player(Racket racket, String name, Side side) {
        this.racket = racket;
        this.name = name;
        this.score = 0;
        this.side = side;
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
            racketMovementHandler = new RacketMovementHandler(KeyCode.UP, KeyCode.DOWN);
        }
    }

    @Override
    void start() {
        running = true;
    }

    @Override
    void update() {
        if (running) {
            int direction = racketMovementHandler.update();
            if (direction == -1) {
                racket.moveUp();
            } else if (direction == 1) {
                racket.moveDown();
            }
        }
    }

    @Override
    void stop() {
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
}
