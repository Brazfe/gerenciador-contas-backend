package com.gerenciadorperfis.gerenciador_perfis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciadorperfis.gerenciador_perfis.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Usuario findByUsuario(String usuario);

}
