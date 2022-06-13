package org.qaqcguild;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.qaqcguild.toppings.PepperoniTopping;
import org.qaqcguild.toppings.PizzaTopping;

class PizzaTest {

    @Test
    void shouldCreatePizzaObject() {
        Pizza pizza = new Pizza(new PepperoniTopping(), 1);

        TestUtils.printObject(pizza);

        Assertions.assertEquals(2, pizza.getTopping().getCode());
        Assertions.assertEquals(1, pizza.getQuantity());
        Assertions.assertEquals(11.20, pizza.getPrice());
        Assertions.assertEquals("$11.20", pizza.getTopping().getPriceString());
        Assertions.assertEquals(3, pizza.addQuantity(2));

        TestUtils.printObject(pizza);
    }

//    @Test
//    void shouldThrowErrorWithInvalidTopCode() {
//        Assertions.assertThrows(InvalidToppingCodeException.class, () ->{
//            Pizza pizza = new Pizza(4, 1);
//        });
//    }


    @Test
    void shouldCreateAPizzaWithNewTopping() {
        PizzaTopping customTopping = new PizzaTopping(4, "Custom topping", 15.00);
        Pizza pizza = new Pizza(customTopping, 2);

        Assertions.assertEquals(4, pizza.getTopping().getCode());
        Assertions.assertEquals(15.00, pizza.getPrice());
        Assertions.assertEquals("Custom topping", pizza.getName());

    }
}