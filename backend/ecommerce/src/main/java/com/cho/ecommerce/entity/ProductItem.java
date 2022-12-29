package com.cho.ecommerce.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;

import javax.persistence.*;

@Tag(name = "VO_ITEM" , description = "Value Object Items")
@Schema(name = "PRODUCT_ITEM", description = "개별 제품 정보")
@Entity
@Getter
public class ProductItem {

    @Schema(description = "id", example = "1") //defaultValue, allowableValues, required, access, readOnly, writeOnly, deprecated, hidden, example, maxLength
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    private long product_id;

    @Schema(description = "이름", example = "냉장고")
    @Column(name = "NAME", length = 20, nullable = false)
    private String name;

    @Schema(description = "재고수량", example = "1")
    @Column(name = "QUANTITY_IN_STOCK", nullable = false)
    private int quantity_in_stock;

    @Schema(description = "가격", example = "10000")
    @Column(name = "PRICE", nullable = false)
    private int price;

}
