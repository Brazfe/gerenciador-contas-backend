package com.gerenciadorperfis.gerenciador_perfis.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "TB_PERFIL")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="TIPO_PERFIL")
    private String tipoPerfil;

    @OneToMany(mappedBy = "perfil")
    private Set<Usuario> usuarios;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoPerfil() {
		return tipoPerfil;
	}

	public void setTipoPerfil(String tipoPerfil) {
		this.tipoPerfil = tipoPerfil;
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

    
    
}
