package pl.anikiel.testing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MealRepositoryTest {

    MealRepository mealRepository = new MealRepository();

    @Test
    void shouldBeAbleToAddMealToRepository() {
        //given
        Meal meal = new Meal(10, "Pizza");

        //when
        mealRepository.add(meal);

        //then
        assertThat(mealRepository.getAllMeals().get(0)).isEqualTo(meal);
    }

    @Test
    void shouldBeAbleToRemoveMealFromRepository() {
        //given
        Meal meal = new Meal(10, "Pizza");
        mealRepository.add(meal);

        //when
        mealRepository.delete(meal);

        //then
        assertThat(mealRepository.getAllMeals()).doesNotContain(meal);
    }
}