package fr.ninauve.renaud.kata;

// https://codingdojo.org/fr/kata/Tennis/
public class Match {
    public static final int MINIMUM_TO_WIN = 4;

    private final MatchScorer bellowMinimumToWin = new BellowMinimumToWinMatchScorer();
    private final MatchScorer aboveMinimumToWin = new AboveMinimumToWinMatchScorer();

    public String score(int serverPoints, int receiverPoints) {
        boolean aboveMinimumToWin = serverPoints >= MINIMUM_TO_WIN || receiverPoints >= MINIMUM_TO_WIN;
        if (aboveMinimumToWin) {
            return this.aboveMinimumToWin.score(serverPoints, receiverPoints);
        }
        return bellowMinimumToWin.score(serverPoints, receiverPoints);
    }
}