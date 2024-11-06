package fr.ninauve.renaud.kata;

// https://codingdojo.org/fr/kata/Tennis/
public class Match {
    private static final String[] POINTS = new String[]{"0", "15", "30", "40"};
    private static final String EQUALITY_LT_3 = "%s - all";
    private static final String EQUALITY_GE_3 = "deuce";

    public String score(int serverPoints, int receiverPoints) {
        if (serverPoints == 3 && receiverPoints == 3) {
            return EQUALITY_GE_3;
        }
        if (serverPoints == receiverPoints) {
            final String points = POINTS[serverPoints];
            return String.format(EQUALITY_LT_3, points);
        }
        return null;
    }
}