package com.cho.ecommerce.unit_test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.cho.ecommerce.Application;
import com.cho.ecommerce.domain.product.domain.Product;
import com.cho.ecommerce.domain.product.service.ProductService;
import com.cho.ecommerce.global.config.fakedata.FakeDataGenerator;
import java.util.List;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@TestInstance(Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = {Application.class})
@ActiveProfiles("test")
@Tag("unit") //to run, type "mvn test -Dgroups=integration"
public class ProductUnitTest {
    
    @Autowired
    private ProductService productService;
    @Autowired
    private FakeDataGenerator dataGenerator;
    
    @Test
    public void GetProductDetailDTOsByIdUnitTest() {
        // Given
        Long productId = 1L;
        
        final Integer numberOfFakeCategories = 10;
        final Integer numberOfFakeOptions = 3;
        final Integer numberOfFakeOptionsVariations = 3;
        final Integer numberOfFakeProducts = 10;
        final Integer numberOfFakeProductItems = 3;
        
        dataGenerator.generateFakeCategoryAndOptions(numberOfFakeCategories, numberOfFakeOptions, numberOfFakeOptionsVariations);
        dataGenerator.generateFake100Products(numberOfFakeProducts, numberOfFakeCategories, numberOfFakeProductItems );
        
        // When
        List<Product> products = productService.getProductDetailDTOsById(productId);
        Product product = products.get(0); //여러개의 products중에 임의로 하나만 골라서 테스트한다.
        
        // Then
        assertNotNull(products);
        assertEquals(products.size(), numberOfFakeProductItems);
        assertNotNull(product.getProductId());
        assertNotNull(product.getName());
        assertNotNull(product.getDescription());
        assertNotNull(product.getRating());
        assertNotNull(product.getRatingCount());
        assertNotNull(product.getQuantity());
        assertNotNull(product.getPrice());
        assertNotNull(product.getDiscounts());
        assertNotNull(product.getCategoryId());
        assertNotNull(product.getCategoryCode());
        assertNotNull(product.getCategoryName());
        assertNotNull(product.getOptionName());
        assertNotNull(product.getOptionVariationName());
    }
}