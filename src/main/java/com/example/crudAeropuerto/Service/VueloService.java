package com.example.crudAeropuerto.Service;

import com.example.crudAeropuerto.Entity.Vuelo;

import java.util.List;

public interface VueloService {


    public List<Vuelo> ConsultarVuelo();

    public Vuelo CrearVuelo(Vuelo vuelo);

    public Vuelo ModificaVuelo(Vuelo vuelo);

    public Vuelo BuscaVuelo(int numVuelo);

    public void EliminaVuelo(int numVuelo);
}
