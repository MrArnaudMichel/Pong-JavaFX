package pong.javafxpong.model.entity;

import javafx.scene.paint.Color;
import pong.javafxpong.model.Resizable;

public class Racket implements Resizable {
    private final Color color;
    private double baseX;
    private double baseY;
    private double x;
    private double y;
    private final double baseWidth;
    private double baseHeight;
    private double width;
    private double height;
    private double speed;
    private double factorX = 1.0;
    private double factorY = 1.0;

    public Racket(double x, double y, double width, double height, double speed, Color color) {
        this.baseX = x;
        this.baseY = y;
        this.baseWidth = width;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.color = color;
    }

    public void reset(double x, double y) {
        this.x = this.baseX * factorX;
        this.y = this.baseY * factorY;
    }

    public void moveUp() {
        this.y -= this.speed;
    }

    public void moveDown() {
        this.y += this.speed;
    }

    @Override
    public void resizeWidth(double factor) {
//        this.width = this.baseWidth * factor;
        this.x = this.x * factor;
        this.baseX = this.baseX * factor;
        this.factorX = factor;
    }

    @Override
    public void resizeHeight(double factor) {
//        this.height = this.baseHeight * factor;
        this.y = this.y * factor;
        this.baseY = this.baseY * factor;
        this.factorY = factor;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Color getColor() {
        return color;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
