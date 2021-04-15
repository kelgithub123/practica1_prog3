/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.biblioteca_especializada;

import java.io.Serializable;

/**
 *
 * @author kelvi
 */
public class libro extends Material_bibliografico implements Serializable{
    static final long serialVersionUID=42L;
    private int edicion;
    private String area;

    public void mostrar(){ 
      System.out.println(super.getAutor()+"        "+super.getTitulo()+"        "+getEdicion()+"       "+getArea());
  }
    public int getEdicion() {
        return edicion;
    }

    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    
}
