package edu.hue.jk.model;

import lombok.Data;

@Data
public class OrderItem {
    private String orderId;
    private String productId;
    private Integer buynum;
}
