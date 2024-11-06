package fr.ninauve.renaud.kata;

public class AboveMinimumToWinMatchScorer implements MatchScorer {
    public static final String EQUALITY = "deuce";

    private static final int DIFFERENCE_TO_WIN = 2;
    private static final String SERVER_WINS = "server wins";
    private static final String RECEIVER_WINS = "receiver wins";
    private static final String SERVER_ADVANTAGE = "advantage in";
    private static final String RECEIVER_ADVANTAGE = "advantage out";

    @Override
    public String score(int serverPoints, int receiverPoints) {
        int difference = Math.abs(serverPoints - receiverPoints);
        if (difference >= DIFFERENCE_TO_WIN) {
            return winner(serverPoints, receiverPoints);
        }
        if (serverPoints == receiverPoints) {
            return EQUALITY;
        }
        return serverPoints > receiverPoints ? SERVER_ADVANTAGE : RECEIVER_ADVANTAGE;
    }

    private String winner(int serverPoints, int receiverPoints) {
        return serverPoints > receiverPoints ? SERVER_WINS : RECEIVER_WINS;
    }
}
