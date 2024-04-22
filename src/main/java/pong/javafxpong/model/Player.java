package pong.javafxpong.model;

public class Player extends Entity {
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
