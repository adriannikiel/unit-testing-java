package pl.anikiel.testing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class AddressTest {

    @ParameterizedTest
    @CsvSource({"Fabryczna, 10", "Armii Krajowej, 57/11", "'Romka, Tomka, Atomka', 40"})
    void givenAddressesShouldNotBeEmptyAndHaveProperNames(String street, String number) {
        assertThat(street).isNotNull();
        assertThat(street).containsSequence("a");
        assertThat(number).isNotNull();
        assertThat(number.length()).isLessThan(8);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/addresses.csv")
    void addressesFromFileShouldNotBeEmptyAndHaveProperNames(String street, String number) {
        assertThat(street).isNotNull();
        assertThat(street).containsSequence("a");
        assertThat(number).isNotNull();
        assertThat(number.length()).isLessThan(8);
    }
}