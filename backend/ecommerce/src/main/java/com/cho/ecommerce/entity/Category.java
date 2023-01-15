package com.cho.ecommerce.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Tag(name = "VO" , description = "Value Object")
@Schema(name = "CATEGORY", description = "카테고리")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Schema(description = "category id", example = "1") //defaultValue, allowableValues, required, access, readOnly, writeOnly, deprecated, hidden, example, maxLength
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "parent category id")
    @Column(name = "PARENT_ID")
    private Long parentId;

    @Schema(description = "category name")
    @Column(name = "NAME")
    @NotNull
    @NotEmpty
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private final Set<Product> products = new HashSet<>();

    //Q. what is mappedBy?
    //A. mappedBy indicates that the entity in this side is the inverse of the relationship,
    // and the owner resides in the "other" entity.
    // This also means that you can access the other table from the class which you've annotated with "mappedBy"


    public Category(String name, Long parentId) {
        this.name = name;
        this.parentId = parentId;
    }

    public Category toEntity() {
        return Category.builder()
                .name(name)
                .parentId(parentId)
                .build();
    }
}
