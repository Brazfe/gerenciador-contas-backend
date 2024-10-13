package com.gerenciadorperfis.gerenciador_perfis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciadorperfis.gerenciador_perfis.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
		
	Optional<Usuario> findByUsuario(String usuario);


}
