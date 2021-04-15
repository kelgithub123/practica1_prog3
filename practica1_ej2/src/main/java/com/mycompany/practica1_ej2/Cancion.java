/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practica1_ej2;

/**
 *
 * @author kelvi
 */
public class Cancion {
    private String nombreCancion,genero;
    private float duracion;

    public void mostrar(){
        System.out.println("---------------------------");
        System.out.println("nombre"+this.nombreCancion);
        System.out.println("genero"+this.genero);
        System.out.println("duracion"+this.duracion);
        System.out.println("-------------------------");
    }
    
    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public float getDuracion() {
        return duracion;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }
    
    
}
