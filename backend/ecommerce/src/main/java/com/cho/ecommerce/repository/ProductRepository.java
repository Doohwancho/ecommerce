package com.cho.ecommerce.repository;

import com.cho.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
//    Optional<Product> save(Product product);
    Optional<Product> findById(long id);
    //TODO - delete vs deleteById -> deleteById is more efficient
    List<Product> findAllByCategoryId(long id);
}