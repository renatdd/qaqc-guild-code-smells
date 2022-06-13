package org.qaqcguild;

import org.qaqcguild.errors.InvalidToppingCodeException;
import org.qaqcguild.toppings.MargheritaTopping;
import org.qaqcguild.toppings.MozzarellaTopping;
import org.qaqcguild.toppings.PepperoniTopping;
import org.qaqcguild.toppings.PizzaTopping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {

    private final Map<Integer, PizzaTopping> menu = new HashMap<>();

    public Menu() {
        setMenu(getToppings());
    }

    private void setMenu(List<PizzaTopping> toppings) {
        toppings.forEach(topping -> menu.put(topping.getCode(), topping));
    }

    private List<PizzaTopping> getToppings() {
        return List.of(
                new MozzarellaTopping(),
                new PepperoniTopping(),
                new MargheritaTopping()
        );
    }

    public Map<Integer, PizzaTopping> getMenu() {
        return menu;
    }

    public PizzaTopping getToppingByCode(Integer toppingCode) throws InvalidToppingCodeException {
        PizzaTopping requestedTopping = menu.getOrDefault(toppingCode, null);
        if (requestedTopping == null) {
            throw new InvalidToppingCodeException();
        }
        return requestedTopping;
    }

}
