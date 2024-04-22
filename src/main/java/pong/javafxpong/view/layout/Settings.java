package pong.javafxpong.view.layout;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import pong.javafxpong.model.Pong;
import pong.javafxpong.view.GameSettingsView;
import pong.javafxpong.view.MainView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Settings extends TabPane
{
    ArrayList<Tab> tabs = new ArrayList<>();
    public Settings(Pong pong)
    {
        super();
        this.getStyleClass().add("settings");
        this.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
        this.setPrefSize(200, 500);
        tabs.add(new Tab("Controls"));
        tabs.getFirst().setContent(new GameSettingsView(pong));
        tabs.add(new Tab("About"));
        tabs.get(1).setContent(new AboutView());
        tabs.add(new Tab("Back"));
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            Scene scene = this.getScene();
            scene.setRoot(new MainView(pong));
        });
        tabs.get(2).setContent(backButton);


        this.getTabs().addAll(tabs);


        show();
    }

    public void show()
    {
        this.setVisible(true);
    }

    public void hide()
    {
        this.setVisible(false);
    }

    public void returnToMain()
    {
        this.setVisible(false);
    }
}
