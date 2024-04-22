package pong.javafxpong.model.Entity;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.concurrent.ConcurrentHashMap;

/**
 * The RacketMovementHandler class manages the movement of rackets in the Pong game.
 */
public class RacketMovementHandler {
    private final ConcurrentHashMap<KeyCode, Boolean> keys = new ConcurrentHashMap<>();
    private final KeyCode up;
    private final KeyCode down;

    public RacketMovementHandler(KeyCode up, KeyCode down) {
        this.up = up;
        this.down = down;
        keys.put(up, false);
        keys.put(down, false);
    }


    int update() {
        if (keys.getOrDefault(up, false)) {
            return -1;
        }
        if (keys.getOrDefault(down, false)) {
            return 1;
        }
        return 0;
    }
}
