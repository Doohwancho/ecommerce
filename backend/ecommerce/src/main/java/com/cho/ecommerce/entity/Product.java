package com.cho.ecommerce.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import javax.persistence.*;

@Tag(name = "VO" , description = "Value Object")
@Schema(name = "Product", description = "아이디, 이름")
@Entity
@Getter
public class Product {

    @Schema(description = "id", example = "1") //defaultValue, allowableValues, required, access, readOnly, writeOnly, deprecated, hidden, example, maxLength
    @Id
    private String id;

    @Schema(description = "이름", example = "냉장고")
    private String name;
}
