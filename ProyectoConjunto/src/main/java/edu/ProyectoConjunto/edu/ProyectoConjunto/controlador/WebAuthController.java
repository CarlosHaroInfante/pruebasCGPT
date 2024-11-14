package edu.ProyectoConjunto.edu.ProyectoConjunto.controlador;

import edu.ProyectoConjunto.edu.ProyectoConjunto.dtos.usuarioDto;
import edu.ProyectoConjunto.edu.ProyectoConjunto.servicios.usuarioImplementacion;
import edu.ProyectoConjunto.edu.ProyectoConjunto.servicios.usuarioRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/web/auth")
public class WebAuthController {

    private  usuarioImplementacion usuario;
    
    @Autowired
    private usuarioRepositorio usu;
    
    

    @Value("${api.url}")
    private String apiUrl;

    public WebAuthController(usuarioImplementacion usuarioServicio) {
        this.usuario = usuarioServicio;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody usuarioDto usuarioDto) {
        boolean authenticated = usu.(usuarioDto.getCorreoUsuario(), usuarioDto.getContraseniaUsuario());

        if (authenticated) {
            return ResponseEntity.ok("{\"success\": true}");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"success\": false}");
        }
    }
}
