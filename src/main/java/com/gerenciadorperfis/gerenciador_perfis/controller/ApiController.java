package com.gerenciadorperfis.gerenciador_perfis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
	
    @GetMapping("/api/data")
    public String getData() {
        return "Dados recebidos com sucesso!";
    }

}
