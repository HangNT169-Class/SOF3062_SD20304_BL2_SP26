package com.poly.server.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductRequest {
    // Ten trong request trung vs entity
    private String productName;

    private String productCode;

    private Float price;

    private Integer categoryId; // Rieng khoa ngoai khong can dat ten giong

}
