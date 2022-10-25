package pl.anikiel.testing.order;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;

class OrderStatusTest {

    @ParameterizedTest
    @EnumSource(OrderStatus.class)
    void allOrderStatusShouldBeShorterThan15Chars(OrderStatus orderStatus) {
        assertThat(orderStatus.toString().length()).isLessThan(15);
    }
}