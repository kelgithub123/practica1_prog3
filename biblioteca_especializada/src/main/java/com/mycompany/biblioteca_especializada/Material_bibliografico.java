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
public class Material_bibliografico implements Serializable {
    static final long serialVersionUID=43L;
    private String titulo;
    private String autor;
    private libro lib;
    private proyecto_grado pr;

    public Material_bibliografico() {            
    }

    public libro getLib() {
        return lib;
    }

    public void setLib(libro lib) {
        this.lib = lib;
    }

    public proyecto_grado getPr() {
        return pr;
    }

    public void setPr(proyecto_grado pr) {
        this.pr = pr;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
   
    
}
