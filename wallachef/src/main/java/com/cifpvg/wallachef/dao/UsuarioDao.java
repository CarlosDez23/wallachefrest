package com.cifpvg.wallachef.dao;

import com.cifpvg.wallachef.modelo.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, Integer> {

}