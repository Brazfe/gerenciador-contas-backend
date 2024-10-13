package com.gerenciadorperfis.gerenciador_perfis.service.security.dto;

import java.io.Serializable;

public class PerfilDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	
	private String tipoPerfil;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTipoPerfil() {
		return tipoPerfil;
	}

	public void setTipoPerfil(String tipoPerfil) {
		this.tipoPerfil = tipoPerfil;
	}
	
	
	

}
