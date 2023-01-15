package com.cho.ecommerce.dto.category;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryGetRootDTO {
    private Long id;
    private Long parentId;
    private String name;
    private List<CategoryGetRootDTO> subCategories;

    public CategoryGetRootDTO(Long id, Long parentId, String name) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
    }
}
