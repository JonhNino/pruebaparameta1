package com.example.demo.Service;

import com.example.demo.models.EmpleadoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repositories.EmpleadoRepositories;

import java.util.ArrayList;

@Service
public class EmpleadoService {
    @Autowired
    EmpleadoRepositories empleadoRepositories;


    public ArrayList<EmpleadoModel> ObtenerEmpleados(){
        return(ArrayList<EmpleadoModel>) empleadoRepositories.findAll(); /// Retornar toda la lista de l tabla
    }

    public EmpleadoModel Guardar(EmpleadoModel empleadoModel){
        return empleadoRepositories.save(empleadoModel); ///Guardar los datos
    }

}
