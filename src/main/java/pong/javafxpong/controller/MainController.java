package pong.javafxpong.controller;

import javafx.scene.Scene;
import pong.javafxpong.model.Pong;
import pong.javafxpong.view.GameView;
import pong.javafxpong.view.MainView;

public class MainController {
    private final MainView mainView;
    private final Pong pong;
    public MainController(MainView mainView, Pong pong) {
        this.mainView = mainView;
        this.pong = pong;
    }

    public void startGame() {
        Scene scene = mainView.getScene();
        scene.setRoot(new GameView(pong));
    }
}
