package com.cho.ecommerce.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.Setter;

@Tag(name = "DTO" , description = "Data Transfer Object")
@Schema(name = "제품 정보", description = "아이디, 이름")
@Getter
@Setter
public class ProductRegisterDto {

    @Schema(description = "아이디", example = "1")
    private String id;

    @Schema(description = "이름", example = "냉장고")
    private String name;
}
