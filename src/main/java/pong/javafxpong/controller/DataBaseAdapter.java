package pong.javafxpong.controller;

import pong.javafxpong.model.Pong;

import java.sql.SQLException;

public class DataBaseAdapter {
    private DatabaseConnection databaseConnection;
    private final Pong pong;

    public DataBaseAdapter(Pong pong) throws SQLException {
        this.databaseConnection = null;
        this.pong = pong;
        setDatabaseConnection(DatabaseConnection.getInstance());
    }

    public void setDatabaseConnection(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public void saveGame() {
        // TODO: Implement saveGame method
        String name = "Game0";
        String player1name = pong.getPlayer1().getName();
        String player2name = pong.getPlayer2().getName();
        int player1score = pong.getScores()[0];
        int player2score = pong.getScores()[1];
        int scoreToWin = pong.getOptions().scoreToWin;
        String query = "INSERT INTO pong (Name, Player1Name, Player2Name, Player1Score, Player2Score, target) VALUES ('" + name + "', '" + player1name + "', '" + player2name + "', " + player1score + ", " + player2score + ", " + scoreToWin + ")";

        try {
            databaseConnection.getConnection().createStatement().executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
