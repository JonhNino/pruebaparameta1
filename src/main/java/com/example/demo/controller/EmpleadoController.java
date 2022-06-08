package com.example.demo.controller;

import com.example.demo.Service.EmpleadoService;
import com.example.demo.models.EmpleadoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value="/empleados")
public class EmpleadoController {

    @Autowired  //Tomar lo uqe hay en servicios y conectarlo con el contralador automaticamente
    EmpleadoService empleadoService; //Instancia

    @GetMapping()//Metod Get
    public ArrayList<EmpleadoModel> getEmpleado(){
        return empleadoService.ObtenerEmpleados();
    }

    @PostMapping()// Metodo Post
    public EmpleadoModel postEmpleado(@RequestBody EmpleadoModel empleadoModel){

        return this.empleadoService.Guardar(empleadoModel);
    }
}
