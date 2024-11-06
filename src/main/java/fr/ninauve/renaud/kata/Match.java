package fr.ninauve.renaud.kata;

// https://codingdojo.org/fr/kata/Tennis/
public class Match {
    private static final int POINTS_TO_WIN = 4;
    private static final int DIFFERENCE_TO_WIN = 2;
    private static final String[] POINTS = new String[]{"0", "15", "30", "40"};
    private static final String EQUALITY_LT_3 = "%s - all";
    private static final String EQUALITY_GE_3 = "deuce";
    private static final String BASIC_SCORE = "%s - %s";
    private static final String SERVER_WINS = "server wins";
    private static final String RECEIVER_WINS = "receiver wins";

    public String score(int serverPoints, int receiverPoints) {
        int difference = Math.abs(serverPoints - receiverPoints);
        boolean enoughPointsToWin = serverPoints >= POINTS_TO_WIN || receiverPoints >= POINTS_TO_WIN;
        if (enoughPointsToWin && difference >= DIFFERENCE_TO_WIN) {
            return winnerScore(serverPoints, receiverPoints);
        }
        if (serverPoints == receiverPoints) {
            return equalityScore(serverPoints, receiverPoints);
        }
        return basicScore(serverPoints, receiverPoints);
    }

    private String equalityScore(int serverPoints, int receiverPoints) {
        if (serverPoints == 3 && receiverPoints == 3) {
            return EQUALITY_GE_3;
        }
        final String serverScore = POINTS[serverPoints];
        return String.format(EQUALITY_LT_3, serverScore);
    }

    private String basicScore(int serverPoints, int receiverPoints) {
        final String serverScore = POINTS[serverPoints];
        final String receiverScore = POINTS[receiverPoints];
        return String.format(BASIC_SCORE, serverScore, receiverScore);
    }

    private String winnerScore(int serverPoints, int receiverPoints) {
        return serverPoints > receiverPoints ? SERVER_WINS : RECEIVER_WINS;
    }
}