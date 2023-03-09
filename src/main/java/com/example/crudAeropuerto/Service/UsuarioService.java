package com.example.crudAeropuerto.Service;

import com.example.crudAeropuerto.Entity.Usuario;

import java.util.List;

public interface UsuarioService {
    public List<Usuario> ConsultarUsuario();

    public Usuario CrearUsuario(Usuario usuario);

    public Usuario ModificaUsuario(Usuario usuario);

    public Usuario BuscaUsuario(int idUsuario);

    public void EliminaUsuario(int idUsuario);

}
