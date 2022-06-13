package org.qaqcguild.toppings;

import java.text.NumberFormat;

public class PizzaTopping {

    private final Integer code;
    private final String name;
    private final Double price;


    public PizzaTopping(Integer code, String name, Double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
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
                "name=" + name +
                ", price=" + getPriceString() +
                '}';
    }

}
