package com.example.crudAeropuerto.Repository;

import com.example.crudAeropuerto.CrudAeropuertoApplication;
import com.example.crudAeropuerto.Entity.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface VueloRepo extends JpaRepository<Vuelo, Integer> {


}
