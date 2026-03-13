package com.poly.server.service;

import com.poly.server.entity.Category;
import com.poly.server.repository.CategoryRepository;
import com.poly.server.request.CategoryRequest;
import com.poly.server.response.CategoryResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    public List<CategoryResponse> getAll() {
        List<Category> listCate = categoryRepository.findAll();
        List<CategoryResponse> listCateReponse = new ArrayList<>();
        for (Category c : listCate) {
            listCateReponse.add(mapingEntityToResponse(c));
        }
        return listCateReponse;
    }

    public List<CategoryResponse> getAll1() {
        return categoryRepository.hienThiDanhSachResponse();
    }

    public CategoryResponse getOne(Integer id) {
        // findby id => entity
        // can response
        return categoryRepository.detail(id);
    }

    public void removeCate(Integer id){
        categoryRepository.deleteById(id);
    }

    public Page<CategoryResponse>phanTrangCate(Integer pageNo, Integer pageSize){
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        return categoryRepository.phanTrang(pageable);
    }

    public void addCate(CategoryRequest req){
        Category cate = new Category();
        // Dung BeanUtil de mapping doi tuong req => cate
        // Ten trong req phai trung vs ten trong entity
        BeanUtils.copyProperties(req,cate);
        categoryRepository.save(cate);
    }

    // Mapping
    private CategoryResponse mapingEntityToResponse(Category c) {
        return CategoryResponse.builder()
                .categoryCode(c.getCategoryCode())
                .categoryName(c.getCategoryName())
                .build();
    }
}
