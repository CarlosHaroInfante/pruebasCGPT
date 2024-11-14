package edu.ProyectoConjunto.edu.ProyectoConjunto.servicios;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Clase donde se encuentra la representación del objeto usuario
 * @author charnte - 08/11/24
 */
@Entity
public class entidadUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario; 

    private String nombreUsuario;
    private String apellidoUsuario;
    private String correoUsuario;
    private String contraseniaUsuario;
    private String dniUsuario;
    private Boolean esAdmin;
    private byte[] imagenUsuario; // Imagen como array de bytes
    private String direccion;
    private String alias;
    private String clubPerteneciente;

    // Constructor vacío (opcional)
    public entidadUsuario() {}

    // Constructor con todos los atributos
    public entidadUsuario(Long idUsuario, String nombreUsuario, String apellidoUsuario, 
                           String correoUsuario, String contraseniaUsuario, String dniUsuario, 
                           Boolean esAdmin, byte[] imagenUsuario, String direccion, 
                           String alias, String clubPerteneciente) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.correoUsuario = correoUsuario;
        this.contraseniaUsuario = contraseniaUsuario;
        this.dniUsuario = dniUsuario;
        this.esAdmin = esAdmin;
        this.imagenUsuario = imagenUsuario;
        this.direccion = direccion;
        this.alias = alias;
        this.clubPerteneciente = clubPerteneciente;
    }

    // Getters y setters
    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getContraseniaUsuario() {
        return contraseniaUsuario;
    }

    public void setContraseniaUsuario(String contraseniaUsuario) {
        this.contraseniaUsuario = contraseniaUsuario;
    }

    public String getDniUsuario() {
        return dniUsuario;
    }

    public void setDniUsuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }

    public Boolean getEsAdmin() {
        return esAdmin;
    }

    public void setEsAdmin(Boolean esAdmin) {
        this.esAdmin = esAdmin;
    }

    public byte[] getImagenUsuario() {
        return imagenUsuario;
    }

    public void setImagenUsuario(byte[] imagenUsuario) {
        this.imagenUsuario = imagenUsuario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getClubPerteneciente() {
        return clubPerteneciente;
    }

    public void setClubPerteneciente(String clubPerteneciente) {
        this.clubPerteneciente = clubPerteneciente;
    }
}