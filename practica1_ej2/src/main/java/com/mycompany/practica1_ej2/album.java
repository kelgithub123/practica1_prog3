/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practica1_ej2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kelvi
 */
public class album {
    private String nombre,artista,formato;
    private List<Cancion> lista_temas;

    public void mostrar(){
        System.out.println("nombre");
        System.out.println("");
        System.out.println("");
    }
    
    public void adicionar_cancion(Cancion c){
        lista_temas.add(c);
        System.out.println("cancion agregada");
    }
    
    public album() {
        lista_temas=new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }
}
