package org.qaqcguild;

import java.text.NumberFormat;

public enum PizzaToppingEnum {
    MOZZARELLA(1, 9.50),
    PEPPERONI(2, 11.20),
    MARGHERITA(3, 10.10);

    private final Integer code;
    private final Double price;

    public int getCode() {
        return code;
    }

    public Double getPrice() {
        return price;
    }

    public String getPriceString() {
        return NumberFormat.getCurrencyInstance().format(getPrice());
    }

    PizzaToppingEnum(int code, Double price) {
        this.code = code;
        this.price = price;
    }

}

