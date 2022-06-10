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
    public ArrayList<String> tiempoVinculacion (String fecha_Vinculacion){
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String matrizFecha[] = fecha_Vinculacion.split("-");

        ArrayList<String> vinculacionTime = new ArrayList<String>(); //Almacenar año y fecha de resultado

        ///System.out.println(vinculacionTime.get(0)); /// Almacenado año Vinculacion
        if((date.getMonth()+1)<=Integer.parseInt(matrizFecha[1])) {
            int temp=((date.getYear()+1900)-Integer.parseInt(matrizFecha[0])-1);
            vinculacionTime.add(String.valueOf(temp));
            int temp1 = (12 - Integer.parseInt(matrizFecha[1]) + (date.getMonth() + 1));
            if(temp1==12){
                temp1=0;
            }
            vinculacionTime.add(String.valueOf(temp1));
            ///System.out.println(vinculacionTime.get(1)); /// Almacenado año Vinculacion
        }else{
            int temp=((date.getYear()+1900)-Integer.parseInt(matrizFecha[0]));
            vinculacionTime.add(String.valueOf(temp));
            int temp1 = ((date.getMonth() + 1-Integer.parseInt(matrizFecha[1])));
            vinculacionTime.add(String.valueOf(temp1));
           //// System.out.println(vinculacionTime.get(1)); /// Almacenado año Vinculacion
        }
        //ArrayList<String> Respuesta = new ArrayList<>();
        //Respuesta.add(vinculacionTime.get(0));
        return vinculacionTime;
    }

    public ArrayList<String> edadEmpleado(String fecha_Nacimiento){
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String matrizFecha[] = fecha_Nacimiento.split("-");

        ArrayList<String> vinculacionTime = new ArrayList<String>(); //Almacenar año y fecha de resultado

       /// System.out.println("Años Empleados" +vinculacionTime.get(0)); /// Almacenado año Vinculacion
        if((date.getMonth()+1)<=Integer.parseInt(matrizFecha[1])) {
            int temp=((date.getYear()+1900)-Integer.parseInt(matrizFecha[0])-1);
            vinculacionTime.add(String.valueOf(temp));
            int temp1 = (12 - Integer.parseInt(matrizFecha[1]) + (date.getMonth() + 1));
            if(temp1==12){
                temp1=0;
            }
            vinculacionTime.add(String.valueOf(temp1));
            ///Switch Dias
            switch (matrizFecha[1]){
                case "1":{
                    int tempDay = 0;
                    Meses31( date.getDate(), String.valueOf(Integer.parseInt(matrizFecha[2])),tempDay);
                    vinculacionTime.add(String.valueOf(Meses31( date.getDate(), String.valueOf(Integer.parseInt(matrizFecha[2])),tempDay)));
                }
                case "2":{
                    int tempDay = 0;
                    Meses31( date.getDate(), String.valueOf(Integer.parseInt(matrizFecha[2])),tempDay);
                    vinculacionTime.add(String.valueOf(Meses31( date.getDate(), String.valueOf(Integer.parseInt(matrizFecha[2])),tempDay)));
                }
                case "3":{
                    int tempDay = 0;
                    Meses31( date.getDate(), String.valueOf(Integer.parseInt(matrizFecha[2])),tempDay);
                    vinculacionTime.add(String.valueOf(Meses31( date.getDate(), String.valueOf(Integer.parseInt(matrizFecha[2])),tempDay)));
                }
                case "4":{
                    int tempDay = 0;
                    Meses30( date.getDate(), String.valueOf(Integer.parseInt(matrizFecha[2])),tempDay);
                    vinculacionTime.add(String.valueOf(Meses30( date.getDate(), String.valueOf(Integer.parseInt(matrizFecha[2])),tempDay)));
                }
                case "5":{
                    int tempDay = 0;
                    Meses31( date.getDate(), String.valueOf(Integer.parseInt(matrizFecha[2])),tempDay);
                    vinculacionTime.add(String.valueOf(Meses31( date.getDate(), String.valueOf(Integer.parseInt(matrizFecha[2])),tempDay)));
                }
                case "6":{
                    int tempDay = 0;
                    Meses30( date.getDate(), String.valueOf(Integer.parseInt(matrizFecha[2])),tempDay);
                    vinculacionTime.add(String.valueOf(Meses30( date.getDate(), String.valueOf(Integer.parseInt(matrizFecha[2])),tempDay)));
                }
                case "7":{
                    int tempDay = 0;
                    Meses31( date.getDate(), String.valueOf(Integer.parseInt(matrizFecha[2])),tempDay);
                    vinculacionTime.add(String.valueOf(Meses31( date.getDate(), String.valueOf(Integer.parseInt(matrizFecha[2])),tempDay)));
                }
                case "8":{
                    int tempDay = 0;
                    Meses31( date.getDate(), String.valueOf(Integer.parseInt(matrizFecha[2])),tempDay);
                    vinculacionTime.add(String.valueOf(Meses31( date.getDate(), String.valueOf(Integer.parseInt(matrizFecha[2])),tempDay)));

                }
                case "9":{
                    int tempDay = 0;
                    Meses30( date.getDate(), String.valueOf(Integer.parseInt(matrizFecha[2])),tempDay);
                    vinculacionTime.add(String.valueOf(Meses30( date.getDate(), String.valueOf(Integer.parseInt(matrizFecha[2])),tempDay)));
                }
                case "10":{
                    int tempDay = 0;
                    Meses31( date.getDate(), String.valueOf(Integer.parseInt(matrizFecha[2])),tempDay);
                    vinculacionTime.add(String.valueOf(Meses31( date.getDate(), String.valueOf(Integer.parseInt(matrizFecha[2])),tempDay)));
                }
                case "11":{
                    int tempDay = 0;
                    Meses30( date.getDate(), String.valueOf(Integer.parseInt(matrizFecha[2])),tempDay);
                    vinculacionTime.add(String.valueOf(Meses30( date.getDate(), String.valueOf(Integer.parseInt(matrizFecha[2])),tempDay)));

                }
                case "12":{
                    int tempDay = 0;
                    Meses31( date.getDate(), String.valueOf(Integer.parseInt(matrizFecha[2])),tempDay);
                    vinculacionTime.add(String.valueOf(Meses31( date.getDate(), String.valueOf(Integer.parseInt(matrizFecha[2])),tempDay)));
                }

            }
            ///System.out.println("Meses Empleados"+vinculacionTime.get(1)); /// Almacenado año Vinculacion
        }else{
            int temp=((date.getYear()+1900)-Integer.parseInt(matrizFecha[0]));
            vinculacionTime.add(String.valueOf(temp));
            int temp1 = ((date.getMonth() + 1-Integer.parseInt(matrizFecha[1])));
            vinculacionTime.add(String.valueOf(temp1));
            ///Switch Dias
            switch (matrizFecha[1]){
                case "1":{
                    int tempDay = 0;
                    Meses31( date.getDate(), String.valueOf(Integer.parseInt(matrizFecha[2])),tempDay);
                    vinculacionTime.add(String.valueOf(Meses31( date.getDate(), String.valueOf(Integer.parseInt(matrizFecha[2])),tempDay)));
                }
                case "2":{
                    int tempDay = 0;
                    Meses31( date.getDate(), String.valueOf(Integer.parseInt(matrizFecha[2])),tempDay);
                    vinculacionTime.add(String.valueOf(Meses31( date.getDate(), String.valueOf(Integer.parseInt(matrizFecha[2])),tempDay)));
                }
                case "3":{
                    int tempDay = 0;
                    Meses31( date.getDate(), String.valueOf(Integer.parseInt(matrizFecha[2])),tempDay);
                    vinculacionTime.add(String.valueOf(Meses31( date.getDate(), String.valueOf(Integer.parseInt(matrizFecha[2])),tempDay)));
                }
                case "4":{
                    int tempDay = 0;
                    Meses30( date.getDate(), String.valueOf(Integer.parseInt(matrizFecha[2])),tempDay);
                    vinculacionTime.add(String.valueOf(Meses30( date.getDate(), String.valueOf(Integer.parseInt(matrizFecha[2])),tempDay)));
                }
                case "5":{
                    int tempDay = 0;
                    Meses31( date.getDate(), String.valueOf(Integer.parseInt(matrizFecha[2])),tempDay);
                    vinculacionTime.add(String.valueOf(Meses31( date.getDate(), String.valueOf(Integer.parseInt(matrizFecha[2])),tempDay)));
                }
                case "6":{
                    int tempDay = 0;
                    Meses30( date.getDate(), String.valueOf(Integer.parseInt(matrizFecha[2])),tempDay);
                    vinculacionTime.add(String.valueOf(Meses30( date.getDate(), String.valueOf(Integer.parseInt(matrizFecha[2])),tempDay)));
                }
                case "7":{
                    int tempDay = 0;
                    Meses31( date.getDate(), String.valueOf(Integer.parseInt(matrizFecha[2])),tempDay);
                    vinculacionTime.add(String.valueOf(Meses31( date.getDate(), String.valueOf(Integer.parseInt(matrizFecha[2])),tempDay)));
                }
                case "8":{
                    int tempDay = 0;
                    Meses31( date.getDate(), String.valueOf(Integer.parseInt(matrizFecha[2])),tempDay);
                    vinculacionTime.add(String.valueOf(Meses31( date.getDate(), String.valueOf(Integer.parseInt(matrizFecha[2])),tempDay)));

                }
                case "9":{
                    int tempDay = 0;
                    Meses30( date.getDate(), String.valueOf(Integer.parseInt(matrizFecha[2])),tempDay);
                    vinculacionTime.add(String.valueOf(Meses30( date.getDate(), String.valueOf(Integer.parseInt(matrizFecha[2])),tempDay)));
                }
                case "10":{
                    int tempDay = 0;
                    Meses31( date.getDate(), String.valueOf(Integer.parseInt(matrizFecha[2])),tempDay);
                    vinculacionTime.add(String.valueOf(Meses31( date.getDate(), String.valueOf(Integer.parseInt(matrizFecha[2])),tempDay)));
                }
                case "11":{
                    int tempDay = 0;
                    Meses30( date.getDate(), String.valueOf(Integer.parseInt(matrizFecha[2])),tempDay);
                    vinculacionTime.add(String.valueOf(Meses30( date.getDate(), String.valueOf(Integer.parseInt(matrizFecha[2])),tempDay)));

                }
                case "12":{
                    int tempDay = 0;
                    Meses31( date.getDate(), String.valueOf(Integer.parseInt(matrizFecha[2])),tempDay);
                    vinculacionTime.add(String.valueOf(Meses31( date.getDate(), String.valueOf(Integer.parseInt(matrizFecha[2])),tempDay)));
                }

            }
            ///System.out.println("Meses Empleados"+vinculacionTime.get(1)); /// Almacenado año Vinculacion
        }

        return vinculacionTime;
    }

    ///Espacio para mostrar los dias de nacimiento
    public static int Meses31(int date, String s, int tempDay){System.out.println("Estoy aqui");
        if(date<=Integer.parseInt(s)) {
            tempDay = (31 - Integer.parseInt(s) + date);
            if(tempDay==31){
                tempDay=0;
            }
            //vinculacionTime.add(String.valueOf(tempDay));

            System.out.println("Dias del Empleado"+tempDay); /// Almacenado año Vinculacion
        }else{
            tempDay = ((date-Integer.parseInt(s)));
            //vinculacionTime.add(String.valueOf(tempDay));
            System.out.println("Dias del Empleados"+tempDay); /// Almacenado año Vinculacion
        }

        return tempDay;

    }

    public static int Meses30(int date, String s, int tempDay){System.out.println("Estoy aqui");
        if(date<=Integer.parseInt(s)) {
            tempDay = (31 - Integer.parseInt(s) + date);
            if(tempDay==31){
                tempDay=0;
            }
            //vinculacionTime.add(String.valueOf(tempDay));

            System.out.println("Dias del Empleado"+tempDay); /// Almacenado año Vinculacion
        }else{
            tempDay = ((date-Integer.parseInt(s)));
            //vinculacionTime.add(String.valueOf(tempDay));
            System.out.println("Dias del Empleados"+tempDay); /// Almacenado año Vinculacion
        }

        return tempDay;

    }

    public static int Meses28(int date, String s, int tempDay){System.out.println("Estoy aqui");
        if(date<=Integer.parseInt(s)) {
            tempDay = (31 - Integer.parseInt(s) + date);
            if(tempDay==31){
                tempDay=0;
            }
            //vinculacionTime.add(String.valueOf(tempDay));

            System.out.println("Dias del Empleado"+tempDay); /// Almacenado año Vinculacion
        }else{
            tempDay = ((date-Integer.parseInt(s)));
            //vinculacionTime.add(String.valueOf(tempDay));
            System.out.println("Dias del Empleados"+tempDay); /// Almacenado año Vinculacion
        }

        return tempDay;

    }

}
