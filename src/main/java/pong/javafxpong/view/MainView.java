package pong.javafxpong.view;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import org.kordamp.bootstrapfx.scene.layout.Panel;
import pong.javafxpong.controller.MainController;
import pong.javafxpong.model.Pong;

public class MainView extends StackPane {
    private final Pong pong;
    private MainController mainController;

    public MainView(Pong pong) {
        super();
        this.pong = pong;
        this.mainController = new MainController(this, pong);


        this.draw();
    }

    private void draw() {
        BorderPane borderPane = new BorderPane();

        Label mainTitle = new Label("Pong");
        mainTitle.setId("main-title");
        mainTitle.getStyleClass().add("main-title");
        borderPane.setCenter(mainTitle);


        this.getChildren().add(borderPane);
    }
}
