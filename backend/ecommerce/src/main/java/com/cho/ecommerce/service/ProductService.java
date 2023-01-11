package com.cho.ecommerce.service;

import com.cho.ecommerce.dto.product.ProductRegisterDTO;
import com.cho.ecommerce.dto.product.ProductUpdateDTO;
import com.cho.ecommerce.entity.Product;
import com.cho.ecommerce.exception.NoSuchElementFoundException;
import com.cho.ecommerce.exception.i18n.I18Constants;
import com.cho.ecommerce.repository.CategoryRepository;
import com.cho.ecommerce.repository.ProductRepository;
import com.cho.ecommerce.utils.MessageUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final MessageUtils messageUtils;

    @Transactional
    public Product saveProduct(ProductRegisterDTO productDto) {
        //TODO - exception handling of save() in functional style
//        return repository.save(product).orElseThrow(() -> new DatabaseException(messageUtils.getLocalMessage(I18Constants.NO_ITEM_FOUND.getKey(), product.toString())));

        Product product = Product.builder()
                .name(productDto.getName())
                .description(productDto.getDescription())
                .sku(productDto.getSku())
                .category(productDto.getCategory())
                .price(productDto.getPrice())
                .quantity_in_stock(productDto.getQuantity_in_stock())
                .build();

        return productRepository.save(product);
    }

    public Product getProduct(long id) {
        return productRepository.findById(id).orElseThrow(() -> new NoSuchElementFoundException(messageUtils.getLocalMessage(I18Constants.NO_ITEM_FOUND.getKey(), id)));
    }

    @Transactional
    public Product updateProduct(String id, ProductUpdateDTO product) {
        return productRepository.findById(id)
                .map(p -> {
                    p.setId(Long.valueOf(id));
                    p.setName(product.getName());
                    p.setDescription(product.getDescription());
                    p.setSku(product.getSku());
                    return productRepository.save(p);
                })
                .orElseThrow(() -> new NoSuchElementFoundException(messageUtils.getLocalMessage(I18Constants.NO_ITEM_FOUND.getKey(), id)));
    }

    @Transactional
    public void deleteProduct(String id) {
        productRepository.findById(id).orElseThrow(() -> new NoSuchElementFoundException(messageUtils.getLocalMessage(I18Constants.NO_ITEM_FOUND.getKey(), id)));
        productRepository.deleteById(id);
    }

//    public List<Product> findAllByCategoryId(long id) {
//        return productRepository.findAllByCategoryId(id);
//    }
}