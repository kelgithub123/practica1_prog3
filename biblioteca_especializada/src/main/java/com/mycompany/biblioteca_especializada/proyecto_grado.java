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
public class proyecto_grado extends Material_bibliografico implements Serializable{
    static final long serialVersionUID=44L;
    private String tutor;
    private String revisor;

    public void mostrar(){
      System.out.println(super.getAutor()+"        "+super.getTitulo()+"        "+getTutor()+"       "+getRevisor());
  }
    
    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }
    
}
