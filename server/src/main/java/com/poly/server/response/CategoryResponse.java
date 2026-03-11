package com.poly.server.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CategoryResponse {
    // MODLE MAPPING:
    // REQUEST HOAC RESPONSE: TEN BIEN PHAI TRUNG VOI ENTIY
    // Noi dung response => de bai
    private String categoryCode;

    private String categoryName;

}
