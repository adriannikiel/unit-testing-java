package pl.anikiel.testing.order;

import org.junit.jupiter.api.*;
import pl.anikiel.testing.meal.Meal;

import java.io.FileNotFoundException;
import java.io.IOException;

class OrderBackupTest {
    private static OrderBackup orderBackup;

    @BeforeAll
    static void setUp() throws FileNotFoundException {
        orderBackup = new OrderBackup();
        orderBackup.createFile();
    }

    @AfterAll
    static void tearDown() throws IOException {
        orderBackup.closeFile();
    }

    @BeforeEach
    void appendAtTheStartOfTheLine() throws IOException {
        orderBackup.getWriter().append("New order: ");
    }

    @AfterEach
    void appendAtTheEndOfTheLine() throws IOException {
        orderBackup.getWriter().append(" backed up.");
    }

    @Tag("fries")
    @Test
    void backupOrderWithOneMeal() throws IOException {
        //given
        Meal meal = new Meal(7, "Fries");
        Order order = new Order();
        order.addMealToOrder(meal);

        //when
        orderBackup.backupOrder(order);

        //then
        System.out.println("Order: " + order.toString() + " backed up.");
    }
}