package com.cho.ecommerce.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Tag(name = "VO" , description = "Value Object")
@Schema(name = "PRODUCT", description = "제품 정보")
@Entity
@Builder
@Getter
@Setter //TODO - updateProduct 때문에 차용했지만, DTO를 사용했기 때문에 빼기
@NoArgsConstructor
@AllArgsConstructor
//@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Product extends BaseEntity{

    @Schema(description = "id", example = "1") //defaultValue, allowableValues, required, access, readOnly, writeOnly, deprecated, hidden, example, maxLength
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Schema(description = "이름", example = "냉장고")
    @Column(name = "NAME", length = 20, nullable = false)
    private String name;

    @Column(name = "DESCRIPTION",length = 500, nullable = false)
    private String description;

    @Column(name = "SKU",length = 20, nullable = false)
    private String sku;

    @Schema(description = "재고수량", example = "1")
    @Column(name = "QUANTITY_IN_STOCK", nullable = false)
    @Min(0)
    private int quantity_in_stock;

    @Schema(description = "가격", example = "10000")
    @Column(name = "PRICE", nullable = false)
    @Min(0)
    private int price;

    @Schema(description = "카테고리")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false) //foreign key named "category_id". should be lowercase
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Category category;
}
