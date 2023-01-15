package com.cho.ecommerce.dto.category;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Tag(name = "DTO" , description = "Data Transfer Object")
@Schema(name = "카테고리 업데이트 객체", description = "카테고리 업데이트시 사용")
@Getter
public class CategoryUpdateDTO {

    @Schema(description = "parent category id")
    @NotNull
    @Min(0)
    private Long parentId;

    @Schema(description = "category name")
    @NotNull
    @NotEmpty
    private String name;
}
