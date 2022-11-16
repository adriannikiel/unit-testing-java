package pl.anikiel.testing.meal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MealRepositoryTest {

    MealRepository mealRepository = new MealRepository();

    @BeforeEach
    void cleanUp() {
        mealRepository.getAllMeals().clear();
    }

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

    @Test
    void shouldBeAbleToFindMealByExactName() {
        //given
        Meal meal = new Meal(10, "Pizza");
        Meal meal2 = new Meal(10, "Pi");
        mealRepository.add(meal);
        mealRepository.add(meal2);

        //when
        List<Meal> results = mealRepository.findByName("Pizza", true);

        //then
        assertThat(results.size()).isEqualTo(1);
    }

    @Test
    void shouldBeAbleToFindMealByStartingLetters() {
        //given
        Meal meal = new Meal(10, "Pizza");
        Meal meal2 = new Meal(10, "Pi");
        mealRepository.add(meal);
        mealRepository.add(meal2);

        //when
        List<Meal> results = mealRepository.findByName("P", false);

        //then
        assertThat(results.size()).isEqualTo(2);
    }

    @Test
    void shouldBeAbleToFindMealByExactPrice() {
        //given
        Meal meal = new Meal(10, "Pizza");
        mealRepository.add(meal);

        //when
        List<Meal> results = mealRepository.findByPrice(10, SearchType.EXACT);

        //then
        assertThat(results.size()).isEqualTo(1);
    }

    @Test
    void shouldBeAbleToFindMealByLesserPrice() {
        //given
        Meal meal = new Meal(10, "Pizza");
        Meal meal2 = new Meal(6, "Sandwich");
        mealRepository.add(meal);
        mealRepository.add(meal2);

        //when
        List<Meal> results = mealRepository.findByPrice(10, SearchType.LESS);

        //then
        assertThat(results.size()).isEqualTo(1);
        assertThat(results.get(0)).isEqualTo(meal2);
    }

    @Test
    void shouldBeAbleToFindMealByHigherPrice() {
        //given
        Meal meal = new Meal(11, "Pizza");
        Meal meal2 = new Meal(6, "Sandwich");
        mealRepository.add(meal);
        mealRepository.add(meal2);

        //when
        List<Meal> results = mealRepository.findByPrice(10, SearchType.MORE);

        //then
        assertThat(results.size()).isEqualTo(1);
        assertThat(results.get(0)).isEqualTo(meal);
    }

    @Test
    void shouldBeAbleToFindMealByExactNameAndExactPrice() {
        //given
        Meal meal = new Meal(10, "Pizza");
        Meal meal2 = new Meal(10, "Pi");
        Meal meal3 = new Meal(6, "Sandwich");
        Meal meal4 = new Meal(15, "Burger");
        mealRepository.add(meal);
        mealRepository.add(meal2);
        mealRepository.add(meal3);
        mealRepository.add(meal4);

        //when
        List<Meal> results = mealRepository.find("Pizza", true, 10, SearchType.EXACT);

        //then
        assertThat(results.size()).isEqualTo(1);
        assertThat(results.get(0)).isEqualTo(meal);
    }

    @Test
    void shouldBeAbleToFindMealByStartingLettersAndExactPrice() {
        //given
        Meal meal = new Meal(10, "Pizza");
        Meal meal2 = new Meal(10, "Pi");
        Meal meal3 = new Meal(6, "Sandwich");
        Meal meal4 = new Meal(15, "Burger");
        mealRepository.add(meal);
        mealRepository.add(meal2);
        mealRepository.add(meal3);
        mealRepository.add(meal4);

        //when
        List<Meal> results = mealRepository.find("Pi", false, 10, SearchType.EXACT);

        //then
        assertThat(results.size()).isEqualTo(2);
    }

    @Test
    void shouldBeAbleToFindMealByExactNameAndLesserPrice() {
        //given
        Meal meal = new Meal(10, "Pizza");
        Meal meal2 = new Meal(10, "Pi");
        Meal meal3 = new Meal(6, "Pizza");
        Meal meal4 = new Meal(15, "Burger");
        mealRepository.add(meal);
        mealRepository.add(meal2);
        mealRepository.add(meal3);
        mealRepository.add(meal4);

        //when
        List<Meal> results = mealRepository.find("Pizza", true, 11, SearchType.LESS);

        //then
        assertThat(results.size()).isEqualTo(2);
    }

    @Test
    void shouldBeAbleToFindMealByExactNameAndHigherPrice() {
        //given
        Meal meal = new Meal(10, "Pizza");
        Meal meal2 = new Meal(10, "Pi");
        Meal meal3 = new Meal(6, "Pizza");
        Meal meal4 = new Meal(15, "Burger");
        mealRepository.add(meal);
        mealRepository.add(meal2);
        mealRepository.add(meal3);
        mealRepository.add(meal4);

        //when
        List<Meal> results = mealRepository.find("Pizza", true, 9, SearchType.MORE);

        //then
        assertThat(results.size()).isEqualTo(1);
        assertThat(results.get(0)).isEqualTo(meal);
    }

    @Test
    void shouldFindByFirstLetterAndHigherPrice() {
        //given
        Meal meal = new Meal(10, "Pizza");
        Meal meal2 = new Meal(9, "Burger");

        mealRepository.add(meal);
        mealRepository.add(meal2);

        //when
        List<Meal> results = mealRepository.find("B", false, 8, SearchType.MORE);

        //then
        assertThat(results.size()).isEqualTo(1);
        assertThat(results.get(0)).isEqualTo(meal2);
    }
}