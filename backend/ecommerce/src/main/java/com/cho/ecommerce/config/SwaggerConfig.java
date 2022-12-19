package com.cho.ecommerce.config;


import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.AlternateTypeRules;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


@EnableSwagger2
@Configuration
public class SwaggerConfig implements WebMvcConfigurer {

    private String version = "v1";
    private String title = "Ecommerce API " + version;

    @Bean
    public Docket api() {
        List<ResponseMessage> responseMessages = new ArrayList<ResponseMessage>();
        responseMessages.add(new ResponseMessageBuilder().code(200).message("OK").build());
        responseMessages.add(new ResponseMessageBuilder().code(500).message("서버 문제 발생").responseModel(new ModelRef("Error")).build());
        responseMessages.add(new ResponseMessageBuilder().code(404).message("페이지를 찾을 수 없습니다.").build());

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()).groupName(version).select()
                .apis(RequestHandlerSelectors.basePackage("com.cho.ecommerce.controller"))
                .paths(postPaths()).build()
                .useDefaultResponseMessages(false) // responseMessages 설정 적용
                .globalResponseMessage(RequestMethod.GET,responseMessages);
    }

    private Predicate<String> postPaths() {
      return PathSelectors.any(); // 모든 경로를 api 문서로 만들경우
//      return or(regex("/admin/.*"), regex("/user/.*"));  // 일부 경로를 api 문서로 만들 경우
//        return regex("/admin/.*"); //하나의 경로를 api문서로 만드는 경우
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title(title)
                .description("<h3>Ecommerce API Reference for Developers</h3>")
                .contact(new Contact("LAMASTORE", "https://LAMASTORE.com", "LAMASTORE@gmail.com"))
                .license("MIT License")
                .licenseUrl("https://github.com/Doohwancho/ecommerce")
                .version("1.0").build();
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry
                .addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
