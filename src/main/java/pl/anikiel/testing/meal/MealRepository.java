package pl.anikiel.testing.meal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MealRepository {

    private List<Meal> meals = new ArrayList<>();

    public void add(Meal meal) {
        meals.add(meal);
    }

    public List<Meal> getAllMeals() {
        return meals;
    }

    public void delete(Meal meal) {
        meals.remove(meal);
    }

    public List<Meal> findByName(String mealName, boolean exactMatch) {

        List<Meal> result;

        if (exactMatch) {
            result = meals.stream()
                    .filter(meal -> meal.getName().equals(mealName))
                    .collect(Collectors.toList());
        } else {
            result = meals.stream()
                    .filter(meal -> meal.getName().startsWith(mealName))
                    .collect(Collectors.toList());
        }

        return result;
    }

    public List<Meal> find(String mealName, boolean exactMatch, int price, SearchType type) {
        List<Meal> mealByName = findByName(mealName, exactMatch);

        return findByPriceWithInitialData(price, type, mealByName);
    }

    public List<Meal> findByPrice(int price, SearchType type) {
        return findByPriceWithInitialData(price, type, meals);
    }

    private List<Meal> findByPriceWithInitialData(int price, SearchType type, List<Meal> meals) {

        List<Meal> result = new ArrayList<>();

        switch (type) {
            case EXACT:
                result = meals.stream()
                        .filter(meal -> meal.getPrice() == price)
                        .collect(Collectors.toList());
                break;
            case MORE:
                result = meals.stream()
                        .filter(meal -> meal.getPrice() > price)
                        .collect(Collectors.toList());
                break;
            case LESS:
                result = meals.stream()
                        .filter(meal -> meal.getPrice() < price)
                        .collect(Collectors.toList());
                break;
        }

        return result;
    }
}
