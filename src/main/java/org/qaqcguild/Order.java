package org.qaqcguild;

import org.qaqcguild.errors.InvalidStatusCodeException;

import java.text.NumberFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Order {

    private final Long number;
    private Integer status;
    private final LocalDateTime start;
    private LocalDateTime end;

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

    private final Client client;
    private final List<Pizza> pizzas = new ArrayList<>();

    public Order(Long number, LocalDateTime start, Client client, Pizza... pizzas) {
        this.number = number;
        this.start = start;
        this.status = ORDERED_STATUS;
        this.client = client;
        this.pizzas.addAll(List.of(pizzas));
    }

    public Long getNumber() {
        return number;
    }

    public Integer getStatus() {
        return status;
    }

    public Double getBillTotal() {
        return pizzas.stream()
                .mapToDouble(pizza -> pizza.getPrice() * pizza.getQuantity())
                .reduce(0, Double::sum);
    }

    public String getOrderFormattedTotal() {
        return NumberFormat.getCurrencyInstance().format(getBillTotal());
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public Client getClient() {
        return client;
    }

    public Long getOrderDuration() {
        LocalDateTime lastTime = end;
        if (lastTime == null) {
            lastTime = LocalDateTime.now();
        }
        Duration duration = Duration.between(start, lastTime);
        return Math.abs(duration.toMinutes());
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public void setStatus(Integer newOrderStatus) {
        if (isValidStatus(newOrderStatus)) {
            throw new InvalidStatusCodeException();
        }
        this.status = newOrderStatus;
    }

    private boolean isValidStatus(Integer newOrderStatus) {
        return Arrays.stream(VALID_STATUS).noneMatch(status -> Objects.equals(status, newOrderStatus));
    }

    @Override
    public String toString() {
        return "Order{" +
                "number=" + number +
                ", status=" + status +
                ", start=" + start +
                ", end=" + end +
                ", client=" + client +
                ", pizzas=" + pizzas +
                '}';
    }
}
