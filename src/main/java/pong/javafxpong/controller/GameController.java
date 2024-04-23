package pong.javafxpong.controller;

import javafx.application.Platform;
import javafx.scene.Scene;
import pong.javafxpong.model.Pong;
import pong.javafxpong.model.entity.CollisionDetector;
import pong.javafxpong.view.GameOverView;
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
        gameStarted = true;
        Thread thread = new Thread(() -> {
            while (gameStarted) {
                update();
                gameView.update();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
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
            pong.scorePlayer2();
            pong.reset();
            checkEndGame();
            displayMessage("Player 2 scores!");
        } else if (pong.getBall().getX() >= 1000) {
            pong.scorePlayer1();
            pong.reset();
            checkEndGame();
            displayMessage("Player 1 scores!");
        }
    }

    public void displayMessage(String s) {
        Platform.runLater(() -> gameView.displayMessage(s));
    }


    private void checkEndGame() {
        if (pong.getScores()[0] >= pong.getOptions().scoreToWin) {
            Scene scene = gameView.getScene();
            Platform.runLater(() -> {
                gameStarted = false;
                pong.stopGame();
                scene.setRoot(new GameOverView(pong));
            });
        } else if (pong.getScores()[1] >= pong.getOptions().scoreToWin) {
            Scene scene = gameView.getScene();
            Platform.runLater(() -> {
                gameStarted = false;
                pong.stopGame();
                scene.setRoot(new GameOverView(pong));
            });
        }
    }
}
