/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practica1_ej3;

/**
 *
 * @author kelvi
 */
public class especialidad {
   private String nombre_Especialidad;
   
   public void mostrar(){
        System.out.println("nombre="+this.nombre_Especialidad);
    }

    public String getNombre_Especialidad() {
        return nombre_Especialidad;
    }

    public void setNombre_Especialidad(String nombre_Especialidad) {
        this.nombre_Especialidad = nombre_Especialidad;
    }
   
}
