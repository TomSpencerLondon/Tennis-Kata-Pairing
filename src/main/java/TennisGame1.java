
public class TennisGame1 implements TennisGame {

  private int player1Score = 0;
  private int player2Score = 0;

  public void wonPoint(String playerName) {
    if (playerName.equals("player1"))
      player1Score += 1;
    else
      player2Score += 1;
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
    switch (score) {
      case 0:
        return "Love";
      case 1:
        return "Fifteen";
      case 2:
        return "Thirty";
      case 3:
        return "Forty";
      default:
        throw new UnsupportedOperationException();
    }
  }

  private String winOrWinning() {
    String score;
    int minusResult = player1Score - player2Score;
    if (minusResult == 1) score = "Advantage player1";
    else if (minusResult == -1) score = "Advantage player2";
    else if (minusResult >= 2) score = "Win for player1";
    else score = "Win for player2";
    return score;
  }

  private String draw() {
    String score;
    switch (player1Score) {
      case 0:
        score = "Love-All";
        break;
      case 1:
        score = "Fifteen-All";
        break;
      case 2:
        score = "Thirty-All";
        break;
      default:
        score = "Deuce";
        break;

    }
    return score;
  }
}
