package com.keycloak.keycloakspringadaptor.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(path = "spring_boot_app")
public class Controller {

    @GetMapping(path = "read")
    @PreAuthorize("hasAnyAuthority('READ')")
//    @Secured("hasAuthority('RREEEFV')")
    public String read() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        authentication.getAuthorities().forEach(System.out::println);
        return "this role can read";
    }

    @GetMapping(path = "write")
    @PreAuthorize("hasAnyAuthority('WRITE')")
    public String write() {
        return "this role can write";
    }

    @GetMapping(path = "modify")
    @PreAuthorize("hasAnyAuthority('MODIFY')")
    public String modify() {
        return "this role can modify";
    }
}
