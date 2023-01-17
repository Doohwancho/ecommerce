package com.cho.ecommerce.dto.category;

import com.cho.ecommerce.entity.Category;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.Min;

@Tag(name = "DTO" , description = "Data Transfer Object")
@Schema(name = "2. Category Register DTO", description = "카테고리 등록시 사용")
@Getter
@Setter
@AllArgsConstructor
public class CategoryRegisterDTO {

    @Schema(description = "부모 카테고리 아이디", example = "0")
    @NonNull
    @Min(0)
    @JsonProperty("parentId")
    private Long parentId;

    @Schema(description = "카테고리 이름", example = "1")
    @NonNull
    @JsonProperty("name")
    private String name;

    public static Category toEntity(CategoryRegisterDTO categorySaveDTO) {
        return Category.builder()
                .parentId(categorySaveDTO.getParentId())
                .name(categorySaveDTO.getName())
                .build();
    }
}
