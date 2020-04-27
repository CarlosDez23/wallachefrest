package com.cifpvg.wallachef.controlador;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/")
public class UsuarioController {

    @RequestMapping(value="hola", method=RequestMethod.GET)
    public String prueba() {
        return "Hola prueba correcta";
    }
    

}