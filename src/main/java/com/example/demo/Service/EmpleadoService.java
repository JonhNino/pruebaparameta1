package com.example.demo.Service;

import com.example.demo.models.EmpleadoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repositories.EmpleadoRepositories;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

@Service
public class EmpleadoService {
    @Autowired
    EmpleadoRepositories empleadoRepositories;

    public ArrayList<EmpleadoModel> ObtenerEmpleados() {
        return (ArrayList<EmpleadoModel>) empleadoRepositories.findAll(); /// Retornar toda la lista de l tabla
    }

    public EmpleadoModel Guardar(EmpleadoModel empleadoModel) {
        return empleadoRepositories.save(empleadoModel); ///Guardar los datos
    }

    public Boolean validarFecha(String fechaEntrada) {

        // System.out.println("Fecha de entrada es " +fechaEntrada);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date Objeto = format.parse(fechaEntrada);
            //System.out.println("Fecha Valida");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //Validar Campos Completos
    public Boolean atributosCompletos(EmpleadoModel empleadoModel) {
        if (empleadoModel.getNombre().equals("") || empleadoModel.getApellidos().equals("")
                || empleadoModel.getTipo_Documento().equals("") ||
                empleadoModel.getNumero_Documento().equals("") ||
                empleadoModel.getFecha_Vinculacion().equals("") ||
                empleadoModel.getFecha_Nacimiento().equals("") ||
                empleadoModel.getCargo().equals("") ||
                empleadoModel.getSalario().equals("")) {

            System.out.println("Algun Campo es Vacio");
            return false;
        }
        return true;
    }

    public Boolean mayorEdad(String fecha_Nacimiento) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());

        String matrizFecha[] = fecha_Nacimiento.split("-");
        // System.out.println(date.getYear()+1900);
        // System.out.println(matrizFecha[0]);
        if ((date.getYear() + 1900 - Integer.parseInt(matrizFecha[0]) > 18)) {
            System.out.println("Es Mayor de Edad");
            System.out.println(date.getMonth() + matrizFecha[1]);
            return true;

        } else {
            if((date.getYear() + 1900 - Integer.parseInt(matrizFecha[0]) == 18)){
                if ((date.getMonth() + 1 >= Integer.parseInt(matrizFecha[1]))) {
                    //System.out.println("Es Mayor de Edad por mes");
                    if ((date.getDate() >= Integer.parseInt(matrizFecha[2]))){
                        //System.out.println("Es Mayor de Edad por dia");
                        return true;
                    }
                    else{
                        return false;
                    }
                }
                else{
                    return false;
                }
            }
            return false;
        }

    }
}
