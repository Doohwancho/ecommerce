package com.cho.ecommerce.dto.product;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import javax.validation.constraints.Max;

@Tag(name = "DTO" , description = "Data Transfer Object")
@Schema(name = "제품 등록 객체", description = "제품 등록시 사용")
@Getter
@Builder
public class ProductRegisterDto {

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
