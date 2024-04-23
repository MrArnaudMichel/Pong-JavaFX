package pong.javafxpong.controller;

import pong.javafxpong.model.Pong;
import pong.javafxpong.model.entity.CollisionDetector;
import pong.javafxpong.view.GameView;

public class GameController {
    private final GameView gameView;
    private final Pong pong;
    private boolean gameStarted = false;
    private boolean isPaused;

    public GameController(GameView gameView, Pong pong) {
        this.gameView = gameView;
        this.pong = pong;
    }

    public void startGame() {
        pong.startGame();
        gameStarted = true;
        new Thread(() -> {
            while (gameStarted) {
                if (!isPaused) {
                    //pong.update();
                    update();
                    gameView.update();
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void update() {
        if (CollisionDetector.checkCollision(pong.getBall(), pong.getPlayer1().getRacket()) ||
                CollisionDetector.checkCollision(pong.getBall(), pong.getPlayer2().getRacket())) {
            pong.getBall().setDirectionX(-pong.getBall().getDirectionX());
            pong.getBall().bounce();
        }
        if (pong.getBall().getY() <= 0) {
            pong.getBall().setDirectionY(1);
        } else if (pong.getBall().getY() >= 600) {
            pong.getBall().setDirectionY(-1);
        }
        if (pong.getBall().getX() <= 0) {
            pong.getBall().setDirectionX(1);
        } else if (pong.getBall().getX() >= 1000) {
            pong.getBall().setDirectionX(-1);
        }
    }
}
