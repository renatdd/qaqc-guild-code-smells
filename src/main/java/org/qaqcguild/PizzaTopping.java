package org.qaqcguild;

import java.text.NumberFormat;

public class PizzaTopping {

    public final static PizzaTopping MOZZARELLA = new PizzaTopping(1, 9.50);
    public final static PizzaTopping PEPPERONI = new PizzaTopping(2, 11.20);
    public final static PizzaTopping MARGHERITA = new PizzaTopping(3, 10.10);

    private final Integer code;
    private final Double price;

    public PizzaTopping(Integer code, Double price) {
        this.code = code;
        this.price = price;
    }

    public Integer getCode() {
        return code;
    }

    public Double getPrice() {
        return price;
    }

    public String getPriceString() {
        return NumberFormat.getCurrencyInstance().format(getPrice());
    }

    @Override
    public String toString() {
        return "PizzaTopping{" +
                "code=" + code +
                ", price=" + getPriceString() +
                '}';
    }
}
