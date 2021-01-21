package com.bnpparibas.itg.mylibraries.libraries.exposition;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class SecuredController {
    @GetMapping("/user")
    public String user(){
        String name=SecurityContextHolder.getContext().getAuthentication().getName();
        Collection<? extends GrantedAuthority > authorities =SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        return "Hello " + name + "/ " + authorities;
    }
    @GetMapping("/admin")
    @Secured("ROLE_ADMIN")
    public String admin(){

        return "Hello admin";
    }
}
