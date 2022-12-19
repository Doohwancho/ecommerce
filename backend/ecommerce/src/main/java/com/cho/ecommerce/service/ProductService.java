package com.cho.ecommerce.service;

import com.cho.ecommerce.commons.I18Constants;
import com.cho.ecommerce.entity.Product;
import com.cho.ecommerce.errorHandler.exception.NoSuchElementFoundException;
import com.cho.ecommerce.utils.MessageUtils;
import com.cho.ecommerce.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    private final MessageUtils messageUtils;

    public Product getProduct(String id) {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementFoundException(messageUtils.getLocalMessage(I18Constants.NO_ITEM_FOUND.getKey(), id)));
    }
}