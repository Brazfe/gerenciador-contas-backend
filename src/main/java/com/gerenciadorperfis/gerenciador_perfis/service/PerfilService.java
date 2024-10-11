package com.gerenciadorperfis.gerenciador_perfis.service;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciadorperfis.gerenciador_perfis.model.Perfil;
import com.gerenciadorperfis.gerenciador_perfis.repository.PerfilRepository;

@Service
public class PerfilService {
	
	@Autowired
	private PerfilRepository repositorio;
	
    @PostConstruct
    public void init() {
        if (repositorio.count() == 0) {
            Perfil admin = new Perfil();
            admin.setTipoPerfil("Administrador");
            Perfil consumidor = new Perfil();
            consumidor.setTipoPerfil("Consumidor");
            repositorio.saveAll(Arrays.asList(admin, consumidor));
        }
    }

    public List<Perfil> getPerfis() {
        return repositorio.findAll();
    }
    
    public Perfil buscarPerfilPorId(Long id) {
        return repositorio.findById(id).orElse(null); 
    }

}
