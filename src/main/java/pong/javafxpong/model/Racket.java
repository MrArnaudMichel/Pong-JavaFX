package pong.javafxpong.model;

import javafx.scene.paint.Color;

public class Racket implements Resizable {
    private double x;
    private double y;
    private double baseWidth;
    private double baseHeight;
    private double width;
    private double height;
    private int speed;
    private final Color color;

    public Racket(double x, double y, double width, double height, int speed, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.color = color;
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
