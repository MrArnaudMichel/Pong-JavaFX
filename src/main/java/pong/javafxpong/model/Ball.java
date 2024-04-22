package pong.javafxpong.model;

public class Ball extends Entity implements Runnable  {
    private double x;
    private double y;
    private double speed;
    private double baseSpeed;
    private double directionX;
    private double directionY;
    private double increaseSpeed;
    private int nbBouncesBeforeSpeedIncrease;
    private int nbBounces;
    private Thread thread;
    private volatile boolean running = false;

    public Ball(double x, double y, double speed, double directionX, double directionY, double increaseSpeed, int nbBouncesBeforeSpeedIncrease) {
        this.x = x;
        this.y = y;
        this.baseSpeed = speed;
        this.speed = speed;
        this.directionX = directionX;
        this.directionY = directionY;
        this.increaseSpeed = increaseSpeed;
        this.nbBouncesBeforeSpeedIncrease = nbBouncesBeforeSpeedIncrease;
        this.nbBounces = 0;
        awake();
    }

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            x += speed * directionX;
            y += speed * directionY;

            if (y <= 0 || y >= 600) {
                directionY *= -1;
            }
        }
    }

    @Override
    void awake() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    void start() {
        running = true;
    }

    @Override
    void update() {
        // Increase speed after a certain number of bounces
        if (nbBounces >= nbBouncesBeforeSpeedIncrease) {
            speed += increaseSpeed;
            nbBounces = 0;
        }
        // Move the ball
        x += speed * directionX;
        y += speed * directionY;
    }

    @Override
    void stop() {
        running = false;
    }

    @Override
    void reset(double x, double y) {
        this.x = x;
        this.y = y;
        speed = baseSpeed;
        directionX = Math.random() < 0.5 ? -1 : 1;
        directionY = Math.random() < 0.5 ? -1 : 1;
    }


    @Override
    public void resizeWidth(double factor) {
        this.x *= factor;
    }

    @Override
    public void resizeHeight(double factor) {
        this.y *= factor;
    }
}
