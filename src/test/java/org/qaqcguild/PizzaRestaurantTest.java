package org.qaqcguild;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.qaqcguild.errors.InvalidStatusCodeException;
import org.qaqcguild.errors.InvalidToppingCodeException;

class PizzaRestaurantTest {

    private static PizzaRestaurant pizzaRestaurant;

    @BeforeAll
    static void setPizzaRestaurant() {
        pizzaRestaurant = new PizzaRestaurant();
    }

    @Test
    void shouldAddANewPizzaOrder() {

        Order newOrder = getValidOrder();

        printOrder(newOrder);

        Assertions.assertEquals("Renato Feitosa", newOrder.getClientName());
        Assertions.assertEquals("81999999999", newOrder.getClientPhone());
        Assertions.assertEquals("Rua da Pizza, 57", newOrder.getClientAddress());
        Assertions.assertEquals(2, newOrder.getPizzaTopping());
        Assertions.assertEquals(1, newOrder.getPizzaQuantity());
        Assertions.assertEquals(11.20, newOrder.getPizzaPrice());
        Assertions.assertEquals(11.20, newOrder.getOrderTotal());

        Assertions.assertEquals(2, newOrder.addQuantity(1));
        Assertions.assertEquals(22.40, newOrder.getOrderTotal());

        Assertions.assertEquals(1, pizzaRestaurant.getTotalOrders());
        Assertions.assertEquals(1, pizzaRestaurant.getOrdersQuantityByStatus(1));
    }

    private void printOrder(Order newOrder) {
        System.out.println("\n\n==================================================================");
        System.out.println(newOrder);
        System.out.println("==================================================================\n\n");
    }

    private Order getValidOrder() {
        return pizzaRestaurant.makeNewOrder(
                "Renato Feitosa",
                "81999999999",
                "Rua da Pizza, 57",
                Order.PEPPERONI_TOPPING,
                1);
    }

    @Test
    void shouldThrowErrorWhenPizzaOfUnkownType() {
        Assertions.assertThrows(InvalidToppingCodeException.class, () ->{
            pizzaRestaurant.makeNewOrder(
                    "New Client",
                    "99999999999",
                    "432 Bloaters St.",
                    4,
                    1);
        });
    }

    @Test
    void shouldThrowErrorWhenSetInvalidStatusCode() {
        Order newOrder = getValidOrder();

        Assertions.assertThrows(InvalidStatusCodeException.class, () ->{
            newOrder.setOrderStatus(6);
        });
    }

}