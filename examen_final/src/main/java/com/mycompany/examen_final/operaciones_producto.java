/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.examen_final;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kel
 */
public class operaciones_producto {
    private producto prod;
    private provedor prov;
    private List<provedor> lista_prov;
    private List<provedor> lista_prov_oferta;    
    Scanner lee;

    public operaciones_producto() {
    crearDir();
    crearArch();
    lista_prov=new ArrayList<>();
    lee = new Scanner(System.in);
    }        
    
    public void registro_prov() {
        
        boolean y = true;
        prov = new provedor();
        System.out.println("PROVEEDOR::");
        String rs = lee.nextLine();
        prov.setRazon_social(rs);
        System.out.println("DIRECCION::");
        String di = lee.nextLine();
        prov.setDireccion(di);
        System.out.println("TELEFONO::");
        int te = lee.nextInt();
        prov.setNumero_tel(te);
        lee.nextLine();
        do {
            prod = new producto();
            System.out.println("PRODUCTO:");
            String n = lee.nextLine();
            prod.setNombre_producto(n);
            System.out.println("COSTO UNITARIO:");
            float cu = lee.nextFloat();
            prod.setCosto_unitario(cu);
            System.out.println("STOCK:");
            int st = lee.nextInt();
            prod.setStock(st);
            //añado producto a proveedor
            prov.adi_product(prod);
            lee.nextLine();            
            System.out.println("desea seguir agregando productos?y/n");
            String resp = lee.nextLine();
            if (resp.equalsIgnoreCase("n")) {
                y = false;
            }
        } while (y);      
//añnado el provedor a un lista para la serializacion
lista_prov.add(prov);
guardar_datos();
    }

public void productos_prov(String nom){
    lee_datos();
    for (provedor pv : lista_prov) {
        if (pv.getRazon_social().equalsIgnoreCase(nom)) {
            pv.mostrar_prov();
            for(producto pr:pv.getLista_productos()){
            pr.mortrar_producto();
            
            }
        }
    }
}
public void prov_prod_disp(String p){
    lee_datos();
    System.out.println("lista de proveedores con el producto");
    for (provedor pv : lista_prov) {        
            for(producto pr:pv.getLista_productos()){                
            if(pr.getNombre_producto().equalsIgnoreCase(p)){
                    pv.mostrar_prov();
            }
            }
        }
    System.out.println("escriba nombre de provedor al que comprara producto");
    String com=lee.nextLine();
    comprar_prod(com,p);    
    }

public void comprar_prod(String prov,String prod){
    for (provedor pv : lista_prov) {
            if(pv.getRazon_social().equalsIgnoreCase(prov)){
            for(producto pr:pv.getLista_productos()){                
            if(pr.getNombre_producto().equalsIgnoreCase(prod)){
                    pv.mostrar_prov();
                    pr.mortrar_producto();
                    System.out.println("cuantos comprara?");
                    int cant=lee.nextInt();
                    if(pr.getStock()>cant)
                    {
                    int n_stock=pr.getStock()-cant;
                    pr.setStock(n_stock);
                    }
                    else
                        System.out.println("cantidad insufiente en depsoito"); }
            }}}
    guardar_datos();
}


//operaciones de archivo, crear directorio,crear archivo.txt y gusardar datos serializables que significa que 
    //para el guardado de transformaran en binario y cuando se recuperaran se lo hara tamienen binario que luego sera convertido a formato de programa
      public void crearDir(){
    Path path;
        path=Paths.get("E:\\INFORMATICA\\informatica_2021\\PROG_III_2021\\Arch_maven");
        try{
            if(!Files.exists(path)){
            Files.createDirectory(path);
                System.out.println("directorio creado");
            }
            else{
                System.out.println("ya existe el directorio");}
        }catch(Exception e){
           e.printStackTrace();
        }
}
     public void crearArch(){
    Path path;
        path=Paths.get("E:\\INFORMATICA\\informatica_2021\\PROG_III_2021\\Arch_maven\\lista_proveedores.txt");
        try{
            if(!Files.exists(path)){
            Files.createFile(path);
                System.out.println("Archivo creado");
            }
            else{
                System.out.println("ya existe el Archivo");
                Files.write(path, "creado por kelvin".getBytes(),StandardOpenOption.APPEND);
            }
        }catch(Exception e){
           e.printStackTrace();
        }
}
     //guardadod e datos a binario
     public void guardar_datos(){
           String ruta = "E:\\INFORMATICA\\informatica_2021\\PROG_III_2021\\Arch_maven\\lista_proveedores.txt";
           try {
               FileOutputStream arch = new FileOutputStream(ruta);
               ObjectOutputStream o = new ObjectOutputStream(arch);
               o.writeObject(lista_prov);
               o.close();
               arch.close();
               
           } catch (FileNotFoundException ex) {
               Logger.getLogger(operaciones_producto.class.getName()).log(Level.SEVERE, null, ex);
           }
           catch(IOException ex){
               Logger.getLogger(operaciones_producto.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
     //ctrl+chift+c comentar lineas
     //lectura de datos de archivo
     public void lee_datos(){
           String ruta = "E:\\INFORMATICA\\informatica_2021\\PROG_III_2021\\Arch_maven\\lista_proveedores.txt";
           try {
               FileInputStream archivos = new FileInputStream(ruta);
               ObjectInputStream op = new ObjectInputStream(archivos);
               if(op != null){
                 lista_prov= (List<provedor>)op.readObject();
               }else{
                   System.out.println("NO HAY REGISTRO ALGUNO");
               }
           } catch (FileNotFoundException e) {
               Logger.getLogger(operaciones_producto.class.getName()).log(Level.SEVERE , null, e);
           } catch(IOException ex){
                Logger.getLogger(operaciones_producto.class.getName()).log(Level.SEVERE, null, ex);
           } catch(ClassNotFoundException ex){
                Logger.getLogger(operaciones_producto.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
     public void mostrartodo(){
     lee_datos();
     for (provedor pv : lista_prov) {
            System.out.println("cantidad de datos"+pv.getLista_productos().size());
            pv.mostrar_prov();
            for(producto pr:pv.getLista_productos()){
            pr.mortrar_producto();
            }
        }
    }
     
}


