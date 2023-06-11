package edu.hue.jk.model;

import lombok.Data;

@Data
public class Order {
    private String id;
    private Double money;
    private String receiverAddress;
    private String receiverName;
    private String receiverPhone;
    private Integer paystate;
    private String ordertime;
    private Integer userId;
}
