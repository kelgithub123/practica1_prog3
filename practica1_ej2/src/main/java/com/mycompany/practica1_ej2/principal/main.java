/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practica1_ej2.principal;

import com.mycompany.practica1_ej2.operaciones_album;
import java.util.Scanner;

/**
 *
 * @author kelvi
 */
public class main {
    public static void main(String[] args) {
         Scanner leer = new Scanner(System.in);
        int opc = 0;
        boolean continuar = true;
        //instanciamos la clase OperacionesClienteTarjeta
        operaciones_album obj = new operaciones_album();
        
        do {
            System.out.println("-----------------------------");
            System.out.println("1.- REGISTRAR ALBUM");
            System.out.println("2.- REGISTRAR CANCION");
            System.out.println("3.- GUARDAR ALBUM");
            System.out.println("4.- MOSTRAR ALBUMS");
            System.out.println("5.- ELIMNAR MATERIAL");
            System.out.println("6.- SALIR");
            System.out.println("Digite una opción");
            System.out.println("----------------------------------");
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    obj.crear_album();
                    break;
                case 2:                    
                    obj.crearCancion();
                    break;
                case 3:
                    obj.almacena_album();
                    break;
                case 4:
                    obj.mostrar_discos();
                    break;                    
                default:
                    continuar = false;
                    break;
            }
        } while (continuar);
    }
    }

