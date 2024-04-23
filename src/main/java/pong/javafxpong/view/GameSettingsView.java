package pong.javafxpong.view;

import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import pong.javafxpong.model.Options;
import pong.javafxpong.model.Pong;
import pong.javafxpong.view.components.RacketView;
import pong.javafxpong.model.entity.Racket;

public class GameSettingsView extends TabPane {
    public GameSettingsView(Pong pong) {
        super();
        Options options = pong.GetOptions();
        this.getStyleClass().add("settings-options");
        this.setPrefSize(200, 500);
        this.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

        // Players tab
        Tab playersTab = new Tab("Players");
        GridPane playersSettings = new GridPane();
        playersSettings.add(new Label("Player 1"), 0, 0);
        playersSettings.add(new Label("Player 2"), 1, 0);
        TextField player1Name = new TextField(options.player1Name);
        TextField player2Name = new TextField(options.player2Name);
        playersSettings.add(player1Name, 0, 1);
        playersSettings.add(player2Name, 1, 1);
        Button saveButton = new Button("Save");
        saveButton.setOnAction(e -> {
            options.player1Name = player1Name.getText();
            options.player2Name = player2Name.getText();
        });
        playersSettings.add(saveButton, 0, 2);
        playersTab.setContent(playersSettings);
        this.getTabs().add(playersTab);

        // Rackets tab
        Tab racketsTab = new Tab("Rackets");
        GridPane racketsSettings = new GridPane();
        RacketView racketView1 = new RacketView(pong.getPlayer1().getRacket());
        RacketView racketView2 = new RacketView(pong.getPlayer2().getRacket());
        racketsSettings.add(racketView1, 0, 3);
        racketsSettings.add(racketView2, 1, 3);


        racketsSettings.add(new Label("Width"), 0, 0);
        racketsSettings.add(new Label("Height"), 1, 0);
        Slider racketWidth = new Slider(1, 100, options.playerWidth);
        Slider racketHeight = new Slider(1, 500, options.playerHeight);

        racketWidth.valueProperty().addListener((obs, oldVal, newVal) -> {
            racketView1.setWidth(newVal.doubleValue());
            racketView2.setWidth(newVal.doubleValue());
        });
        racketHeight.valueProperty().addListener((obs, oldVal, newVal) -> {
            racketView1.setHeight(newVal.doubleValue());
            racketView2.setHeight(newVal.doubleValue());
        });

        racketsSettings.add(racketWidth, 0, 1);
        racketsSettings.add(racketHeight, 1, 1);
        Button saveButton2 = new Button("Save");
        saveButton2.setOnAction(e -> {
            options.playerWidth = racketWidth.getValue();
            options.playerHeight = racketHeight.getValue();
        });
        racketsSettings.add(saveButton2, 0, 2);

        racketsTab.setContent(racketsSettings);
        this.getTabs().add(racketsTab);

        // Ball tab
        Tab ballTab = new Tab("Ball");
        GridPane ballSettings = new GridPane();
        Circle ballView = new Circle(10);
        ballView.setStyle("-fx-fill: white; -fx-stroke: black");
        ballSettings.add(ballView, 0, 5);
        ballSettings.add(new Label("Speed"), 0, 0);
        ballSettings.add(new Label("Increase Speed"), 1, 0);
        Slider ballSpeed = new Slider(1, 10, options.ballSpeed);
        Slider ballIncreaseSpeed = new Slider(0, 1, options.ballSpeedIncrease - 1);

        ballSettings.add(ballSpeed, 0, 1);
        ballSettings.add(ballIncreaseSpeed, 1, 1);
        Button saveButton3 = new Button("Save");
        saveButton3.setOnAction(e -> {
            options.ballSpeed = ballSpeed.getValue();
            options.ballSpeedIncrease = ballIncreaseSpeed.getValue() + 1;
        });

        ballSettings.add(saveButton3, 0, 2);


        ballTab.setContent(ballSettings);
        this.getTabs().add(ballTab);
    }
}