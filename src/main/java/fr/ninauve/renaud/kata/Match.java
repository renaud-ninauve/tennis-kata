package fr.ninauve.renaud.kata;

// https://codingdojo.org/fr/kata/Tennis/
public class Match {

    public String score(int nbPoints1, int nbPoints2) {
        return nbPoints1 == 3 && nbPoints2 == 3 ? "deuce": null;
    }
}