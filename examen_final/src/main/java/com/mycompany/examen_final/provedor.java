/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.examen_final;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kel
 */
public class provedor implements Serializable{
private static final long serialVersionUID=11L;
    private String razon_social,direccion;
    private int numero_tel;
    private List<producto> lista_productos;
    
    public provedor() {
        lista_productos=new ArrayList<>();
    }
    
//    public void crearlista(){
//    lista_productos=new ArrayList<>();
//    }
    public void mostrar_prov(){
        System.out.println("RAZON SOCIAL::"+this.razon_social);
        System.out.println("DIRECCION::"+this.direccion);
        System.out.println("TELEFONO::"+this.numero_tel);        
    }
    public void add_product(producto p){
    if(p!=null){
    this.lista_productos.add(p);
    }
    else
            System.out.println("el producto esta null");
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNumero_tel() {
        return numero_tel;
    }

    public void setNumero_tel(int numero_tel) {
        this.numero_tel = numero_tel;
    }

    public List<producto> getLista_productos() {
        return lista_productos;
    }

    public void setLista_productos(List<producto> lista_productos) {
        this.lista_productos = lista_productos;
    }
    
}
