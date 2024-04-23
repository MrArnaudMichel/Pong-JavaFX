package pong.javafxpong.view.layout;

import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class AboutView extends VBox {

    public AboutView() {
        super();
        initUI();
    }

    private void initUI() {
        Label nameLabel = new Label("Pong");
        nameLabel.getStyleClass().add("about-title");
        Label githubLabel = new Label("GitHub Repository");
        Hyperlink githubLink = new Hyperlink("https://github.com/MrArnaudMichel/Pong-JavaFX");
        githubLink.setOnAction(e -> {

        });
        this.alignmentProperty().set(javafx.geometry.Pos.CENTER);
        this.getChildren().addAll(nameLabel, githubLabel, githubLink);
    }

    public void show() {
        this.setVisible(true);
    }

    public void hide() {
        this.setVisible(false);
    }
}