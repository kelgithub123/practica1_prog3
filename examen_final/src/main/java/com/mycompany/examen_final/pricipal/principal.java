/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.examen_final.pricipal;

import com.mycompany.examen_final.operaciones_producto;
import java.util.Scanner;

/**
 *
 * @author kel
 */
public class principal {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int opc = 0;
        boolean continuar = true;
        //instanciamos la clase OperacionesClienteTarjeta
        operaciones_producto obj = new operaciones_producto();
        
        do {
            System.out.println("-----------------------------");
            System.out.println("1.- REGISTRAR PROVEEDOR Y PRODUCTOS");
            System.out.println("2.- LISTAR PRODUCTOS DE PROVEEDOR");
            System.out.println("3.- COMPRAR PRODUCTO");
            System.out.println("4.- MOSTRAR TODO");
            System.out.println("5.- SALIR");
            System.out.println("Digite una opción");
            System.out.println("----------------------------------");
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    obj.registro_prov();
                    break;                    
                case 2:
                    leer.nextLine();
                    System.out.println("ingrese nombre de PROVEEDOR");
                    String prov=leer.nextLine();
                    obj.productos_prov(prov);
                    break;                    
                case 3:
                    leer.nextLine();
                    System.out.println("que producto desea comprar?");
                    String prod=leer.nextLine();
                    obj.prov_prod_disp(prod);
                    break;
                case 4:
                    obj.mostrartodo();
                    break;
                default:
                    continuar = false;
                    break;
            }
        } while (continuar);
    }
    }

