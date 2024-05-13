package pong.javafxpong.controller;

import pong.javafxpong.model.Pong;

import java.io.*;

public class GameSerializer {
    private static GameSerializer instance;

    private GameSerializer() {}

    public static GameSerializer getInstance() {
        // Singleton pattern
        if (instance == null) {
            instance = new GameSerializer();
        }
        return instance;
    }

    public void saveGame(Pong pong) {
        try (FileOutputStream fileOut = new FileOutputStream("savedGame.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(pong);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public Pong loadGame() throws IOException, ClassNotFoundException {
        Pong pong;
        try (FileInputStream fileIn = new FileInputStream("savedGame.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            pong = (Pong) in.readObject();
        }
        return pong;
    }
}