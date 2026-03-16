package com.poly.server.service;

import com.poly.server.entity.Category;
import com.poly.server.entity.Product;
import com.poly.server.repository.CategoryRepository;
import com.poly.server.repository.ProductRepository;
import com.poly.server.request.ProductRequest;
import com.poly.server.response.ProductResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<ProductResponse> getAll() {
        return productRepository.hienThiDanhSach();
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public ProductResponse detail(Long id) {
        return productRepository.detailProduct(id);
    }

    public Page<ProductResponse> phanTrangProduct(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return productRepository.phanTrang(pageable);
    }

    public void addProduct(ProductRequest req){
        Product p = new Product();
        BeanUtils.copyProperties(req,p); // SAO CHEP
        // Xu ly khoa ngoai
        Category cate = categoryRepository.findById(Math.toIntExact(p.getId())).orElse(null);
        p.setCategory(cate);
        // goi ham save
        productRepository.save(p);
    }

}
