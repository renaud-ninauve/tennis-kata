package fr.ninauve.renaud.kata;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MatchTest {

    static Stream<Arguments> score() {
        return Stream.of(
                Arguments.of(3, 3, "deuce"),
                Arguments.of(0, 0, "0 - all"),
                Arguments.of(1, 1, "15 - all"),
                Arguments.of(2, 2, "30 - all"),
                Arguments.of(1, 0, "15 - 0"),
                Arguments.of(2, 0, "30 - 0"),
                Arguments.of(3, 0, "40 - 0"),
                Arguments.of(0, 1, "0 - 15"),
                Arguments.of(0, 2, "0 - 30"),
                Arguments.of(0, 3, "0 - 40"),
                Arguments.of(1, 2, "15 - 30"),
                Arguments.of(4, 1, "server wins"),
                Arguments.of(1, 4, "receiver wins"),
                Arguments.of(4, 3, "advantage in"),
                Arguments.of(3, 4, "advantage out"),
                Arguments.of(7, 6, "advantage in"),
                Arguments.of(6, 7, "advantage out"),
                Arguments.of(7, 7, "deuce"),
                Arguments.of(8, 6, "server wins")
        );
    }

    @ParameterizedTest
    @MethodSource
    void score(int nbPoints1, int nbPoints2, String expected) {
        String actual = new Match().score(nbPoints1, nbPoints2);
        assertThat(actual).isEqualTo(expected);
    }
}