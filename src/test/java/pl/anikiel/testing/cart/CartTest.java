package pl.anikiel.testing.cart;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.anikiel.testing.cart.Cart;
import pl.anikiel.testing.order.Order;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTimeout;

@DisplayName("Test cases for Cart")
class CartTest {

    //@Disabled
    @Test
    @DisplayName("Cart is able to process 1000 orders in 100 ms")
    void simulateLargeOrder() {
        //given
        Cart cart = new Cart();

        //when
        //then
        assertTimeout(Duration.ofMillis(100), cart::simulateLargeOrder);
    }

    @Test
    void cartShouldNotBeEmptyAfterAddingOrderToCart() {
        //given
        Order order = new Order();
        Cart cart = new Cart();

        //when
        cart.addOrderToCart(order);

        //then
        assertAll("This is a group assertions for cart",
                () -> assertThat(cart.getOrders()).isNotNull(),
                () -> assertThat(cart.getOrders()).hasSize(1),
                () -> assertThat(cart.getOrders()).isNotEmpty()
        );

    }

}