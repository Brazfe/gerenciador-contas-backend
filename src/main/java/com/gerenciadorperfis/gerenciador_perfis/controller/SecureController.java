package com.gerenciadorperfis.gerenciador_perfis.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciadorperfis.gerenciador_perfis.model.Usuario;
import com.gerenciadorperfis.gerenciador_perfis.service.UsuarioService;

@RestController
@RequestMapping("/api/security")
@CrossOrigin(origins = "http://localhost:4200") 
public class SecureController {
	
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/secure-endpoint")
	public ResponseEntity<Map<String, String>> secureEndpoint(@RequestParam(value = "username") String username) {
	    Map<String, String> response = new HashMap<>();
	    

        Optional<Usuario> usuario = usuarioService.buscaUsuarioPorLogin(username);
        if(usuario.isPresent()) {
            response.put("tipoPerfil", usuario.get().getPerfil().getTipoPerfil()); 
        }
        
        if(username.equals("admin")) {
            response.put("tipoPerfil", "Administrador"); 
        }
        response.put("username", username);

        response.put("message", "Acesso concedido ao endpoint seguro!");
	    
	    return ResponseEntity.ok(response);
	}
	

}
