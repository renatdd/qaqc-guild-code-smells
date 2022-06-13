package org.qaqcguild;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.qaqcguild.errors.InvalidToppingCodeException;

class PizzaTest {

    @Test
    void shouldCreatePizzaObject() {
        Pizza pizza = new Pizza(Pizza.PEPPERONI_TOPPING, 1);

        TestUtils.printObject(pizza);

        Assertions.assertEquals(2, pizza.getTopping());
        Assertions.assertEquals(1, pizza.getQuantity());
        Assertions.assertEquals(11.20, pizza.getPrice());
        Assertions.assertEquals("$11.20", pizza.getPriceString());
        Assertions.assertEquals(3, pizza.addQuantity(2));

        TestUtils.printObject(pizza);
    }

    @Test
    void shouldThrowErrorWithInvalidTopCode() {
        Assertions.assertThrows(InvalidToppingCodeException.class, () ->{
            Pizza pizza = new Pizza(4, 1);
        });
    }
}