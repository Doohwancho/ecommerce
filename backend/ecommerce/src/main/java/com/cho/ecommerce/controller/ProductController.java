package com.cho.ecommerce.controller;

import com.cho.ecommerce.entity.Product;
import com.cho.ecommerce.errorHandler.exception.InternalServerErrorException;
import com.cho.ecommerce.errorHandler.exception.NoSuchElementFoundException;
import com.cho.ecommerce.service.ProductService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j(topic = "PRODUCT_CONTROLLER")
@RestController
@RequestMapping("/v1/product")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @ApiResponses(
            value = {
                    @ApiResponse(code = 404, message = "unable to complete the request because product was not found.", response = NoSuchElementFoundException.class), //, response = MediaDataProductResponseV2.class -> 특정 response class 만들어서 반환도 가능하다.
                    @ApiResponse(code = 500, message = "Internal Server Error", response = InternalServerErrorException.class)
            }
    )
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable String id){
        return productService.getProduct(id);
    }
}