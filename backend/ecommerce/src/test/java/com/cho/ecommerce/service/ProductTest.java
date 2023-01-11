package com.cho.ecommerce.service;

import com.cho.ecommerce.dto.product.ProductRegisterDTO;
import com.cho.ecommerce.dto.product.ProductUpdateDTO;
import com.cho.ecommerce.entity.Category;
import com.cho.ecommerce.entity.Product;
import com.cho.ecommerce.repository.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductTest {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ProductTest.class);

    @InjectMocks //create a new instance of ProductRepository and inject the mock collaborator instance into ProductService.
    ProductService productService;

    @Mock
    ProductRepository productRepository;

    @Test
    public void checkIfProductServiceIsNotNull(){
        MockitoAnnotations.openMocks(this);
        assertThat(productService).isNotNull();
    }

    @Test
    @DisplayName("상품 생성")
    public void shouldCreateProduct() {
        // given
        Category category = new Category().builder()
                .id(1L)
                .parentId(0L)
                .name("men")
                .build();

        ProductRegisterDTO productRegisterDto = ProductRegisterDTO.builder()
                .name("product name")
                .description("product description")
                .sku("product sku")
                .category(category)
                .price(10000)
                .quantity_in_stock(100)
                .build();

        // when
        productService.saveProduct(productRegisterDto);

        // then
        verify(productRepository).save(any());
    }

    @Test
    @DisplayName("상품 상세 정보 확인")
    public void shouldFindProductById() {
        // given
        Long id = 1L;

        Product product = Product.builder()
                .id(id)
                .name("product name")
                .description("product description")
                .sku("product sku")
                .build();

        given(productRepository.findById(id)).willReturn(Optional.of(product));

        // when
        Product result = productService.getProduct(id);

        // then
        assertThat(product.getName()).isEqualTo(result.getName());
    }

    @Test
    @DisplayName("상품 수정")
    public void shouldUpdateProduct() {
        //given
        Long id = 1L;

        Product product = Product.builder()
                .id(id)
                .name("original name")
                .description("original description")
                .sku("original sku")
                .build();

        ProductUpdateDTO updatedProduct = ProductUpdateDTO.builder()
                .name("updated name")
                .description("updated description")
                .sku("updated sku")
                .build();

        when(productRepository.findById(any(String.class))).thenReturn(Optional.ofNullable(product));
        when(productRepository.save(any())).thenReturn(product);

        //when
        Product result = productService.updateProduct(String.valueOf(id), updatedProduct);

        //then
        verify(productRepository).save(any());
        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo(updatedProduct.getName());
        assertThat(result.getDescription()).isEqualTo(updatedProduct.getDescription());
        assertThat(result.getSku()).isEqualTo(updatedProduct.getSku());
    }


    @Test
    @DisplayName("상품 삭제")
    public void shouldDeleteProduct() {
        //given
        Long id = 1L;

        Product product = Product.builder()
                .id(id)
                .name("original name")
                .description("original description")
                .sku("original sku")
                .build();

        when(productRepository.findById(any(String.class))).thenReturn(Optional.ofNullable(product));

        //when
        productService.deleteProduct(String.valueOf(id));

        //then
        verify(productRepository).deleteById(any());
    }
}
