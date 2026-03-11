package com.poly.server.controller;

import com.poly.server.response.CategoryResponse;
import com.poly.server.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("api/category/hien-thi")
    public List<CategoryResponse>hienThiDanhSachCategory(){
        return categoryService.getAll1();
    }

}
