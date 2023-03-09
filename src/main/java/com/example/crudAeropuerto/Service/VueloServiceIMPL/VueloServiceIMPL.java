package com.example.crudAeropuerto.Service.VueloServiceIMPL;


import com.example.crudAeropuerto.Entity.Usuario;
import com.example.crudAeropuerto.Entity.Vuelo;
import com.example.crudAeropuerto.Repository.UsuarioRepo;
import com.example.crudAeropuerto.Repository.VueloRepo;
import com.example.crudAeropuerto.Service.VueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VueloServiceIMPL implements VueloService {

    @Autowired
    private VueloRepo repo;


    @Override
    public List<Vuelo> ConsultarVuelo() {
        return (List<Vuelo>) this.repo.findAll();
    }

    @Override
    public Vuelo CrearVuelo(Vuelo vuelo) {
        vuelo.setOrigen(vuelo.getOrigen());
        return this.repo.save(vuelo);
    }

    @Override
    public Vuelo ModificaVuelo(Vuelo vuelo) {
        return this.repo.save(vuelo);

    }

    @Override
    public Vuelo BuscaVuelo(int numVuelo) {
        return this.repo.findById(numVuelo).get();
    }

    @Override
    public void EliminaVuelo(int numVuelo) {
        this.repo.deleteById(numVuelo);
    }
}

