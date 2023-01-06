package com.cho.ecommerce.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public class BaseEntity {

    @Column(name = "CREATED_DATE", nullable = false)
    @CreatedDate
    private LocalDateTime createdDate;

    @Column(name = "LAST_MODIFIED_DATE", nullable = false)
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
}