package com.cho.ecommerce.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Tag(name = "VO" , description = "Value Object")
@Schema(name = "사용자" , description = "사용자 정보")
@Entity
@Getter
public class User {

    @Schema(description = "id", example = "1") //defaultValue, allowableValues, required, access, readOnly, writeOnly, deprecated, hidden, example, maxLength
    @Id
    private String id;

    @Email
    @Pattern(regexp = ".+@.+\\..+", message = "Please provide a valid email address")
    @Schema(description = "이메일", nullable = false, example = "abc@jiniworld.me")
    private String email;

    @Pattern(regexp = "[1-2]")
    @Schema(description = "성별", defaultValue = "1", allowableValues = {"1", "2"})
    private String sex;

    @DateTimeFormat(pattern = "yyMMdd")
    @Schema(description = "생년월일", example = "yyMMdd", maxLength = 6)
    private String birthDate;

    @Schema(description = "전화번호")
    private String phoneNumber;

    @Schema(description = "비밀번호")
    private String password;
}
