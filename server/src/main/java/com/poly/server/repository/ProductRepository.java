package com.poly.server.repository;

import com.poly.server.entity.Product;
import com.poly.server.response.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("""
            SELECT 
                new com.poly.server.response.ProductResponse
                (p.id, p.productName, p.price, 
                p.category.categoryCode, p.category.categoryName)
            FROM Product p JOIN Category c on p.category.id=c.id
            """)
    List<ProductResponse> hienThiDanhSach();

    @Query("""
            SELECT 
                new com.poly.server.response.ProductResponse
                (p.id, p.productName, p.price, 
                p.category.categoryCode, p.category.categoryName)
            FROM Product p JOIN Category c on p.category.id=c.id
            WHERE p.id = ?1
            """)
    ProductResponse detailProduct(Long id);

    @Query("""
            SELECT 
                new com.poly.server.response.ProductResponse
                (p.id, p.productName, p.price, 
                p.category.categoryCode, p.category.categoryName)
            FROM Product p JOIN Category c on p.category.id=c.id
            """)
    Page<ProductResponse> phanTrang(Pageable pageable);

}
