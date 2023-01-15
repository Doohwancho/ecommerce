package com.cho.ecommerce.service;

import com.cho.ecommerce.dto.category.CategoryGetRootDTO;
import com.cho.ecommerce.dto.category.CategoryRegisterDTO;
import com.cho.ecommerce.dto.category.CategoryUpdateDTO;
import com.cho.ecommerce.entity.Category;
import com.cho.ecommerce.exception.NoSuchCategoryFoundException;
import com.cho.ecommerce.exception.i18n.I18Constants;
import com.cho.ecommerce.repository.CategoryRepository;
import com.cho.ecommerce.utils.MessageUtils;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final MessageUtils messageUtils;

    @Cacheable("categories") //수행시간이 오래걸리는 무거운 DB IO 작업 Cache 처리
    public CategoryGetRootDTO createCategoryRoot() {
        Map<Long, List<CategoryGetRootDTO>> groupingByParent = categoryRepository.findAll()
                .stream()
                .map(category -> new CategoryGetRootDTO(category.getId(), category.getParentId(), category.getName()))
                .collect(groupingBy(category -> category.getParentId()));

        CategoryGetRootDTO rootCategoryDto = new CategoryGetRootDTO(0l, null, "ROOT");
        addSubCategories(rootCategoryDto, groupingByParent);

        return rootCategoryDto;
    }

    private void addSubCategories(CategoryGetRootDTO parent, Map<Long, List<CategoryGetRootDTO>> groupingByParentId) {
        // 1. parent의 키로 subCategories를 찾는다.
        List<CategoryGetRootDTO> subCategories = groupingByParentId.get(parent.getId());

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

    private Category findCategory (Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new NoSuchCategoryFoundException(messageUtils.getLocalMessage(I18Constants.NO_CATEGORY_FOUND.getKey(), id)));
    }

    @Transactional
    public Category saveCategory(CategoryRegisterDTO categorySaveDTO) {
        categoryRepository.findById(categorySaveDTO.getParentId()).orElseThrow(() -> new NoSuchCategoryFoundException(messageUtils.getLocalMessage(I18Constants.NO_CATEGORY_FOUND.getKey(), categorySaveDTO.getParentId())));
        return categoryRepository.save(CategoryRegisterDTO.toEntity(categorySaveDTO));
    }

    @Transactional
    public Category updateCategory(Long id, CategoryUpdateDTO category) {
        return categoryRepository.findById(id)
                .map(c -> {
                    c.setId(id);
                    c.setParentId(category.getParentId());
                    c.setName(category.getName());
                    return categoryRepository.save(c);
                })
                .orElseThrow(() -> new NoSuchCategoryFoundException(messageUtils.getLocalMessage(I18Constants.NO_CATEGORY_FOUND.getKey(), id)));
    }

    @Transactional
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
