package com.cho.ecommerce.controller.v1;

import com.cho.ecommerce.entity.Product;
import com.cho.ecommerce.errorHandler.exception.InternalServerErrorException;
import com.cho.ecommerce.errorHandler.exception.NoSuchElementFoundException;
import com.cho.ecommerce.service.ProductService;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;

@Tag(name = "상품", description = "product API")
@Slf4j(topic = "PRODUCT_CONTROLLER")
@RestController
@RequestMapping("/api/v1/product")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @Operation(summary="get a product by its id", responses = {
        @ApiResponse(responseCode = "200", description = "OK.", content = @Content(schema = @Schema(implementation = Product.class), mediaType = MediaType.APPLICATION_JSON_VALUE)),
        @ApiResponse(responseCode = "404", description = "unable to complete the request because product was not found.", content = @Content(schema = @Schema(implementation = NoSuchElementFoundException.class), mediaType = MediaType.APPLICATION_JSON_VALUE)),
        @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = InternalServerErrorException.class), mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    @GetMapping("/{id}")
    public Product getProduct(@Parameter(name = "id", description = "user 의 id", in = ParameterIn.PATH) @PathVariable String id){
        return productService.getProduct(id);
    }
}