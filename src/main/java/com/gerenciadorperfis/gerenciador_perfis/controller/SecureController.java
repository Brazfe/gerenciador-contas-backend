package com.gerenciadorperfis.gerenciador_perfis.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/security")
public class SecureController {

	@GetMapping("/secure-endpoint")
	public ResponseEntity<Map<String, String>> secureEndpoint() {
	    Map<String, String> response = new HashMap<>();
	    response.put("message", "Acesso concedido ao endpoint seguro!");
	    return ResponseEntity.ok(response);
	}

}
