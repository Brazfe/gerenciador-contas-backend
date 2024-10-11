package com.gerenciadorperfis.gerenciador_perfis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciadorperfis.gerenciador_perfis.model.Usuario;
import com.gerenciadorperfis.gerenciador_perfis.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	
    public Usuario salvarUsuario(Usuario usuario) {
        return repository.save(usuario);
    }

    public List<Usuario> buscaUsuarios() {
        return repository.findAll();
    }

}
