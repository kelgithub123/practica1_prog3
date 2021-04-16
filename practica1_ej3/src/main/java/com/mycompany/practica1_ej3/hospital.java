/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practica1_ej3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kelvi
 */
public class hospital {
   private String nombrehosp,direc;
   private int nivel;
   private List<especialidad> lista_especialidad;

    public hospital() {
        lista_especialidad=new ArrayList<>();
    }
   
   public void mostrar(){
        System.out.println("HOSPITTAL="+this.nombrehosp);
        System.out.println("DIRECCION="+this.direc);
        System.out.println("NIVEL="+this.nivel);
    }

   public void adicionar_especialidad(especialidad e){
        lista_especialidad.add(e);
        System.out.println("especialdiad agregada");
    }
    public String getNombrehosp() {
        return nombrehosp;
    }

    public void setNombrehosp(String nombrehosp) {
        this.nombrehosp = nombrehosp;
    }

    public String getDirec() {
        return direc;
    }

    public void setDirec(String direc) {
        this.direc = direc;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public List<especialidad> getLista_especialidad() {
        return lista_especialidad;
    }

    public void setLista_especialidad(List<especialidad> lista_especialidad) {
        this.lista_especialidad = lista_especialidad;
    }


   
}
