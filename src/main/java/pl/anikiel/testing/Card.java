package pl.anikiel.testing;

import java.util.ArrayList;
import java.util.List;

public class Card {
    private List<Order> orders = new ArrayList<>();

    void addOrderToCard(Order order) {
        this.orders.add(order);
    }

    void clearCard() {
        this.orders.clear();
    }

    void simulateLargeOrder() {
        for (int i = 0; i < 1_000; i++) {
            Meal meal = new Meal(i % 10, "Hamburger nr " + i);
            Order order = new Order();
            order.addMealToOrder(meal);
            addOrderToCard(order);
        }
        System.out.println("Card size: " + orders.size());
        clearCard();
    }
}
