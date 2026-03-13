package com.poly.server.repository;

import com.poly.server.entity.Category;
import com.poly.server.response.CategoryResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query("""
            SELECT new com.poly.server.response.CategoryResponse(c.categoryCode,c.categoryName)
            FROM Category c
            """)
    List<CategoryResponse> hienThiDanhSachResponse();

    @Query("""
            SELECT new com.poly.server.response.CategoryResponse(c.categoryCode,c.categoryName)
            FROM Category c
            WHERE c.id = ?1
            """)
    CategoryResponse detail(Integer id);

    @Query("""
           SELECT new com.poly.server.response.CategoryResponse(c.categoryCode,c.categoryName)
           FROM Category c
           """)
    Page<CategoryResponse> phanTrang(Pageable pageable);

}
