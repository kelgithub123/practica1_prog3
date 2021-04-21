/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.examen_final;

import java.io.Serializable;

/**
 *
 * @author kel
 */
public class producto implements Serializable{
    private static final long serialVersionUID=10L; 
    private String nombre_producto;
    private float costo_unitario;
    private int stock;
    
    public void mortrar_producto(){
        System.out.println("---------------------------------------");
        System.out.println("PRODUCTO:"+this.nombre_producto);
        System.out.println("COSTO UNITARIO:"+this.costo_unitario);
        System.out.println("STOCK:"+this.stock);
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public float getCosto_unitario() {
        return costo_unitario;
    }

    public void setCosto_unitario(float costo_unitario) {
        this.costo_unitario = costo_unitario;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
}
