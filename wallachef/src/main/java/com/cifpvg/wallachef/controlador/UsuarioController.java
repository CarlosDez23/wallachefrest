package com.cifpvg.wallachef.controlador;

import java.util.Optional;

import com.cifpvg.wallachef.dao.UsuarioDao;
import com.cifpvg.wallachef.modelo.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
     * Método para insertar un usuario. Lo utilizaremos para registrar un usuairo
     * @param usuario
     * @return ResponseEntity --> El usuario insertado si ha podido insertarlo con éxito
     */
    @RequestMapping(value="nuevo", method=RequestMethod.POST)
    public ResponseEntity<Usuario> insertarUsuario(@RequestBody Usuario usuario) {
        Usuario u = daoUsuario.save(usuario);
        return ResponseEntity.ok(u);
    }

    /**
     * Método para comprobar si existe un usuario con un nombre y una contraseña.
     * Lo utilizaremos para la parte del login
     * @param nombre
     * @param password
     * @return ResponseEntity --> Retornará el usuario si existe y si no código de error (204)
     */
    @RequestMapping(value="login/{nombre}/{password}", method=RequestMethod.GET)
    public ResponseEntity<Usuario> comprobarLogin(@PathVariable("nombre") String nombre, @PathVariable("password") String password) {
        Optional<Usuario> optionalUsuario = daoUsuario.findByNombreAndPassword(nombre,password);
        if (optionalUsuario.isPresent()){
            return ResponseEntity.ok(optionalUsuario.get());
        }else{
            return ResponseEntity.noContent().build();
        }
    }
}