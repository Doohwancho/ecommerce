package com.cho.ecommerce.service;

import com.cho.ecommerce.dto.category.CategoryDTO;
import com.cho.ecommerce.entity.Category;
import com.cho.ecommerce.repository.CategoryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import javax.transaction.Transactional;
import java.util.List;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@SpringBootTest
@Transactional
public class CategoryTest {

    @InjectMocks
    private CategoryService categoryService;

    @Mock
    private CategoryRepository categoryRepository;

    @Test
    @DisplayName("하위 카테고리들이 담긴 root 카테고리 생성")
    public void createRootCategoryThatContainsAllSubCategories() throws Exception {
        //given
        List<Category> categoryEntities = createCategoryEntities();
        given(categoryRepository.findAll())
                .willReturn(categoryEntities);

        //when
        CategoryDTO categoryRoot = categoryService.createCategoryRoot();

        //then
        verify(categoryRepository, atLeastOnce()).findAll();
        // root
        assertThat(categoryRoot.getSubCategories().size(), is(2));
        // sub1
        assertThat(categoryRoot.getSubCategories().get(0).getSubCategories().size(), is(2));
        // sub2
        assertThat(categoryRoot.getSubCategories().get(1).getSubCategories().size(), is(2));
    }

    private List<Category> createCategoryEntities() {
        Category sub1 = new Category("SUB1", 0l);
        Category sub2 = new Category("SUB2", 0l);
        Category sub11 = new Category("SUB1-1", 1l);
        Category sub12 = new Category("SUB1-2", 1l);
        Category sub21 = new Category("SUB2-1", 2l);
        Category sub22 = new Category("SUB2-2", 2l);

        ReflectionTestUtils.setField(sub1, "id", 1l);
        ReflectionTestUtils.setField(sub2, "id", 2l);
        ReflectionTestUtils.setField(sub11, "id", 3l);
        ReflectionTestUtils.setField(sub12, "id", 4l);
        ReflectionTestUtils.setField(sub21, "id", 5l);
        ReflectionTestUtils.setField(sub22, "id", 6l);

        List<Category> categoryEntities = List.of(
                sub1, sub2, sub11, sub12, sub21, sub22
        );
        return categoryEntities;
    }
}
