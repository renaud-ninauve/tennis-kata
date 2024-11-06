package fr.ninauve.renaud.kata;

// https://codingdojo.org/fr/kata/Tennis/
public class Match {
    private static final int MINIMUM_TO_WIN = 4;
    private static final int DIFFERENCE_TO_WIN = 2;
    private static final String[] POINTS = new String[]{"0", "15", "30", "40"};
    private static final String EQUALITY_BELLOW_WINNING = "%s - all";
    private static final String EQUALITY_ABOVE_WINNING = "deuce";
    private static final String BASIC_SCORE = "%s - %s";
    private static final String SERVER_WINS = "server wins";
    private static final String RECEIVER_WINS = "receiver wins";
    private static final String SERVER_ADVANTAGE = "advantage in";
    private static final String RECEIVER_ADVANTAGE = "advantage out";

    public String score(int serverPoints, int receiverPoints) {
        boolean enoughPointsToWin = serverPoints >= MINIMUM_TO_WIN || receiverPoints >= MINIMUM_TO_WIN;
        if (enoughPointsToWin) {
            return enoughPointToWinScore(serverPoints, receiverPoints);
        }
        return notEnoughPointToWin(serverPoints, receiverPoints);
    }

    private String notEnoughPointToWin(int serverPoints, int receiverPoints) {
        if (serverPoints == receiverPoints) {
            return equalityScore(serverPoints);
        }
        return basicScore(serverPoints, receiverPoints);
    }

    private String equalityScore(int serverPoints) {
        if (serverPoints >= MINIMUM_TO_WIN - 1) {
            return EQUALITY_ABOVE_WINNING;
        }
        final String serverScore = POINTS[serverPoints];
        return String.format(EQUALITY_BELLOW_WINNING, serverScore);
    }

    private String basicScore(int serverPoints, int receiverPoints) {
        final String serverScore = POINTS[serverPoints];
        final String receiverScore = POINTS[receiverPoints];
        return String.format(BASIC_SCORE, serverScore, receiverScore);
    }

    private String enoughPointToWinScore(int serverPoints, int receiverPoints) {
        int difference = Math.abs(serverPoints - receiverPoints);
        if (difference >= DIFFERENCE_TO_WIN) {
            return winnerScore(serverPoints, receiverPoints);
        }
        if (serverPoints == receiverPoints) {
            return equalityScore(serverPoints);
        }
        return serverPoints > receiverPoints ? SERVER_ADVANTAGE : RECEIVER_ADVANTAGE;
    }

    private String winnerScore(int serverPoints, int receiverPoints) {
        return serverPoints > receiverPoints ? SERVER_WINS : RECEIVER_WINS;
    }
}