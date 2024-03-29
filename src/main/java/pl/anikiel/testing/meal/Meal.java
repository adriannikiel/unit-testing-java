package pl.anikiel.testing.meal;

import java.util.Objects;

public class Meal {
    private int price;
    private int quantity;
    private String name;

    public Meal() {
    }

    public Meal(int price) {
        this.price = price;
    }

    public Meal(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public Meal(int price, int quantity, String name) {
        this.price = price;
        this.quantity = quantity;
        this.name = name;
    }

    public int getPrice() {
        return this.price;
    }

    int getQuantity() {
        return quantity;
    }

    public int getDiscountedPrice(int discount) {
        if (discount > this.price) {
            throw new IllegalArgumentException("Discount cannot be higher than the price!");
        }
        return this.price - discount;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Meal meal = (Meal) o;

        if (price != meal.price) return false;
        return Objects.equals(name, meal.name);
    }

    @Override
    public int hashCode() {
        int result = price;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }

    int sumPrice() {
        return getPrice() * getQuantity();
    }

}
