package org.qaqcguild;

import org.qaqcguild.errors.InvalidStatusCodeException;
import org.qaqcguild.errors.InvalidToppingCodeException;

import java.text.NumberFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

public class Order {

    private final Long orderNumber;
    private Integer orderStatus;
    private final LocalDateTime orderStart;
    private LocalDateTime orderEnd;

    public final static Integer ORDERED_STATUS = 1;
    public final static Integer RECEIVED_STATUS = 2;
    public final static Integer PREPARING_STATUS = 3;
    public final static Integer READY_STATUS = 4;
    public final static Integer DELIVERED_STATUS = 5;

    public final Integer[] VALID_STATUS = {
            ORDERED_STATUS,
            RECEIVED_STATUS,
            PREPARING_STATUS,
            READY_STATUS,
            DELIVERED_STATUS
    };

    private final String clientName;
    private final String clientPhone;
    private final String clientAddress;

    public final static Integer MOZZARELLA_TOPPING = 1;
    public final static Integer PEPPERONI_TOPPING = 2;
    public final static Integer MARGHERITA_TOPPING = 3;

    public final Integer[] VALID_TOPPINGS = {
        MOZZARELLA_TOPPING,
        PEPPERONI_TOPPING,
        MARGHERITA_TOPPING
    };

    private final Integer pizzaTopping;
    private Integer pizzaQuantity;


    public Order(Long orderNumber, LocalDateTime orderStart, String clientName, String clientPhone, String clientAddress, Integer pizzaTopping, Integer pizzaQuantity) throws RuntimeException {
        if (Arrays.stream(VALID_TOPPINGS).noneMatch(topping -> Objects.equals(topping, pizzaTopping))) {
            throw new InvalidToppingCodeException();
        }
        this.orderNumber = orderNumber;
        this.orderStart = orderStart;
        this.orderStatus = ORDERED_STATUS;
        this.clientName = clientName;
        this.clientPhone = clientPhone;
        this.clientAddress = clientAddress;
        this.pizzaTopping = pizzaTopping;
        this.pizzaQuantity = pizzaQuantity;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public Double getOrderTotal() {
        return getPizzaPrice() * getPizzaQuantity();
    }

    public String getOrderFormattedTotal() {
        return NumberFormat.getCurrencyInstance().format(getOrderTotal());
    }

    public LocalDateTime getOrderEnd() {
        return orderEnd;
    }

    public String getClientName() {
        return clientName;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public Integer getPizzaTopping() {
        return pizzaTopping;
    }

    public Integer getPizzaQuantity() {
        return pizzaQuantity;
    }

    public Double getPizzaPrice() {
        switch (pizzaTopping) {
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

    public Long getOrderDuration() {
        LocalDateTime lastTime = orderEnd;
        if (lastTime == null) {
            lastTime = LocalDateTime.now();
        }
        Duration duration = Duration.between(orderStart, lastTime);
        return Math.abs(duration.toMinutes());
    }

    public void setOrderEnd(LocalDateTime orderEnd) {
        this.orderEnd = orderEnd;
    }

    public void setOrderStatus(Integer newOrderStatus) {
        if (Arrays.stream(VALID_STATUS).noneMatch(status -> Objects.equals(status, newOrderStatus))) {
            throw new InvalidStatusCodeException();
        }
        this.orderStatus = newOrderStatus;
    }

    public Integer addQuantity(Integer additionalAmount) {
        pizzaQuantity = getPizzaQuantity() + additionalAmount;
        return pizzaQuantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", orderStatus=" + orderStatus +
                ", orderStart=" + orderStart +
                ", orderEnd=" + orderEnd +
                ", orderTotal=" + getOrderTotal() +
                ", clientName='" + clientName + '\'' +
                ", clientPhone='" + clientPhone + '\'' +
                ", clientAddress='" + clientAddress + '\'' +
                ", pizzaTopping=" + pizzaTopping +
                ", pizzaQuantity=" + pizzaQuantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (!Objects.equals(orderNumber, order.orderNumber)) return false;
        if (!Objects.equals(orderStatus, order.orderStatus)) return false;
        if (!Objects.equals(orderStart, order.orderStart)) return false;
        if (!Objects.equals(orderEnd, order.orderEnd)) return false;
        if (!Objects.equals(clientName, order.clientName)) return false;
        if (!Objects.equals(clientPhone, order.clientPhone)) return false;
        if (!Objects.equals(clientAddress, order.clientAddress))
            return false;
        if (!Objects.equals(pizzaTopping, order.pizzaTopping)) return false;
        return Objects.equals(pizzaQuantity, order.pizzaQuantity);
    }

    @Override
    public int hashCode() {
        int result = orderNumber != null ? orderNumber.hashCode() : 0;
        result = 31 * result + (orderStatus != null ? orderStatus.hashCode() : 0);
        result = 31 * result + (orderStart != null ? orderStart.hashCode() : 0);
        result = 31 * result + (orderEnd != null ? orderEnd.hashCode() : 0);
        result = 31 * result + (clientName != null ? clientName.hashCode() : 0);
        result = 31 * result + (clientPhone != null ? clientPhone.hashCode() : 0);
        result = 31 * result + (clientAddress != null ? clientAddress.hashCode() : 0);
        result = 31 * result + (pizzaTopping != null ? pizzaTopping.hashCode() : 0);
        result = 31 * result + (pizzaQuantity != null ? pizzaQuantity.hashCode() : 0);
        return result;
    }
}
