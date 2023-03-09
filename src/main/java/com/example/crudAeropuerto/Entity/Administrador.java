package com.example.crudAeropuerto.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "administradores")
public class Administrador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String nombre;
    String email;
    String pwdAdmin;

    public Administrador(String nombre, String email, String pwdAdmin) {
        this.nombre = nombre;
        this.email = email;
        this.pwdAdmin = pwdAdmin;
    }

    public Administrador() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getPwdAdmin() {
        return pwdAdmin;
    }

    public void setPwdAdmin(String pwdAdmin) {
        this.pwdAdmin = pwdAdmin;
    }
}
