package com.cho.ecommerce.dto.category;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

//@Tag(name = "DTO" , description = "Data Transfer Object")
//@Schema(name = "2. Category Get Root DTO", description = "카테고리 root node query시 사용")
@Getter
@Setter
public class CategoryGetRootDTO {
//    @Schema(description = "아이디", example = "1")
    private Long id;

//    @Schema(description = "부모 카테고리 아이디", example = "0")
    private Long parentId;

//    @Schema(description = "카테고리 이름", example = "0")
    private String name;

//    @Schema(description = "하위 카테고리 리스트")
    private List<CategoryGetRootDTO> subCategories;

    public CategoryGetRootDTO(Long id, Long parentId, String name) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
    }
}
