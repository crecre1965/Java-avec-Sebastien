package com.bnpparibas.itg.mylibraries.libraries.exposition;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnsecuredController {
    @GetMapping("/unsecured/toto")
    public String toto(){
        return "Hello World";
    }
}
