package com.cho.ecommerce.service;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductServiceTest {

//    @InjectMocks
//    ProductService productService;
//
//    @Mock
//    ProductRepository productRepository;
//
//    @Test
//    @DisplayName("상품 생성")
//    public void createTest() {
//        // given
//        ProductRegisterDto productRegisterDto = ProductRegisterDto.builder()
//                .name("product name")
//                .description("product description")
//                .sku("product sku")
//                .build();
//
//        // when
//        productService.saveProduct(productRegisterDto);
//
//        // then
//        verify(productRepository).save((ProductRegisterDto) any());
//    }

//    @Test
//    @DisplayName("상품 모두 불러오기")
//    public void findAllTest() {
//        // given
//        List<Product> products = new ArrayList<>();
//        products.add(createProduct(createUser()));
//        products.add(createProduct(createUser()));
//        given(productRepository.findAll()).willReturn(products);
//
//
//        // when
//        List<ProductFindAllResponseDto> result = productService.findAll();
//
//
//        // then
//        assertThat(result.size()).isEqualTo(products.size());
//    }
//
//    @Test
//    @DisplayName("상품 상세 정보 확인")
//    public void findTest() {
//        // given
//        Long id = 1L;
//        Product product = createProduct(createUser());
//
//        given(productRepository.findById(id)).willReturn(Optional.of(product));
//
//        // when
//        ProductFindResponseDto result = productService.find(id);
//
//        // then
//        assertThat(product.getName()).isEqualTo(result.getName());
//    }
//
//
//    @Test
//    @DisplayName("상품 수정")
//    public void editTest() {
//        // given
//        Long id = 1L;
//        ProductEditRequestDto req = new ProductEditRequestDto("상품명 수정", "설명 수정", 100, 100);
//        Member member = createUser();
//        Product product = createProduct(member);
//        given(productRepository.findById(id)).willReturn(Optional.of(product));
//
//        // when
//        productService.edit(id, req, member);
//
//        // then
//        assertThat(product.getName()).isEqualTo(req.getName());
//    }
//
//
//    @Test
//    @DisplayName("상품 삭제")
//    public void deleteTest() {
//        // given
//        Long id = 1L;
//        Member member = createUser();
//        Product product = createProduct(member);
//        given(productRepository.findById(id)).willReturn(Optional.of(product));
//
//        // when
//        productService.delete(id, member);
//
//        // then
//        verify(productRepository).delete(product);
//    }

//    @MockBean
//    private ProductService productService;
//
//    @Test
//    public void checkIfProductServiceIsNotNull(){
//        initMocks(this);
//        assertThat(productService).isNotNull();
//    }

//    //TODO - ID가 auto-generated 인 경우, getById 테스트 어떻게 할지 고민해보기.
//    @Test
//    @Disabled
//    @DisplayName("상품 id로 조회")
//    public void testGetProduct() {
//        createProduct();
//
//        RestAssured
//                .given()
//                .when()
//                    .get("/v1/product/"+PRODUCT_ID)
//                .then()
//                    .log().all()
//                    .statusCode(HttpStatus.OK.value());
//    }

//    @Test
//    @DisplayName("findBoard 서비스 테스트")
//    void findProductByIdTest() {
//        // given
//        int id = 1;
//        Board board = createBoard();
//
//        given(boardRepository.findById(anyInt())).willReturn(Optional.of(board));
//
//        // when
//        BoardResponseDto result = boardService.findBoard(id);
//
//        // then
//        assertThat(result.getTitle()).isEqualTo("title");
//    }

//    @Test
//    @DisplayName("상품 정보 업데이트")
//    public void testUpdateProduct() {
////        createProduct();
////
////        Map<String, Object> product = new HashMap<>();
////        product.put("name", "updatedTest");
////        product.put("price", 2000);
////        product.put("description", "updatedTest");
////
////        RestAssured
////                .given()
////                    .contentType(ContentType.JSON)
////                    .accept(ContentType.JSON)
////                    .body(product)
////                .when()
////                    .put("/v1/products/1000000", 1)
////                .then()
////                    .log().all()
////                    .statusCode(HttpStatus.OK.value())
////                    .body("name", equalTo("updatedTest"))
////                    .body("price", equalTo(2000))
////                    .body("description", equalTo("updatedTest"));
//
//        ExtractableResponse<Response> create = createProduct();
//
//        Map<String, Object> params = new HashMap<>();
//        params.put("name", "updatedTest");
//        params.put("price", 2000);
//        params.put("description", "updatedTest");
//
//        ExtractableResponse<Response> updateStudy = RestAssured
//                .given().log().all()
//                .body(params)
//                .contentType(MediaType.APPLICATION_JSON_VALUE)
//                .when()
//                .put(create.header("Location"))
//                .then().log().all()
//                .extract();
//
//        assertThat(updateStudy.statusCode()).isEqualTo(HttpStatus.NO_CONTENT.value());
//    }
//
//    @Test
//    @DisplayName("상품 삭제")
//    public void testDeleteProduct() {
////        createProduct();
////
////        RestAssured
////                .given()
////                .when()
////                    .delete("/v1/products/1000000", 1)
////                .then()
////                    .log().all()
////                    .statusCode(HttpStatus.OK.value());
//        ExtractableResponse<Response> create = createProduct();
//
//        ExtractableResponse<Response> deleteProduct = RestAssured
//                .when()
//                    .delete(create.header("Location"))
//                .then().log().all()
//                    .extract();
//
//        assertThat(deleteProduct.statusCode()).isEqualTo(HttpStatus.NO_CONTENT.value());
//    }




    /***************************************************
     * helper functions
     */

//    @Rollback
//    private ExtractableResponse<Response> createProduct() {
//        Map<String, Object> params = new HashMap<>();
//        params.put("id", 1);
//        params.put("name", "test");
//        params.put("description", "test");
//        params.put("sku", "test");
//
//        return RestAssured.given().log().all()
//                .body(params)
//                .contentType(MediaType.APPLICATION_JSON_VALUE)
//                .when()
//                .post("/v1/product")
//                .then().log().body()
//                .extract();
//    }
}
