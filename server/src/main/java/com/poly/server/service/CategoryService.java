package com.poly.server.service;

import com.poly.server.entity.Category;
import com.poly.server.repository.CategoryRepository;
import com.poly.server.response.CategoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // hien thi repository => Category
    // list CategoryResponse
    // mapping Category <=> CategoryResponse
    // C1: Mapping trong class service => viet them ham (dai)
    // C2: Xu ly o repository

    public List<CategoryResponse>getAll(){
        List<Category>listCate = categoryRepository.findAll();
        List<CategoryResponse>listCateReponse = new ArrayList<>();
        for (Category c: listCate){
            listCateReponse.add(mapingEntityToResponse(c));
        }
        return listCateReponse;
    }

    public List<CategoryResponse>getAll1(){
        return categoryRepository.hienThiDanhSachResponse();
    }
    // Mapping
    private CategoryResponse mapingEntityToResponse(Category c){
        return CategoryResponse.builder()
                .categoryCode(c.getCategoryCode())
                .categoryName(c.getCategoryName())
                .build();
    }
}
