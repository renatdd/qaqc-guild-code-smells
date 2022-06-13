package org.qaqcguild;

import org.qaqcguild.errors.InvalidToppingCodeException;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Objects;

public class Pizza {

    public final static Integer MOZZARELLA_TOPPING = 1;
    public final static Integer PEPPERONI_TOPPING = 2;
    public final static Integer MARGHERITA_TOPPING = 3;

    private final Integer topping;
    private Integer quantity;

    public Pizza(Integer topping, Integer quantity) throws InvalidToppingCodeException {
        if (isValidTopping(topping)) {
            throw new InvalidToppingCodeException();
        }
        this.topping = topping;
        this.quantity = quantity;
    }

    private boolean isValidTopping(Integer topping) {
        return Arrays.stream(getValidToppings()).noneMatch(toppingItem -> Objects.equals(toppingItem, topping));
    }

    private Integer[] getValidToppings() {
        return new Integer[]{
                MOZZARELLA_TOPPING,
                PEPPERONI_TOPPING,
                MARGHERITA_TOPPING
        };
    }

    public Integer getTopping() {
        return topping;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        switch (topping) {
            case 1:
                return 9.50;
            case 2:
                return 11.20;
            case 3:
                return 10.10;
            default:
                throw new InvalidToppingCodeException();
        }
    }

    public String getPriceString() {
        return NumberFormat.getCurrencyInstance().format(getPrice());
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
                ", price=" + getPriceString() +
                '}';
    }
}
