package com.cho.ecommerce.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "제품 정보", description = "아이디, 이름")
@Getter
@Setter
public class ProductRegisterDto {

    @ApiModelProperty(value = "아이디", example = "1", required = true)
    private String id;

    @ApiModelProperty(value = "이름", example = "냉장고", required = true)
    private String name;
}
