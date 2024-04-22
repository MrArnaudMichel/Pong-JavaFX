package pong.javafxpong;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pong.javafxpong.model.*;
import pong.javafxpong.view.*;

import java.io.IOException;
import java.util.Objects;

public class PongApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Pong pong = new Pong(1000, 600);
        MainView mainView = new MainView(pong);
        Scene scene = new Scene(mainView, 1000, 600);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/pong/javafxpong/style.css")).toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Pong");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}