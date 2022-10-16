package pl.anikiel.testing.homework;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CoordinatesTest {

    @Test
    void shouldThrowExceptionWhenOneNumberBelowZero() {
        //given
        int positiveNumber = 5;
        int negativeNumber = -5;

        //when
        Exception exception1 = assertThrows(IllegalArgumentException.class, () -> {
            new Coordinates(positiveNumber, negativeNumber);
        });

        Exception exception2 = assertThrows(IllegalArgumentException.class, () -> {
            new Coordinates(negativeNumber, positiveNumber);
        });

        //then
        assertAll(
                () -> assertEquals("Position can not be less than 0", exception1.getMessage()),
                () -> assertEquals("Position can not be less than 0", exception2.getMessage())
        );
    }

    @Test
    void shouldThrowExceptionWhenOneNumberAboveAHundred() {
        //given
        int above100 = 101;
        int secondNumber = 5;

        //when
        Exception exception1 = assertThrows(IllegalArgumentException.class, () -> {
            new Coordinates(above100, secondNumber);
        });

        Exception exception2 = assertThrows(IllegalArgumentException.class, () -> {
            new Coordinates(secondNumber, above100);
        });

        //then
        assertAll(
                () -> assertEquals("Position can not be more than 100", exception1.getMessage()),
                () -> assertEquals("Position can not be more than 100", exception2.getMessage())
        );
    }

    @Test
    void shouldCreateNewInstanceAfterCopy() {
        //given
        Coordinates coordinates = new Coordinates(25, 50);

        //when
        Coordinates coordinates1 = Coordinates.copy(coordinates, 0, 0);

        //then
        assertThat(coordinates1).isNotSameAs(coordinates);
    }

    @Test
    void shouldBeEqualAfterCopyWithSameCoordinates() {
        //given
        Coordinates coordinates = new Coordinates(25, 50);

        //when
        Coordinates coordinates1 = Coordinates.copy(coordinates, 0, 0);

        //then
        assertThat(coordinates1).isEqualTo(coordinates);
    }

    @Test
    void shouldReturnCorrectedCoordinatesAfterCopy() {
        //given
        Coordinates coordinates = new Coordinates(25, 50);

        //when
        Coordinates copied = Coordinates.copy(coordinates, 5, -5);

        //then
        assertEquals(30, copied.getX());
        assertEquals(45, copied.getY());
    }

}