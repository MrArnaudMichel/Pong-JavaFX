package pong.javafxpong.model.Entity;

import javafx.scene.paint.Color;
import pong.javafxpong.model.Resizable;

public class Racket implements Resizable {
    private double baseX;
    private double baseY;
    private double x;
    private double y;
    private double baseWidth;
    private double baseHeight;
    private double width;
    private double height;
    private int speed;
    private final Color color;
    private double factor = 1.0;

    public Racket(double x, double y, double width, double height, int speed, Color color) {
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
        this.x = this.baseX * factor;
        this.y = this.baseY * factor;
    }

    public void moveUp() {
        this.y -= this.speed;
    }

    public void moveDown() {
        this.y += this.speed;
    }

    @Override
    public void resizeWidth(double factor) {
        this.width = this.baseWidth * factor;
        this.x = this.x * factor;
    }

    @Override
    public void resizeHeight(double factor) {
        this.height = this.baseHeight * factor;
        this.y = this.y * factor;
    }
}
