package pl.anikiel.testing.homework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UnitTest {

    Coordinates coordinates;
    Unit unit;
    int initX;
    int initY;
    int maxFuel;
    int maxCargoWeight;

    @BeforeEach
    void setUp() {
        initX = 0;
        initY = 0;
        maxFuel = 15;  // maxFuel < moveX + moveY
        maxCargoWeight = 20;

        coordinates = new Coordinates(initX, initY);
        unit = new Unit(coordinates, maxFuel, maxCargoWeight);
    }

    @Test
    void shouldThrowExceptionWhenMoveCoordinatesAreTooBig() {
        //given
        int moveX = 10;
        int moveY = 6;
        // moveX + moveY > maxFuel

        //when
        assertThrows(IllegalStateException.class, () -> {
            unit.move(moveX, moveY);
        });
    }

    @Test
    void shouldDecreaseFuelAmountAfterMove() {
        //given
        int moveX = 3;
        int moveY = 5;

        //when
        unit.move(moveX, moveY);

        //then
        assertThat(unit.getFuel()).isLessThan(maxFuel);
    }

    @Test
    void shouldReturnNewCoordinatesAfterMove() {
        //given
        int moveX = 3;
        int moveY = 5;

        //when
        Coordinates move = unit.move(moveX, moveY);

        //then
        assertThat(move).isEqualTo(new Coordinates(initX + moveX, initY + moveY));
    }

    @RepeatedTest(10)
    void shouldNotExceedMaxFuelLimit() {
        //given
        //when
        unit.tankUp();

        //then
        assertThat(unit.getFuel()).isGreaterThanOrEqualTo(0);
        assertThat(unit.getFuel()).isLessThanOrEqualTo(unit.getMaxFuel());
    }

    @Test
    void cargoCanNotExceedMaxWeightLimit() {
        //given
        Cargo cargo1 = new Cargo("cargo1", 10);
        Cargo cargo2 = new Cargo("cargo2", 15);

        //when
        unit.loadCargo(cargo1);

        //then
        assertThrows(IllegalStateException.class, () -> {
           unit.loadCargo(cargo2);
        });
    }

    @Test
    void addingCargoShouldIncreaseCurrentCargoWeight() {
        //given
        int initCargoWeight = unit.getLoad();
        Cargo cargo1 = new Cargo("cargo1", 10);

        //when
        unit.loadCargo(cargo1);

        //then
        assertThat(unit.getLoad()).isGreaterThan(initCargoWeight);
    }

    @Test
    void unloadingSingleCargoShouldReduceUnitLoad() {
        //given
        Cargo cargo1 = new Cargo("cargo1", 10);

        unit.loadCargo(cargo1);
        int cargoWeight = unit.getLoad();

        //when
        unit.unloadCargo(cargo1);

        //then
        assertThat(unit.getLoad()).isLessThan(cargoWeight);
    }

    @Test
    void unloadingAllCargoShouldReduceUnitLoadToZero() {
        //given
        Cargo cargo1 = new Cargo("cargo1", 10);
        Cargo cargo2 = new Cargo("cargo2", 8);

        unit.loadCargo(cargo1);
        unit.loadCargo(cargo2);

        //when
        unit.unloadAllCargo();

        //then
        assertThat(unit.getLoad()).isEqualTo(0);
    }
}