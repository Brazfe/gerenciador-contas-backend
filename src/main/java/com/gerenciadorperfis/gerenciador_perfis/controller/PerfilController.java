package com.gerenciadorperfis.gerenciador_perfis.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciadorperfis.gerenciador_perfis.model.Perfil;
import com.gerenciadorperfis.gerenciador_perfis.service.PerfilService;
import com.gerenciadorperfis.gerenciador_perfis.service.security.dto.PerfilDTO;

@RestController
@RequestMapping("/api/perfis")
public class PerfilController {

	@Autowired
	private PerfilService service;
	
	
    @GetMapping("/perfis")
    public ResponseEntity<List<PerfilDTO>> listarPerfis() {
    	List<PerfilDTO> dtos = new ArrayList<PerfilDTO>();
    	extracted(dtos);
        return ResponseEntity.ok(dtos);
    }


	private void extracted(List<PerfilDTO> dtos) {
		PerfilDTO dto;
		for(Perfil obj: service.getPerfis()) {
    		dto = new PerfilDTO();
    		dto.setId(obj.getId().toString());
    		dto.setTipoPerfil(obj.getTipoPerfil());
    		dtos.add(dto);
    	}
	}
}
