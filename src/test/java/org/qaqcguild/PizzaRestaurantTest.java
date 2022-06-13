package org.qaqcguild;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.qaqcguild.errors.InvalidStatusCodeException;
import org.qaqcguild.toppings.MozzarellaTopping;
import org.qaqcguild.toppings.PepperoniTopping;

class PizzaRestaurantTest {

    private PizzaRestaurant pizzaRestaurant;

    @BeforeEach
    void setPizzaRestaurant() {
        pizzaRestaurant = new PizzaRestaurant();
    }

    @Test
    void shouldAddANewPizzaOrder() {

        Order newOrder = getValidOrder();

        TestUtils.printObject(newOrder);

        Assertions.assertEquals("Renato Feitosa", newOrder.getClient().getFullName());
        Assertions.assertEquals("(81) 99999-9999", newOrder.getClient().getPhone().toString());
        Assertions.assertEquals("Rua dos Carecas", newOrder.getClient().getAddress().getStreet());

        Assertions.assertEquals(20.70, newOrder.getBillTotal());

        Assertions.assertEquals(1, pizzaRestaurant.getTotalOrders());
        Assertions.assertEquals(1, pizzaRestaurant.getOrdersQuantityByStatus(1));
    }

    private Order getValidOrder() {
        ClientAddress address = ClientAddress.builder()
                .street("Rua dos Carecas")
                .number("57")
                .district("Bairro dos Sem-Telha")
                .city("Baldtown")
                .build();
        ClientPhone phone = new ClientPhone("081999999999");
        Client client = new Client("Renato", "Feitosa", phone, address);
        Pizza pepperoniPizza = new Pizza(new PepperoniTopping(), 1);
        Pizza mozzarellaPizza = new Pizza(new MozzarellaTopping(), 1);

        return pizzaRestaurant.makeNewOrder(client, pepperoniPizza, mozzarellaPizza);
    }


    @Test
    void shouldThrowErrorWhenSetInvalidStatusCode() {
        Order newOrder = getValidOrder();

        Assertions.assertThrows(InvalidStatusCodeException.class, () ->{
            newOrder.setStatus(6);
        });
    }

}