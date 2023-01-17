package com.cho.ecommerce.dto.product;

import com.cho.ecommerce.entity.Category;
import com.cho.ecommerce.entity.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/*
    ---
    memo regarding validation

    1. @Min, @Max for validating Integer, @Size(min=, max=) for validating String

 */


@Tag(name = "DTO" , description = "Data Transfer Object")
@Schema(name = "2. Product Register DTO", description = "제품 등록시 사용")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRegisterDTO  {

    @NonNull
    @Size(max=20)
    @JsonProperty("name")
    private String name;

    @NonNull
    @Size(max=500)
    @JsonProperty("description")
    private String description;

    @NonNull
    @Size(max=20)
    @JsonProperty("sku")
    private String sku;

    @Schema(description = "재고수량", example = "1")
    @Column(name = "QUANTITY_IN_STOCK", nullable = false)
    @Min(0)
    @JsonProperty("quantity_in_stock")
    private int quantityInStock;

    @Schema(description = "가격", example = "10000")
    @Column(name = "PRICE", nullable = false)
    @Min(0)
    @JsonProperty("price")
    private int price;

    @Schema(description = "카테고리", example = "10000")
    @Column(name = "id", nullable = false)
    @JsonProperty("category")
    private Category category;

    public Product toEntity() {
        return Product.builder()
                .name(this.name)
                .description(this.description)
                .sku(this.sku)
                .quantityInStock(this.quantityInStock)
                .price(this.price)
                .category(this.category)
                .build();
    }
}
