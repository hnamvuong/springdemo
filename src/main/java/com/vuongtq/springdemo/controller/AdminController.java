package com.vuongtq.springdemo.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/admin")
@RolesAllowed("ADMIN")
public class AdminController {

    @GetMapping("/vip")
    public String zoneVip() {
        return "Vip Zone";
    }

    @GetMapping("/normal")
    public String zoneNormal() {
        return "Normal Zone";
    }

    @GetMapping("/info")
    public Authentication getInfoUser() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
