
public class TennisGame1 implements TennisGame {

  private int player1Score = 0;
  private int player2Score = 0;

  public void wonPoint(String playerName) {
    if (playerName.equals("player1"))
      player1Score++;
    else
      player2Score++;
  }

  public String getScore() {
    if (player1Score == player2Score) {
      return draw();
    }

    if (player1Score >= 4 || player2Score >= 4) {
      return winOrWinning();
    }

    return playerScore(player1Score) + "-" + playerScore(player2Score);
  }

  private String playerScore(int score) {
    return Score.values()[score].tennisScore;
  }

  private String winOrWinning() {
    int scoreDiff = player1Score - player2Score;
    if (scoreDiff == 1) {
      return "Advantage player1";
    } else if (scoreDiff == -1) {
      return "Advantage player2";
    } else if (scoreDiff >= 2) {
      return "Win for player1";
    }
    return "Win for player2";
  }

  private String draw() {
    switch (player1Score) {
      case 0:
        return "Love-All";
      case 1:
        return "Fifteen-All";
      case 2:
        return "Thirty-All";
      default:
        return "Deuce";
    }
  }

  private enum Score{
    ZERO(0, "Love"),
    ONE(1, "Fifteen"),
    TWO(2, "Thirty"),
    THREE(3, "Forty");


    private final int score;
    private final String tennisScore;

    Score(int score, String tennisScore) {
      this.score = score;
      this.tennisScore = tennisScore;
    }
  }
}
