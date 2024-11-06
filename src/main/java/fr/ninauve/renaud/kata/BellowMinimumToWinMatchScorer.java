package fr.ninauve.renaud.kata;

import static fr.ninauve.renaud.kata.Match.MINIMUM_TO_WIN;

public class BellowMinimumToWinMatchScorer implements MatchScorer {
    private static final String[] POINTS = new String[]{"0", "15", "30", "40"};
    private static final String EQUALITY_BELLOW_WINNING = "%s - all";
    private static final String BASIC_SCORE = "%s - %s";

    @Override
    public String score(int serverPoints, int receiverPoints) {
        if (serverPoints == receiverPoints) {
            return equalityScore(serverPoints);
        }
        return basicScore(serverPoints, receiverPoints);
    }

    private String equalityScore(int serverPoints) {
        if (serverPoints >= MINIMUM_TO_WIN - 1) {
            return AboveMinimumToWinMatchScorer.EQUALITY;
        }
        final String serverScore = POINTS[serverPoints];
        return String.format(EQUALITY_BELLOW_WINNING, serverScore);
    }

    private String basicScore(int serverPoints, int receiverPoints) {
        final String serverScore = POINTS[serverPoints];
        final String receiverScore = POINTS[receiverPoints];
        return String.format(BASIC_SCORE, serverScore, receiverScore);
    }
}
