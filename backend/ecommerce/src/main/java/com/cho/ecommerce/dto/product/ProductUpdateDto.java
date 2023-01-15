package com.cho.ecommerce.dto.product;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.Size;

@Tag(name = "DTO" , description = "Data Transfer Object")
@Schema(name = "제품 업데이트 객체", description = "제품 업데이트시 사용")
@Getter
@Setter //TODO - setter랑 builder중 setter 제거
@Builder
public class ProductUpdateDTO {

    @NonNull
    @Size(max=20)
    private String name;

    @NonNull
    @Size(max=500)
    private String description;

    @NonNull
    @Size(max=20)
    private String sku;
}
