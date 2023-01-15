package com.cho.ecommerce.service;

import com.cho.ecommerce.dto.category.CategoryDTO;
import com.cho.ecommerce.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Cacheable("categories") //수행시간이 오래걸리는 무거운 DB IO 작업 Cache 처리
    public CategoryDTO createCategoryRoot() {
        Map<Long, List<CategoryDTO>> groupingByParent = categoryRepository.findAll()
                .stream()
                .map(category -> new CategoryDTO(category.getId(), category.getParentId(), category.getName()))
                .collect(groupingBy(category -> category.getParentId()));

        CategoryDTO rootCategoryDto = new CategoryDTO(0l, null, "ROOT");
        addSubCategories(rootCategoryDto, groupingByParent);

        return rootCategoryDto;
    }

    private void addSubCategories(CategoryDTO parent, Map<Long, List<CategoryDTO>> groupingByParentId) {
        // 1. parent의 키로 subCategories를 찾는다.
        List<CategoryDTO> subCategories = groupingByParentId.get(parent.getId());

        // 종료 조건
        if (subCategories == null)
            return;

        // 2. sub categories 셋팅
        parent.setSubCategories(subCategories);

        // 3. 재귀적으로 subcategories들에 대해서도 수행
        subCategories.stream()
            .forEach(s -> {
                addSubCategories(s, groupingByParentId);
            });
    }
}
