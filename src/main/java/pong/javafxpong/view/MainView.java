package pong.javafxpong.view;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import pong.javafxpong.controller.MainController;
import pong.javafxpong.model.Pong;

public class MainView extends StackPane {
    private final Pong pong;
    private MainController mainController;

    public MainView(Pong pong) {
        super();
        this.pong = pong;
        this.mainController = new MainController(this, pong);
    }
}
