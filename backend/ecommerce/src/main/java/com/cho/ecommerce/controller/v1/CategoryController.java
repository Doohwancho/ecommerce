package com.cho.ecommerce.controller.v1;

import com.cho.ecommerce.entity.Product;
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
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "카테고리", description = "category API")
@Slf4j(topic = "CATEGORY_CONTROLLER")
@RestController
@RequestMapping("/v1/categories")
@AllArgsConstructor
public class CategoryController {

    private final ProductService productService;
//    private final CategoryService categoryService;

    @Operation(summary="get products by its category", responses = {
            @ApiResponse(responseCode = "200", description = "OK.", content = @Content(schema = @Schema(type = "array", implementation = Product.class), mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "404", description = "unable to complete the request because product was not found.", content = @Content(schema = @Schema(implementation = NoSuchElementFoundException.class), mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = InternalServerErrorException.class), mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    @GetMapping("/{categoryId}")
    public List<Product> getProductsByItsCategory(@Parameter(name = "categoryId", description = "category id", in = ParameterIn.PATH) @PathVariable Long categoryId) {
        return productService.findAllByCategoryId(categoryId);
    }

//    @PostMapping("/categories")
//    @ResponseBody
//    public Long saveCategory (CategoryDTO categoryDTO) {
//        return categoryService.saveCategory(categoryDTO);
//    }

//    @GetMapping("/{branch}")
//    @ResponseBody
//    public CategoryDTO getCategoryByBranch (@PathVariable String branch) {
//        return categoryService.getCategoryByBranch(branch);
//    }

//    @PutMapping ("/{branch}/{code}")
//    @ResponseBody
//    public Long updateCategory (@PathVariable (name = "branch") @NotBlank String branch,
//                                @PathVariable (name = "code") @NotBlank String code,
//                                CategoryDTO categoryDTO) {
//        return categoryService.updateCategory(branch, code,categoryDTO);
//    }

//    @DeleteMapping ("/{branch}/{code}")
//    @ResponseBody
//    public void deleteCategory (@PathVariable (name = "branch") @NotBlank String branch,
//                                @PathVariable (name = "code") @NotBlank String code) {
//        categoryService.deleteCategory(branch, code);
//    }
}
