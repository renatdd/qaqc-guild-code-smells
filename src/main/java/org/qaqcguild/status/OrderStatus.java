package org.qaqcguild.status;

import org.qaqcguild.Order;

import java.time.Duration;
import java.time.LocalDateTime;

public abstract class OrderStatus {

    protected Order order;
    private final LocalDateTime start;
    private LocalDateTime end;

    public OrderStatus(Order order) {
        this.order = order;
        this.start = LocalDateTime.now();
    }

    public Long getDuration() {
        LocalDateTime lastTime = end;
        if (lastTime == null) {
            lastTime = LocalDateTime.now();
        }
        Duration duration = Duration.between(start, lastTime);
        return Math.abs(duration.toMinutes());
    }

    public void finishStatus() {
        this.end = LocalDateTime.now();
        setNext();
    }

    public abstract void setNext();
}
