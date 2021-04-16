/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practica1_ej3.principal;


import com.mycompany.practica1_ej3.operaciones_hospital;
import java.util.Scanner;

/**
 *
 * @author kelvi
 */
public class main1 {
    public static void main(String[] args) {
         Scanner leer = new Scanner(System.in);
        int opc = 0;
        boolean continuar = true;
        //instanciamos la clase OperacionesClienteTarjeta
        operaciones_hospital obj = new operaciones_hospital();
        
        do {
            System.out.println("-----------------------------");
            System.out.println("1.- REGISTRAR HOSPITAL");
            System.out.println("2.- REGISTRAR ESPECIALIDAD");
            System.out.println("3.- GUARDAR ESPECIALIDAD");
            System.out.println("4.- MOSTRAR ESPECIALDIAD DE HOSPITAL");
            System.out.println("5.- BUSCAR POR ESPECIALDIAD");
            System.out.println("6.- SALIR");
            System.out.println("Digite una opción");
            System.out.println("----------------------------------");
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    leer.nextLine();
                    obj.crear_hosp();
                    break;
                case 2:
                    leer.nextLine();
                    obj.crear_esp();
                    break;
                case 3:
                    leer.nextLine();
                    obj.almacena_hosp();
                    break;
                case 4:
                    leer.nextLine();
                    System.out.println("ingrese nombre de HOSPITAL");
                    String hosp=leer.nextLine();
                    obj.mostrar_esp_hosp(hosp);
                    break;    
                case 5:
                    leer.nextLine();
                    System.out.println("colocque nombre de especialidad");
                    String al=leer.nextLine();
                    obj.buscar_hosp_esp(al);
                    break;
                default:
                    continuar = false;
                    break;
            }
        } while (continuar);
    }
    }

