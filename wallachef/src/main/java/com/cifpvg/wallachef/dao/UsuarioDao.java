package com.cifpvg.wallachef.dao;

import java.util.Optional;

import com.cifpvg.wallachef.modelo.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, Integer> {

	Optional<Usuario> findByNombreAndPassword(String nombre, String password);

}