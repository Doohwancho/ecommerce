package com.cho.ecommerce.service;

import com.cho.ecommerce.dto.product.ProductRegisterDto;
import com.cho.ecommerce.dto.product.ProductUpdateDto;
import com.cho.ecommerce.entity.Product;
import com.cho.ecommerce.exception.I18.I18Constants;
import com.cho.ecommerce.exception.NoSuchElementFoundException;
import com.cho.ecommerce.repository.ProductRepository;
import com.cho.ecommerce.utils.MessageUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    private final MessageUtils messageUtils;

    @Transactional
    public Product saveProduct(ProductRegisterDto productDto) {
        //TODO - exception handling of save() in functional style
//        return repository.save(product).orElseThrow(() -> new DatabaseException(messageUtils.getLocalMessage(I18Constants.NO_ITEM_FOUND.getKey(), product.toString())));


        Product product = Product.builder()
                .name(productDto.getName())
                .description(productDto.getDescription())
                .sku(productDto.getSku())
                .build();

        return repository.save(product);
    }

    public Product getProduct(long id) {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementFoundException(messageUtils.getLocalMessage(I18Constants.NO_ITEM_FOUND.getKey(), id)));
    }

    @Transactional
        public Product updateProduct(String id, ProductUpdateDto product) {
        return repository.findById(id)
                .map(p -> {
                    p.setId(Long.valueOf(id));
                    p.setName(product.getName());
                    p.setDescription(product.getDescription());
                    p.setSku(product.getSku());
                    return repository.save(p);
                })
                .orElseThrow(() -> new NoSuchElementFoundException(messageUtils.getLocalMessage(I18Constants.NO_ITEM_FOUND.getKey(), id)));
    }

    @Transactional
    public void deleteProduct(String id) {
        repository.findById(id).orElseThrow(() -> new NoSuchElementFoundException(messageUtils.getLocalMessage(I18Constants.NO_ITEM_FOUND.getKey(), id)));
        repository.deleteById(id);
    }
}