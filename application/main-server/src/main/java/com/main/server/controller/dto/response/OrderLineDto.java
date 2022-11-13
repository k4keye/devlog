package com.main.server.controller.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderLineDto {
     private Long productNo;
     private String productName;
     private Long productPrice;
     private Long orderCount;
     private Long totalPrice;
}
