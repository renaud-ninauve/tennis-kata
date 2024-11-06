package fr.ninauve.renaud.kata;

// https://codingdojo.org/fr/kata/Tennis/
public class Match {
    private static final String[] POINTS = new String[]{"0", "15", "30", "40"};
    private static final String EQUALITY_LT_3 = "%s - all";
    private static final String EQUALITY_GE_3 = "deuce";
    private static final String BASIC_SCORE = "%s - %s";

    public String score(int serverPoints, int receiverPoints) {
        if (serverPoints == 3 && receiverPoints == 3) {
            return EQUALITY_GE_3;
        }
        if (serverPoints == receiverPoints) {
            final String serverScore = POINTS[serverPoints];
            return String.format(EQUALITY_LT_3, serverScore);
        }
        final String serverScore = POINTS[serverPoints];
        final String receiverScore = POINTS[receiverPoints];
        return String.format(BASIC_SCORE, serverScore, receiverScore);
    }
}