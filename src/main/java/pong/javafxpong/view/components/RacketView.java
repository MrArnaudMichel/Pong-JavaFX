package pong.javafxpong.view.components;

import javafx.scene.shape.Rectangle;
import pong.javafxpong.model.entity.Racket;

public class RacketView extends Rectangle implements ViewComponent {
    private final Racket racket;

    public RacketView(Racket racket) {
        this.racket = racket;
        this.setX(racket.getX());
        this.setY(racket.getY());
        this.setWidth(racket.getWidth());
        this.setHeight(racket.getHeight());
        this.setFill(racket.getColor());
        this.getStyleClass().add("racket");
    }

    public void updatePosition() {
        this.setX(racket.getX());
        this.setY(racket.getY());
        this.setWidth(racket.getWidth());
        this.setHeight(racket.getHeight());
    }
}
