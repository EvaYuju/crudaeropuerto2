package com.example.crudAeropuerto.Service.AdminServiceIMPL;

import com.example.crudAeropuerto.Entity.Administrador;
import com.example.crudAeropuerto.Repository.AdminRepo;
import com.example.crudAeropuerto.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceIMPL implements AdminService {

    @Autowired
    private AdminRepo repo;


    @Override
    public List<Administrador> ConsultarAdministrador() {
        return (List<Administrador>) this.repo.findAll();
    }

    @Override
    public Administrador CrearAdministrador(Administrador admin) {
        // ¿vuelo.setOrigen(vuelo.getOrigen());
        return this.repo.save(admin);
    }

    @Override
    public Administrador ModificaAdministrador(Administrador admin) {
        return this.repo.save(admin);
    }

    @Override
    public Administrador BuscaAdministrador(int idAdmin) {
        return this.repo.findById(idAdmin).get();
    }

    @Override
    public void EliminaAdministrador(int idAdmin) {
        this.repo.deleteById(idAdmin);
    }


}
