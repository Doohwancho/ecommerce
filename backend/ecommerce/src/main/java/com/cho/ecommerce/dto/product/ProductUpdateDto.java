package com.cho.ecommerce.dto.product;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.Max;

@Tag(name = "DTO" , description = "Data Transfer Object")
@Schema(name = "제품 업데이트 객체", description = "제품 업데이트시 사용")
@Getter
@Setter
public class ProductUpdateDto {

    @NonNull
    @Max(20)
    private String name;

    @NonNull
    @Max(500)
    private String description;

    @NonNull
    @Max(20)
    private String sku;
}
