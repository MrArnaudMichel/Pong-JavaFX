package pong.javafxpong.controller;

import pong.javafxpong.model.Pong;
import pong.javafxpong.view.GameView;

public class GameController {
    private final GameView gameView;
    private final Pong pong;

    public GameController(GameView gameView, Pong pong) {
        this.gameView = gameView;
        this.pong = pong;
    }

    public void startGame() {
        pong.startGame();
    }
}
