package pl.anikiel.testing;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeout;

class CardTest {

    @Test
    void simulateLargeOrder() {
        //given
        Card card = new Card();

        //when
        //then
        assertTimeout(Duration.ofMillis(100), card::simulateLargeOrder);
    }
}