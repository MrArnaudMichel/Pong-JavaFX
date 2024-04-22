package pong.javafxpong.model.Entity;

import pong.javafxpong.model.Resizable;

abstract class Entity implements Resizable {
    private double x;
    private double y;

    abstract void awake();
    abstract void start();
    abstract void update();
    abstract void stop();

    abstract void reset(double x, double y);
}
