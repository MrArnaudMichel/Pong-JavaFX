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
    public int nbBouncesBeforeSpeedIncrease;
    public int scoreToWin;
    public int width;
    public int height;

    public Options(
            double playerSpeed,
            double playerHeight,
            double playerWidth,
            String player1Name,
            String player2Name,
            double ballSpeed,
            double ballSize,
            double ballSpeedIncrease,
            int nbBouncesBeforeSpeedIncrease,
            int scoreToWin,
            int width,
            int height) {
        this.playerSpeed = playerSpeed;
        this.playerHeight = playerHeight;
        this.playerWidth = playerWidth;
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.ballSpeed = ballSpeed;
        this.ballSize = ballSize;
        this.ballSpeedIncrease = ballSpeedIncrease;
        this.nbBouncesBeforeSpeedIncrease = nbBouncesBeforeSpeedIncrease;
        this.scoreToWin = scoreToWin;
        this.width = width;
        this.height = height;
    }
}
