package com.example.demo.models;
//Import
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name= "empleados")

public class EmpleadoModel {
    //Decoradores De Clase
    @Id             ///Llave Primaria
    @GeneratedValue(strategy = GenerationType.AUTO) /// llave Autoincrementable ID
    @Column(unique = true, nullable = false) //  Caracteiracs que son unicos y no es nullo
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "Apellidos")
    private String Apellidos;
    @Column(name = "Tipo_Documento")
    private String Tipo_Documento;
    @Column(name = "Numero_Documento")
    private String Numero_Documento;
    @Column(name = "Fecha_Nacimiento")
    private String Fecha_Nacimiento;
    @Column(name = "Fecha_Vinculacion")
    private String Fecha_Vinculacion;
    @Column(name = "Cargo")
    private String Cargo;
    @Column(name = "Salario")
    private Double Salario;

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

    public String getFecha_Nacimiento(){
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
}
