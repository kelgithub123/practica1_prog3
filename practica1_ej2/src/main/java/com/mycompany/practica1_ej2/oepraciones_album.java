/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practica1_ej2;

import java.util.Scanner;

/**
 *
 * @author kelvi
 */
public class oepraciones_album {
    private Cancion c;
    private album a;
    Scanner lee2=new Scanner (System.in);
    
    
    public void crearCancion() {
        c = new Cancion();
        System.out.println("nombre");
        String n = lee2.nextLine();
        c.setNombreCancion(n);
        System.out.println("genero");
        String g = lee2.nextLine();
        c.setGenero(g);
        System.out.println("duracion");
        float d = lee2.nextFloat();
        c.setDuracion(d);
        //adicionando la cancion a album
        a.adicionar_cancion(c);
    }
    
    public void crear_album(){
    
    }
}
