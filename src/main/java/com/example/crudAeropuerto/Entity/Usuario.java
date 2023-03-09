package com.example.crudAeropuerto.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idUsuario;
    String nombre;
    String email;
    String pwdUsuario;

    public Usuario(int idUsuario, String nombre, String email, String pwdUsuario) {

        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.email = email;
        this.pwdUsuario = pwdUsuario;
    }

    public Usuario(){}
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwdUsuario() {
        return pwdUsuario;
    }

    public void setPwdUsuario(String pwdUsuario) {
        this.pwdUsuario = pwdUsuario;
    }
}
