package com.example.demo.repositories;
//Interface de conexion

import com.example.demo.models.EmpleadoModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepositories extends CrudRepository <EmpleadoModel,Long> {

}
