package pong.javafxpong.controller;

import javafx.application.Platform;
import javafx.scene.Scene;
import pong.javafxpong.model.Pong;
import pong.javafxpong.model.entity.CollisionDetector;
import pong.javafxpong.view.GameOverView;
import pong.javafxpong.view.GameView;

import java.sql.SQLException;

public class GameController {
    private GameView gameView;
    private Pong pong;
    private boolean gameStarted = false;
    private boolean isPaused;

    public GameController() {
        this.gameView = null;
        this.pong = null;
    }

    public void setGameController(GameView gameView, Pong pong) {
        this.gameView = gameView;
        this.pong = pong;
    }


    public void startGame() {
        gameStarted = true;
        System.out.println("Game started");
        Thread thread = new Thread(() -> {
            System.out.println("Game thread started");
            while (true) {
                if (Thread.interrupted()) {
                    return;
                }
                gameView.update();
                if (gameStarted) {
                    update();

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }

    public void update() {
        pong.update();
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
            displayMessage( pong.getPlayer2().getName() + " scores!");
        } else if (pong.getBall().getX() >= 1000) {
            pong.scorePlayer1();
            pong.reset();
            checkEndGame();
            displayMessage( pong.getPlayer1().getName() + " scores!");
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

    public void pauseGame() {
        if (!gameStarted){
            pong.play();
            gameStarted = true;
            gameView.displayMessage("Game resumed");
            return;
        }
        // Stop the game loop
        gameStarted = false;
        // Stop the ball and rackets
        assert pong != null;
        pong.stopGame();
        gameView.displayMessage("Game paused");
    }

    public void saveGame() {
        GameSerializer.getInstance().saveGame(pong);
        pauseGame();
    }

    public void saveGameToDatabase() throws SQLException {
        DataBaseAdapter dataBaseAdapter = new DataBaseAdapter(pong);
        dataBaseAdapter.saveGame();
        pauseGame();
    }
}
