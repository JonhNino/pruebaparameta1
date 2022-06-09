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

        Boolean edadMayor = empleadoService.mayorEdad(empleadoModel.getFecha_Nacimiento());
        Boolean camposValidos =empleadoService.atributosCompletos(empleadoModel);
        Boolean esValidoNacimiento = empleadoService.validarFecha(empleadoModel.getFecha_Nacimiento());
        Boolean esValidoVinculacion = empleadoService.validarFecha(empleadoModel.getFecha_Vinculacion());
        System.out.println(edadMayor);
        System.out.println(camposValidos);
        System.out.println(esValidoNacimiento);
        System.out.println(esValidoVinculacion);
        if(edadMayor && esValidoNacimiento && esValidoVinculacion && camposValidos ){
            System.out.println("estoy entrando el if");
            return empleadoService.Guardar(empleadoModel);
        }

        return null;
    }
}
