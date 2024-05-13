package pong.javafxpong.view;

import pong.javafxpong.controller.GameSerializer;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import pong.javafxpong.controller.MainController;
import pong.javafxpong.model.Pong;
import pong.javafxpong.view.layout.Settings;

import java.io.IOException;

public class MainView extends StackPane {
    private Pong pong;
    private final Settings settings;
    private final MainController mainController;
    private final Button loadButton;

    public MainView(Pong pong) {
        super();
        this.pong = pong;
        this.mainController = new MainController(this, pong);
        settings = new Settings(pong);

        loadButton = new Button("Load Game");
        loadButton.setOnAction(e -> {
            try {
                this.pong = GameSerializer.getInstance().loadGame();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Game Loaded");
                alert.setHeaderText(null);
                alert.setContentText("Your game has been loaded!");
                alert.showAndWait();
            } catch (IOException | ClassNotFoundException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Failed to load the game!");
                alert.showAndWait();
            }
        });

        this.draw();
    }

    private void draw() {
        BorderPane borderPane = new BorderPane();

        Label mainTitle = new Label("Pong");
        mainTitle.setId("main-title");
        mainTitle.getStyleClass().add("label");
        mainTitle.getStyleClass().add("main-title");
        borderPane.setCenter(mainTitle);

        VBox vBox = new VBox();
        vBox.setAlignment(javafx.geometry.Pos.CENTER);
        vBox.setSpacing(10);
        Button optionButton = new Button("Options");
        optionButton.setOnAction(e -> {
            Scene scene = this.getScene();
            scene.setRoot(settings);
        });
        vBox.getChildren().add(optionButton);


        Button startButton = new Button("Start");
        startButton.getStyleClass().add("button-start");
        startButton.setOnAction(e -> {
            mainController.startGame();
        });
        vBox.getChildren().add(startButton);

        vBox.getChildren().add(loadButton);

        borderPane.setBottom(vBox);


        this.getChildren().add(borderPane);
    }

    public MainController getMainController() {
        return mainController;
    }
}
