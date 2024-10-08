package com.cho.ecommerce.domain.product.entity;

import com.cho.ecommerce.domain.product.domain.DiscountType;
import com.cho.ecommerce.domain.product.domain.converter.DiscountTypeConverter;
import com.cho.ecommerce.global.config.database.DatabaseConstants;
import java.time.OffsetDateTime;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "DISCOUNT")
@Getter
@Setter
public class DiscountEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "discount_seq")
//    @SequenceGenerator(
//        name = "discount_seq",
//        sequenceName = "DISCOUNT_SEQ",
//        allocationSize = 1000
//    )
    @Column(name = "DISCOUNT_ID")
    private Long discountId;
    
    @NotNull(message = "Discount type is required")
    @Column(name = "DISCOUNT_TYPE", length = DatabaseConstants.DISCOUNT_TYPE_SIZE, nullable = false)
//    @Enumerated(EnumType.STRING) //before) ERROR - db query후 결과값을 DiscountEntity에 넣는 과정에서 DiscountType의 value들이 type error가 생기는 현상 발견! 아래 방법으로 대체
    @Convert(converter = DiscountTypeConverter.class) //after
    private DiscountType discountType;
    
    @Min(0)
    @Column(name = "DISCOUNT_VALUE", length = DatabaseConstants.DISCOUNT_VALUE_SIZE, nullable = false, precision = 10, scale = 2)
    private Double discountValue;
    
    @NotNull(message = "Start date is required")
    @Column(name = "START_DATE", nullable = false)
    private OffsetDateTime startDate; //TODO - OffsetDateTime으로 h2 db에 저장되지 않고 LocalDateTime으로 저장되는 문제가 있다.
    
    @NotNull(message = "End date is required")
    @Column(name = "END_DATE", nullable = false)
    private OffsetDateTime endDate;
    
    @NotNull(message = "Product item is required")
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ITEM_ID") //PRODUCT_ITEM_ID column이 대신 생성된다.
    private ProductItemEntity productItem;
    
    
    public ProductItemEntity getProductItem() {
        return productItem;
    }
    
    public void setProductItem(ProductItemEntity productItem) {
        if (this.productItem != null && this.productItem.getDiscounts().contains(this)) {
            this.productItem.getDiscounts().remove(this);
        }
        this.productItem = productItem;
        if (productItem != null && !productItem.getDiscounts().contains(this)) {
            productItem.getDiscounts().add(this);
        }
    }
    
    public DiscountType getDiscountType() {
        return discountType;
    }
    
    public void setDiscountType(DiscountType discountType) {
        this.discountType = discountType;
    }
}