package edu.ProyectoConjunto.edu.ProyectoConjunto.servicios;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class usuarioImplementacion {

    @Autowired
    private usuarioRepositorio usuarioRepository;

    // Endpoint para manejar el login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        // Busca el usuario por correo en la base de datos
        Optional<entidadUsuario> usuarioOptional = usuarioRepository.findByCorreoUsuario(loginRequest.getEmail());

        // Si no se encuentra el usuario
        if (!usuarioOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario no encontrado");
        }

        entidadUsuario usuario = usuarioOptional.get();

        // Verificar la contraseña
        if (!usuario.getContraseniaUsuario().equals(loginRequest.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
        }

        // Verificar si es administrador
        if (!usuario.getEsAdmin()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No tienes permisos de administrador");
        }

        // Si todo es correcto, responde con éxito
        return ResponseEntity.ok().body("Login exitoso, bienvenido " + usuario.getNombreUsuario());
    }
}

class LoginRequest {
    private String email;
    private String password;

    // Getters y setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

