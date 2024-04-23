package pong.javafxpong.model.entity;

import pong.javafxpong.model.Resizable;

public abstract class Entity implements Resizable {
    protected double x;
    protected double y;
    protected double width;
    protected double height;


    Entity(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
    }

    abstract void awake();

    abstract void start();

    abstract void update();

    abstract void stop();

    abstract void reset(double x, double y);

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
