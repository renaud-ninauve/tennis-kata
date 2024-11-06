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
                Arguments.of(1, 0, "15 - 0")
        );
    }

    @ParameterizedTest
    @MethodSource
    void score(int nbPoints1, int nbPoints2, String expected) {
        String actual = new Match().score(nbPoints1, nbPoints2);
        assertThat(actual).isEqualTo(expected);
    }
}