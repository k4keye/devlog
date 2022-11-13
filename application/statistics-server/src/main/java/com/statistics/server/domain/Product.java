package com.statistics.server.domain;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "TB_PRODUCT")
@ToString
public class Product extends BaseTimeEntity   implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column
    private String name;

    @Column
    private Long price;

    @Column(name = "stock_quantity")
    private Long stockQuantity;


    public Product(String name, Long price, Long stockQuantity) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public void downStockQuantity(Long downCount){
        long tempStockQuantity = this.stockQuantity - downCount;
        if(tempStockQuantity < 0 ) throw new IllegalStateException("재고 이탈");
        this.stockQuantity = tempStockQuantity;
    }

    public void upStockQuantity(Long upCount){
        this.stockQuantity += upCount;
    }

}
