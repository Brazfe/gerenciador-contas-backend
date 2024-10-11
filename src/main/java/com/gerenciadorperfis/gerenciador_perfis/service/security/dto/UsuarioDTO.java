package com.gerenciadorperfis.gerenciador_perfis.service.security.dto;

import java.io.Serializable;

public class UsuarioDTO implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String usuario;

	private String senha; 
	
	private String email;
	
	private String nome;
	
	private String perfil;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
	

}
