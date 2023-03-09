package com.example.crudAeropuerto.Service;

import com.example.crudAeropuerto.Entity.Administrador;

import java.util.List;

public interface AdminService {
    public List<Administrador> ConsultarAdministrador();

    public Administrador CrearAdministrador(Administrador administrador);

    public Administrador ModificaAdministrador(Administrador administrador);

    public Administrador BuscaAdministrador(int idAdministrador);

    public void EliminaAdministrador(int idAdministrador);

}