package pong.javafxpong.model;

public class Player extends Entity implements Runnable {
    private Racket racket;
    private int score;
    private String name;
    private final Side side;

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
    public void run() {

    }

    @Override
    void awake() {

    }

    @Override
    void start() {

    }

    @Override
    void update() {

    }

    @Override
    void stop() {

    }

    @Override
    void reset(double x, double y) {

    }
}
