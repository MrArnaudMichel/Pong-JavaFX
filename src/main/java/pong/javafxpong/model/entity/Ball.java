package pong.javafxpong.model.entity;

import javafx.scene.paint.Paint;

public class Ball extends Entity implements Runnable {
    private double speed;
    private double baseSpeed;
    private double directionX;
    private double directionY;
    private double increaseSpeed;
    private int nbBouncesBeforeSpeedIncrease;
    private int nbBounces;
    private Thread thread;
    private volatile boolean running = false;

    public Ball(double x, double y, double speed, double increaseSpeed, int nbBouncesBeforeSpeedIncrease) {
        super(x, y, 10, 10);
        this.baseSpeed = speed;
        this.speed = speed;
        this.increaseSpeed = increaseSpeed;
        this.nbBouncesBeforeSpeedIncrease = nbBouncesBeforeSpeedIncrease;
        this.nbBounces = 0;
        thread = new Thread(this);
        awake();
    }

    @Override
    public void run() {
        while (true) {
            if (running) {
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
    }

    @Override
    void awake() {
        directionX = Math.random() < 0.5 ? -1 : 1;
        directionY = Math.random() < 0.5 ? -1 : 1;
        reset(x, y);
    }

    @Override
    public void start() {
        thread.start();
        running = true;
    }

    @Override
    public void update() {

        // Move the ball
        x += speed * directionX;
        y += speed * directionY;
    }

    public void bounce() {
        nbBounces++;
        // Increase speed after a certain number of bounces
        if (nbBounces >= nbBouncesBeforeSpeedIncrease) {
            speed += increaseSpeed;
        }
    }

    @Override
    public void stop() {
        running = false;
    }

    public void play() {
        running = true;
    }

    @Override
    public void reset(double x, double y) {
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

    public Paint getColor() {
        return Paint.valueOf("#FFFFFF");
    }

    public double getWidth() {
        return 10;
    }

    public double getHeight() {
        return 10;
    }

    public double getDirectionY() {
        return directionY;
    }

    public void setDirectionY(double directionY) {
        this.directionY = directionY;
    }

    public double getDirectionX() {
        return directionX;
    }

    public void setDirectionX(double directionX) {
        this.directionX = directionX;
    }

    public void setSpeed(double speed) {
        this.baseSpeed = speed;
        this.speed = speed;
    }

    public void setIncreaseSpeed(double increaseSpeed) {
        this.increaseSpeed = increaseSpeed;
    }

    public void setNbBouncesBeforeSpeedIncrease(int nbBouncesBeforeSpeedIncrease) {
        this.nbBouncesBeforeSpeedIncrease = nbBouncesBeforeSpeedIncrease;
    }
}
