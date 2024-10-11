package com.gerenciadorperfis.gerenciador_perfis.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciadorperfis.gerenciador_perfis.model.Perfil;
import com.gerenciadorperfis.gerenciador_perfis.model.Usuario;
import com.gerenciadorperfis.gerenciador_perfis.service.PerfilService;
import com.gerenciadorperfis.gerenciador_perfis.service.UsuarioService;
import com.gerenciadorperfis.gerenciador_perfis.service.security.dto.UsuarioDTO;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "http://localhost:4200") 
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	@Autowired
	private PerfilService perfilService;
	

	@PostMapping
	public ResponseEntity<UsuarioDTO> salvarUsuario(@RequestBody Usuario usuario) {

		Perfil perfil = perfilService.buscarPerfilPorId(usuario.getPerfil().getId());
		if (perfil == null) {
			return ResponseEntity.badRequest().body(null);
		}
		usuario.setPerfil(perfil);
		Usuario usuarioSalvo = service.salvarUsuario(usuario);
		
		UsuarioDTO dto = extracted(usuario, perfil, usuarioSalvo);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(dto);

	}

	private UsuarioDTO extracted(Usuario usuario, Perfil perfil, Usuario usuarioSalvo) {
		UsuarioDTO dto = new UsuarioDTO();
		dto.setEmail(usuarioSalvo.getEmail());
		dto.setId(usuarioSalvo.getId());
		dto.setNome(usuarioSalvo.getNome());
		dto.setPerfil(perfil.getTipoPerfil());
		dto.setUsuario(usuario.getUsuario());
		return dto;
	}

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> buscaUsuarios() {
        List<Usuario> users = service.buscaUsuarios();
        List<UsuarioDTO> dtos = new ArrayList<UsuarioDTO>();
        UsuarioDTO  dto = null;
        extracted(users, dtos);
        return ResponseEntity.ok(dtos);
    }

	private void extracted(List<Usuario> users, List<UsuarioDTO> dtos) {
		UsuarioDTO dto;
		for (Usuario obj : users) {
        	dto = new UsuarioDTO();
        	dto.setEmail(obj.getEmail());
        	dto.setNome(obj.getNome());
        	dto.setUsuario(obj.getUsuario());
    		Perfil perfil = perfilService.buscarPerfilPorId(obj.getPerfil().getId());
        	dto.setPerfil(perfil.getTipoPerfil());
        	dtos.add(dto);
        }
	}
	
}
