package com.poly.server.controller;

import com.poly.server.request.CategoryRequest;
import com.poly.server.response.CategoryResponse;
import com.poly.server.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/category-management")
@CrossOrigin(origins = "*") // Cho FE quyen truy cap moi api trong CategoryController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // API convention: https://blog.vietnamlab.vn/restful-api-convention/
    // localhost:8080/api/category-management => hien thi
    @GetMapping
    public List<CategoryResponse> hienThiDanhSachCategory() {
        return categoryService.getAll1();
    }

    // path variable
    @GetMapping("/detail/{id}")
    public CategoryResponse detail(@PathVariable("id") Integer id) {
        return categoryService.getOne(id);
    }

    // request param => dau ?
    @GetMapping("/detail")
    public CategoryResponse detail1(@RequestParam("id1") Integer id) {
        return categoryService.getOne(id);
    }

    // co the dung path variable hoac dung request param nhu tren
    @DeleteMapping("remove/{id}")
    public void remove(@PathVariable("id") Integer id) {
        categoryService.removeCate(id);
    }

    // phan trang:
    // pageSize: so luong phan tu tren 1 trang (de bai quy dinh)
    // pageNo: vi tri trang thu mat
    // 10 phan tu:
    // pageSize = 3
    // => ? trang
    // trang dau tien: 3 phan tu dau => pageNo = 0
    // trang t2: 3 pt tiep
    // trang t3: 3 phan tu
    // trang t4: 1 pt
    // pageNo: bat dau 0

    // defaultValue => truyen gia tri mac dinh cho request param
    @GetMapping("paging")
    public List<CategoryResponse> phanTrang(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                            @RequestParam(value = "pageSize", defaultValue = "2") Integer pageSize) {
        return categoryService.phanTrangCate(pageNo, pageSize).getContent();
    }

    @PostMapping("add")
    public void add(@Valid @RequestBody CategoryRequest req) {
        categoryService.addCate(req);
    }

    // authen & author:
    // 401 => tai khoan k ton tai trong he
    // 403 => tai khoan k co quyen
}
