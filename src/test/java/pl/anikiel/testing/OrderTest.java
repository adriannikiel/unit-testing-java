package pl.anikiel.testing;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(BeforeAfterExtension.class)
class OrderTest {

    private Order order;

    @BeforeEach
    void initializeOrder() {
        order = new Order();
    }

    @AfterEach
    void cleanUp() {
        order.cancel();
    }

    @Test
    void testAssertArrayEquals() {
        //given
        int[] ints1 = {1, 2, 3};
        int[] ints2 = {1, 2, 3};

        //then
        assertArrayEquals(ints1, ints2);
    }

    @Test
    void testIfTwoListAreTheSame() {
        //given
        Meal meal1 = new Meal(15, "Burger");
        Meal meal2 = new Meal(5, "Sandwich");
        Meal meal3 = new Meal(11, "Kebab");

        List<Meal> meals1 = List.of(meal1, meal2);
        List<Meal> meals2 = List.of(meal1, meal2);

        //then
        assertThat(meals1).isEqualTo(meals2);
    }

    @Test
    void mealListShouldBeEmptyAfterCreationOfOrder() {
        //given

        //then
        assertThat(order.getMeals()).isEmpty();
        assertThat(order.getMeals().size()).isZero();
        assertThat(order.getMeals()).hasSize(0);
    }

    @Test
    void addingMealToOrderShouldIncreaseOrderSize() {
        //given
        Meal meal = new Meal(15, "Burger");
        Meal meal2 = new Meal(5, "Sandwich");

        //when
        order.addMealToOrder(meal);

        //then
        assertThat(order.getMeals()).hasSize(1);
        assertThat(order.getMeals()).contains(meal);
        assertThat(order.getMeals().get(0).getPrice()).isEqualTo(15);
        assertThat(order.getMeals()).isNotEmpty();
    }

    @Test
    void removingMealFromOrderShouldDecreaseOrderSize() {
        //given
        Meal meal = new Meal(15, "Burger");

        //when
        order.addMealToOrder(meal);
        order.removeMealFromOrder(meal);

        //then
        assertThat(order.getMeals()).hasSize(0);
        assertThat(order.getMeals()).doesNotContain(meal);
    }

    @Test
    void mealsShouldBeInCorrectOrderAfterAddingThemToOrder() {
        //given
        Meal meal1 = new Meal(15, "Burger");
        Meal meal2 = new Meal(5, "Sandwich");

        //when
        order.addMealToOrder(meal1);
        order.addMealToOrder(meal2);

        //then
        assertThat(order.getMeals()).contains(meal1, meal2);
        assertThat(order.getMeals()).containsExactlyInAnyOrder(meal2, meal1);
    }
}