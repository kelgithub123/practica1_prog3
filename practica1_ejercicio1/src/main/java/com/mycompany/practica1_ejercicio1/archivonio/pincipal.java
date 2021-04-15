/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practica1_ejercicio1.archivonio;

import com.mycompany.practica1_ejercicio1.operaciones_docente_materia;
import java.util.Scanner;

/**
 *
 * @author kelvi
 */
public class pincipal {
    public static void main(String[] args) {
         Scanner leer = new Scanner(System.in);
        int opc = 0;
        boolean continuar = true;
        //instanciamos la clase OperacionesClienteTarjeta
        operaciones_docente_materia obj = new operaciones_docente_materia();
        
        do {
            System.out.println("-----------------------------");
            System.out.println("1.- CREAR DOCENTE");
            System.out.println("2.- CREAR MATERIA");
            System.out.println("3.- ASIGNAR MATERIA");
            System.out.println("4.- MOSTRAR DOCENTE");
            System.out.println("5.- SALIR");
            System.out.println("Digite una opción");
            System.out.println("----------------------------------");
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    obj.regsitra_docente();
                    break;
                case 2:
                    obj.registra_materia();
                    break;
                case 3:
                    obj.asignar_materia();
                    break;
                case 4:
                    obj.mostrar_docente();                    
                    break;
                default:
                    continuar = false;
                    break;
            }
        } while (continuar);

    }
    }

