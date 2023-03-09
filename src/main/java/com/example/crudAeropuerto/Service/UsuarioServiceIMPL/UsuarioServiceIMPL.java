package com.example.crudAeropuerto.Service.UsuarioServiceIMPL;

import com.example.crudAeropuerto.Entity.Usuario;
import com.example.crudAeropuerto.Repository.UsuarioRepo;
import com.example.crudAeropuerto.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceIMPL implements UsuarioService {

    @Autowired
    private UsuarioRepo repo;

    @Override
    public List<Usuario> ConsultarUsuario() {
        return (List<Usuario>) this.repo.findAll();
    }

    @Override
    public Usuario CrearUsuario(Usuario usuario) {
        usuario.setNombre(usuario.getNombre());
        return this.repo.save(usuario);
    }

    @Override
    public Usuario ModificaUsuario(Usuario usuario) {
        return this.repo.save(usuario);
    }

    @Override
    public Usuario BuscaUsuario(int idUsuario) {
        return this.repo.findById(idUsuario).get();
    }

    @Override
    public void EliminaUsuario(int idUsuario) {
        this.repo.deleteById(idUsuario);
    }
}
