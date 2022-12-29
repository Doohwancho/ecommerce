package com.cho.ecommerce.controller.v1;

import com.cho.ecommerce.dto.product.ProductRegisterDto;
import com.cho.ecommerce.dto.product.ProductUpdateDto;
import com.cho.ecommerce.entity.Product;
import com.cho.ecommerce.exception.BadRequestException;
import com.cho.ecommerce.exception.DatabaseException;
import com.cho.ecommerce.exception.InternalServerErrorException;
import com.cho.ecommerce.exception.NoSuchElementFoundException;
import com.cho.ecommerce.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Tag(name = "상품", description = "product API")
@Slf4j(topic = "PRODUCT_CONTROLLER")
@RestController
@RequestMapping("/v1/product")
@AllArgsConstructor
public class ProductController {

//    private final Logger logger = org.slf4j.LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;

    @Operation(summary="get a product by its id", responses = {
        @ApiResponse(responseCode = "200", description = "OK.", content = @Content(schema = @Schema(implementation = Product.class), mediaType = MediaType.APPLICATION_JSON_VALUE)),
        @ApiResponse(responseCode = "404", description = "unable to complete the request because product was not found.", content = @Content(schema = @Schema(implementation = NoSuchElementFoundException.class), mediaType = MediaType.APPLICATION_JSON_VALUE)),
        @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = InternalServerErrorException.class), mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    @GetMapping("/{id}")
    public Product getProduct(@Parameter(name = "id", description = "user id", in = ParameterIn.PATH) @PathVariable long id){
        return productService.getProduct(id);
    }

    @Operation(summary="create a new product", responses = {
            @ApiResponse(responseCode = "200", description = "OK.", content = @Content(schema = @Schema(implementation = Product.class), mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "400", description = "unable to complete the request because bad request.", content = @Content(schema = @Schema(implementation = BadRequestException.class), mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "500", description = "Database Exception", content = @Content(schema = @Schema(implementation = DatabaseException.class), mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product registerProduct(@RequestBody ProductRegisterDto product){
        return productService.saveProduct(product);
    }

    @Operation(summary="update an existing product by its id", responses = {
            @ApiResponse(responseCode = "200", description = "OK.", content = @Content(schema = @Schema(implementation = Product.class), mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "400", description = "unable to complete the request because bad request.", content = @Content(schema = @Schema(implementation = BadRequestException.class), mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "404", description = "unable to complete the request because product was not found.", content = @Content(schema = @Schema(implementation = NoSuchElementFoundException.class), mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = InternalServerErrorException.class), mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    @PutMapping("/{id}")
    public Product updateProduct(@Parameter(name = "id", description = "user id", in = ParameterIn.PATH) @PathVariable String id, @RequestBody ProductUpdateDto product){
        return productService.updateProduct(id, product);
    }

    @Operation(summary="delete an existing product by its id", responses = {
            @ApiResponse(responseCode = "200", description = "OK."),
            @ApiResponse(responseCode = "404", description = "unable to complete the request because product was not found.", content = @Content(schema = @Schema(implementation = NoSuchElementFoundException.class), mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = InternalServerErrorException.class), mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    @DeleteMapping("/{id}")
    public void deleteProduct(@Parameter(name = "id", description = "user id", in = ParameterIn.PATH) @PathVariable String id){
        productService.deleteProduct(id);
    }
}