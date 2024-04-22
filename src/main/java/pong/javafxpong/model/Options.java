package pong.javafxpong.model;

public class Options {
    public double playerSpeed;
    public double playerHeight;
    public double playerWidth;
    public String player1Name;
    public String player2Name;
    public double ballSpeed;
    public double ballSize;
    public double ballSpeedIncrease;
    public int scoreToWin;

    public Options(double playerSpeed, double playerHeight, double playerWidth, String player1Name, String player2Name, double ballSpeed, double ballSize, double ballSpeedIncrease, int scoreToWin) {
        this.playerSpeed = playerSpeed;
        this.playerHeight = playerHeight;
        this.playerWidth = playerWidth;
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.ballSpeed = ballSpeed;
        this.ballSize = ballSize;
        this.ballSpeedIncrease = ballSpeedIncrease;
        this.scoreToWin = scoreToWin;
    }
}
