package pl.anikiel.testing.homework;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class UnitServiceTest {

    @InjectMocks
    private UnitService unitService;
    @Mock
    private CargoRepository cargoRepository;

    @Mock
    private UnitRepository unitRepository;

    @Test
    void shouldLoadCargoIfCargoIsFound() {
        //given
        Unit unit = new Unit(new Coordinates(0, 0), 10, 30);
        Cargo cargo = new Cargo("cargo", 10);

        given(cargoRepository.findCargoByName(anyString())).willReturn(Optional.of(cargo));

        //when
        unitService.addCargoByName(unit, anyString());

        //then
        then(cargoRepository).should().findCargoByName(anyString());
        assertThat(unit.getLoad()).isEqualTo(10);
        assertThat(unit.getCargo().size()).isEqualTo(1);
    }

    @Test
    void shouldThrowExceptionIfCargoIsNotFound() {
        //given
        Unit unit = new Unit(new Coordinates(0, 0), 10, 30);

        given(cargoRepository.findCargoByName(anyString())).willReturn(Optional.empty());

        //then
        assertThrows(NoSuchElementException.class, () -> unitService.addCargoByName(unit, anyString()));
    }

    @Test
    void shouldReturnUnitIfFoundInUnitRepository() {
        //given
        Unit unit = new Unit(new Coordinates(0, 0), 10, 30);

        given(unitRepository.getUnitByCoordinates(new Coordinates(0, 0))).willReturn(unit);

        //when
        Unit result = unitService.getUnitOn(new Coordinates(0, 0));

        //then
        assertEquals(unit, result);
    }

    @Test
    void shouldThrowExceptionIfNotFoundInUnitRepository() {
        //given
        given(unitRepository.getUnitByCoordinates(new Coordinates(0, 0))).willReturn(null);

        //then
        assertThrows(NoSuchElementException.class, () -> unitService.getUnitOn(new Coordinates(0, 0)));
    }
}