package pong.javafxpong.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import pong.javafxpong.controller.MainController;
import pong.javafxpong.model.Pong;
import pong.javafxpong.view.layout.Settings;

public class MainView extends StackPane {
    private final Pong pong;
    private final Settings settings;
    private final MainController mainController;

    public MainView(Pong pong) {
        super();
        this.pong = pong;
        this.mainController = new MainController(this, pong);
        settings = new Settings(pong);
        this.draw();
    }

    private void draw() {
        BorderPane borderPane = new BorderPane();

        Label mainTitle = new Label("Pong");
        mainTitle.setId("main-title");
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
        startButton.setOnAction(e -> {
            mainController.startGame();
        });
        vBox.getChildren().add(startButton);

        borderPane.setBottom(vBox);


        this.getChildren().add(borderPane);
    }
}
