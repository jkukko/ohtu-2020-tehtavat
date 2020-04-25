package ohtu;

public class TennisGame {
    
    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            this.player1Score += 1;
        else
            this.player2Score += 1;
    }

    
    public String whenScoreIsEven() {
        switch (this.player1Score) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            case 3: 
                return "Forty-All";
            default:
                return "Deuce";
        }
    }
    
    public String normalScore(int score) {
        switch(score) {
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                return "Love";
        }
    }
    
    public String advantageScore() {
        int difference = this.player1Score - this.player2Score;
        if (difference == 1) {
            return "Advantage " + this.player1Name;
        } else if (difference == -1) {
            return "Advantage " + this.player2Name;
        } else if (difference >= 2) {
            return "Win for " + this.player1Name;
        } else {
            return "Win for " + this.player2Name;
        }
    }
    
    public String normalSituation() {
        return normalScore(this.player1Score) + "-" + normalScore(this.player2Score);
    }
    
    
    public String getScore() {
        if (this.player1Score == this.player2Score) {
            return whenScoreIsEven();
        } else if (player1Score >= 4 || player2Score >= 4) {
            return advantageScore();
        } else {
            return normalSituation();
        }
    }
}