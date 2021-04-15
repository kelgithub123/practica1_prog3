/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.biblioteca_especializada.archivosnio;

import com.mycompany.biblioteca_especializada.operaciones;
import java.util.Scanner;

/**
 *
 * @author kelvi
 */
public class principal {

    public static void main(String[] args) {
     Scanner leer = new Scanner(System.in);
        int opc = 0;
        boolean continuar = true;
        //instanciamos la clase OperacionesClienteTarjeta
        operaciones obj = new operaciones();
        
        do {
            System.out.println("-----------------------------");
            System.out.println("1.- REGISTRAR LIBRO");
            System.out.println("2.- MOSTRAR LIBROS");
            System.out.println("3.- REGISTRAR PROYECTO");
            System.out.println("4.- BUSCAR PROYECTO O LIBRO");
            System.out.println("5.- ELIMNAR MATERIAL");
            System.out.println("6.- SALIR");
            System.out.println("Digite una opción");
            System.out.println("----------------------------------");
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    obj.registlibro();
                    break;
                case 2:                    
                    obj.muestra_libro();
                    break;
                case 3:
                    obj.registproyecto();
                    break;
                case 4:
                    leer.nextLine();
                    System.out.println("coloque titulo");
                    String mat=leer.nextLine();
                    obj.buscar(mat);
                    break;
                case 5:
                    System.out.println("coloque titulo");
                    String elim=leer.nextLine();
                    obj.eliminar(elim);
                    break;
                default:
                    continuar = false;
                    break;
            }
        } while (continuar);
    }       
}

