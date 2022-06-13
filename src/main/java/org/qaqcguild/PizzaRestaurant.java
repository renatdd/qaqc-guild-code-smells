package org.qaqcguild;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PizzaRestaurant {

    private final List<Order> orders = new ArrayList<>();
    private final Menu menu;

    public PizzaRestaurant() {
        this.menu = new Menu();
    }

    public Order makeNewOrder(Client client, Pizza... pizzas) {
        Order newOrder = new Order(getOrderNumber(), LocalDateTime.now(), client, pizzas);
        orders.add(newOrder);
        return newOrder;
    }

    private long getOrderNumber() {
        return (long) orders.size() + 1;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public Integer getTotalOrders() {
        return orders.size();
    }

    public List<Order> getOrdersByStatus(Integer statusCode) {
        return orders.stream().filter(order -> Objects.equals(order.getStatus(), statusCode)).collect(Collectors.toList());
    }

    public Integer getOrdersQuantityByStatus(Integer statusCode) {
        return getOrdersByStatus(statusCode).size();
    }

}