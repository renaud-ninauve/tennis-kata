package fr.ninauve.renaud.kata;

// https://codingdojo.org/fr/kata/Tennis/
public class Match {

    public String score(int serverPoints, int receiverPoints) {
        if (serverPoints == 0 && receiverPoints == 0) {
            return "0 - all";
        }
        return serverPoints == 3 && receiverPoints == 3 ? "deuce": null;
    }
}