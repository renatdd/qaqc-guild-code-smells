package org.qaqcguild;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PizzaRestaurant {

    private final List<Order> orders = new ArrayList<>();

    public PizzaRestaurant() {
    }

    public Order makeNewOrder(String clientName, String clientPhone, String clientAddress, Integer pizzaTopping,
                              Integer pizzaQuantity)  throws RuntimeException {
        Long orderNumber = (long) orders.size() + 1;
        Order newOrder = new Order(orderNumber, LocalDateTime.now(), clientName, clientPhone, clientAddress,
                pizzaTopping, pizzaQuantity);
        orders.add(newOrder);
        return newOrder;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public Integer getTotalOrders() {
        return orders.size();
    }

    public List<Order> getOrdersByStatus(Integer statusCode) {
        return orders.stream().filter(order -> Objects.equals(order.getOrderStatus(), statusCode)).collect(Collectors.toList());
    }

    public Integer getOrdersQuantityByStatus(Integer statusCode) {
        return getOrdersByStatus(statusCode).size();
    }

}