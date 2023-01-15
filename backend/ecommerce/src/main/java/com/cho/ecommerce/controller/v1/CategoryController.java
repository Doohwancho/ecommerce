package com.cho.ecommerce.controller.v1;

import com.cho.ecommerce.dto.category.CategoryRegisterDTO;
import com.cho.ecommerce.dto.category.CategoryUpdateDTO;
import com.cho.ecommerce.entity.Category;
import com.cho.ecommerce.entity.Product;
import com.cho.ecommerce.exception.BadRequestException;
import com.cho.ecommerce.exception.InternalServerErrorException;
import com.cho.ecommerce.exception.NoSuchCategoryFoundException;
import com.cho.ecommerce.exception.NoSuchElementFoundException;
import com.cho.ecommerce.service.CategoryService;
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

import javax.validation.Valid;
import java.util.List;

@Tag(name = "카테고리", description = "category API")
@Slf4j(topic = "CATEGORY_CONTROLLER")
@RestController
@RequestMapping("/v1/categories")
@AllArgsConstructor
public class CategoryController {

    private final ProductService productService;
    private final CategoryService categoryService;

    @Operation(summary="get products by its category", responses = {
            @ApiResponse(responseCode = "200", description = "OK.", content = @Content(schema = @Schema(type = "array", implementation = Product.class), mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "404", description = "unable to complete the request because product was not found.", content = @Content(schema = @Schema(implementation = NoSuchElementFoundException.class), mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = InternalServerErrorException.class), mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    @GetMapping("/{categoryId}")
    public List<Product> getProductsByItsCategory(@Parameter(name = "categoryId", description = "category id", in = ParameterIn.PATH) @PathVariable Long categoryId) {
        return productService.findAllByCategoryId(categoryId);
    }

    @Operation(summary="save category", responses = {
            @ApiResponse(responseCode = "200", description = "OK.", content = @Content(schema = @Schema(implementation = Category.class), mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "404", description = "unable to complete the request because product was not found.", content = @Content(schema = @Schema(implementation = Category.class), mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = InternalServerErrorException.class), mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Category saveCategory (
            @Parameter(
                    name = "CategoryRegisterDTO",
                    description = "category DTO for register",
                    required = true,
                    schema = @Schema(implementation = CategoryRegisterDTO.class, example =
                            "{\n" +
                                "\"parentId\": \"1\",\n" +
                                "\"name\": \"men_shirts\",\n" +
                            "}"
                    )
            )
            @Valid  @RequestBody CategoryRegisterDTO categorySaveDTO) {
        return categoryService.saveCategory(categorySaveDTO);
    }

    @Operation(summary="update an existing category by its id", responses = {
            @ApiResponse(responseCode = "200", description = "OK.", content = @Content(schema = @Schema(implementation = Category.class), mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "400", description = "unable to complete the request because bad request.", content = @Content(schema = @Schema(implementation = BadRequestException.class), mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "404", description = "unable to complete the request because category was not found.", content = @Content(schema = @Schema(implementation = NoSuchCategoryFoundException.class), mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = InternalServerErrorException.class), mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    @PutMapping("/{categoryId}")
    public Category updateCategory(
            @Parameter(name = "id", description = "category id", in = ParameterIn.PATH) @PathVariable Long categoryId,
            @Parameter(
                    name = "CategoryUpdateDTO",
                    description = "category DTO for update",
                    required = true,
                    schema = @Schema(implementation = CategoryUpdateDTO.class, example =
                            "{\n" +
                                "\"name\": \"product1\",\n" +
                                "\"description\": \"product1 description\",\n" +
                                "\"sku\": \"product1 sku\",\n" +
                            "}"
                    )
            )
            @Valid @RequestBody CategoryUpdateDTO category){
        return categoryService.updateCategory(categoryId, category);
    }

    @DeleteMapping ("/{categoryId}")
    public void deleteCategory (@Parameter(name = "id", description = "category id", in = ParameterIn.PATH) @PathVariable Long categoryId) {
        categoryService.deleteCategory(categoryId);
    }
}
