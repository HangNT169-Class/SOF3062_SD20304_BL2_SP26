package com.poly.server.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryRequest {
    // liet ke ra cac truong can add/update
    // Validate => request
    @NotBlank(message = "Category code khong de trong")
    private String categoryCode;

    @NotBlank(message = "Category name khong de trong")
    private String categoryName;

}
