package com.cifpvg.wallachef.controlador;

import com.cifpvg.wallachef.dao.UsuarioDao;
import com.cifpvg.wallachef.modelo.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    //Inyección de dependencias para los usuarios
    @Autowired
    private UsuarioDao daoUsuario;

    @RequestMapping(value="hola", method=RequestMethod.GET)
    public String prueba() {
        return "Hola prueba correcta";
    }

    /**
     * Método para insertar un usuario
     * @param param
     * @return
     */
    @RequestMapping(value="nuevo", method=RequestMethod.POST)
    public ResponseEntity<Usuario> insertarUsuario(@RequestBody Usuario usuario) {
        Usuario u = daoUsuario.save(usuario);
        return ResponseEntity.ok(u);
    }
    
    

}