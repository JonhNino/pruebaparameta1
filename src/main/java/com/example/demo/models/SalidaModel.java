package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class SalidaModel {

    private Long id;

    private String nombre;

    private String Apellidos;

    private String Tipo_Documento;

    private String Numero_Documento;

    private String Fecha_Nacimiento;

    private String Fecha_Vinculacion;

    private String Cargo;

    private Double Salario;

    private String Tiempo_Vinculacion;

    private String Edad_Empleado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getTipo_Documento() {
        return Tipo_Documento;
    }

    public void setTipo_Documento(String tipo_Documento) {
        Tipo_Documento = tipo_Documento;
    }

    public String getNumero_Documento() {
        return Numero_Documento;
    }

    public void setNumero_Documento(String numero_Documento) {
        Numero_Documento = numero_Documento;
    }

    public String getFecha_Nacimiento() {
        return Fecha_Nacimiento;
    }

    public void setFecha_Nacimiento(String fecha_Nacimiento) {
        Fecha_Nacimiento = fecha_Nacimiento;
    }

    public String getFecha_Vinculacion() {
        return Fecha_Vinculacion;
    }

    public void setFecha_Vinculacion(String fecha_Vinculacion) {
        Fecha_Vinculacion = fecha_Vinculacion;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String cargo) {
        Cargo = cargo;
    }

    public Double getSalario() {
        return Salario;
    }

    public void setSalario(Double salario) {
        Salario = salario;
    }

    public String getTiempo_Vinculacion() {
        return Tiempo_Vinculacion;
    }

    public void setTiempo_Vinculacion(String tiempo_Vinculacion) {
        Tiempo_Vinculacion = tiempo_Vinculacion;
    }

    public String getEdad_Empleado() {
        return Edad_Empleado;
    }

    public void setEdad_Empleado(String edad_Empleado) {
        Edad_Empleado = edad_Empleado;
    }
}
