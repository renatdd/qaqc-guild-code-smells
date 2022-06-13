package org.qaqcguild;

import org.qaqcguild.toppings.PizzaTopping;

public class Pizza {

    private final PizzaTopping topping;
    private Integer quantity;

    public Pizza(PizzaTopping topping, Integer quantity) {
        this.topping = topping;
        this.quantity = quantity;
    }

    public PizzaTopping getTopping() {
        return topping;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return getTopping().getPrice();
    }

    public String getName() {
        return getTopping().getName();
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer addQuantity(Integer additionalAmount) {
        quantity = getQuantity() + additionalAmount;
        return quantity;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "topping=" + topping +
                ", quantity=" + quantity +
                ", price=" + getTopping().getPriceString() +
                '}';
    }
}
