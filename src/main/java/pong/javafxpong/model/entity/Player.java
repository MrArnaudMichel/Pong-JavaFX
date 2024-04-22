package pong.javafxpong.model.entity;

import javafx.scene.input.KeyCode;
import pong.javafxpong.model.Side;

public class Player extends Entity implements Runnable {
    private Racket racket;
    private int score;
    private String name;
    private final Side side;
    private volatile boolean running = true;
    private RacketMovementHandler racketMovementHandler;
    private Thread thread;

    public Player(Racket racket, String name, Side side) {
        super(racket.getX(), racket.getY(), racket.getWidth(), racket.getHeight());
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
        thread = new Thread(this);
    }

    @Override
    public void start() {
        running = true;
        thread.start();
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

    @Override
    public void run() {
        while (running) {
            update();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
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
