package com.cho.ecommerce.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Tag(name = "VO" , description = "Value Object")
@Schema(name = "PRODUCT", description = "제품 정보")
@Entity
@Getter
@Setter //TODO - updateProduct 때문에 차용했지만, DTO를 사용해서 빼기
@Builder
public class Product {

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


//    @ElementCollection
//    @CollectionTable(name = "Product_Images", joinColumns = @JoinColumn(name = "product_id", nullable = false))
//    @Column(name = "IMAGE_ID")
//    @Size(min = 1)
//    @NotNull
//    private List<String> images;

//    @ManyToOne(targetEntity = Seller.class)
//    @JoinColumn(name = "seller_id", referencedColumnName = "id", nullable = false)
//    @NotNull
//    private Seller seller;


//    @ManyToMany
//    @Column(name = "CATEGORY_ID")
//    @JoinTable(name = "product_category",
//            joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
//    @Size(min = 1)
//    @NotNull
//    private Set<Category> fallIntoCategories;
}
