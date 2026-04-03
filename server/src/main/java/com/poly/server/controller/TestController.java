package com.poly.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("api/public")
    public String publicAPI() {
        return "Tat ca cac quyen deu truy cap duoc";
    }

    @GetMapping("api/admin")
    public String adminAPI() {
        return "Role admin truy cap";
    }

    @GetMapping("api/nhan-vien")
    public String nhanVienAPI() {
        return "Role nhan vien truy cap";
    }
    // He thong gom 2 quyen la: admin & nhan vien.
    // Nguoi dung login voi username & password
    // Neu chua logic => bat cu ai co the truy cap vap duong dan: api/public
    // Neu login vs quyen admin => Admin truy cap duoc tat ca
    // Neu login vs quyen nhan vien => Nhan vien truy cap vao /api/nhan-vien
}
