/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.biblioteca_especializada;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import static java.nio.file.Files.list;
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
 * @author kelvi
 */

public class operaciones {
    List<Material_bibliografico> material;

    Scanner leer=new Scanner(System.in);

    public operaciones() {
        crear_dir();
        crear_Arch();
        material=new ArrayList<>();        
    }
    
    public void crear_dir(){
    Path path;
        path=Paths.get("D:\\INFORMATICA\\informatica_2021\\PROG_III_2021\\Arch_maven");
        try{
            if(!Files.exists(path)){
            Files.createDirectory(path);
                System.out.println("directorio creado");
            }
            else{}
        }catch(Exception e){
           e.printStackTrace();
        }}
    public void crear_Arch(){
    Path pat;
        pat=Paths.get("D:\\INFORMATICA\\informatica_2021\\PROG_III_2021\\Arch_maven\\lista_biblioteca.txt");
        try{
            if(!Files.exists(pat)){
            Files.createFile(pat);
                System.out.println("Archivo creado");
            }
            else{
                System.out.println("ya existe archivo");
            }
        }catch(Exception e){
           e.printStackTrace();
        }    
    }
    
    public void registlibro(){
        libro lib=new libro();
        System.out.println("-------titulo-------");
        String titu=leer.nextLine();       
        lib.setTitulo(titu);        
        System.out.println("------autor------");
        String autr=leer.nextLine();
        lib.setAutor(autr);
        System.out.println("------AREA-------");
        String ar=leer.nextLine();
        lib.setArea(ar);
        System.out.println("------Nro de Edicion------");
        int ej=leer.nextInt();
        lib.setEdicion(ej);
        material.add(lib);
        leer.nextLine();
         guardar_datos();
}
            public void registproyecto(){
        proyecto_grado p=new proyecto_grado();
        System.out.println("-------titulo-------");
        String titu=leer.nextLine();       
        p.setTitulo(titu);        
        System.out.println("------autor------");
        String autr=leer.nextLine();
        p.setAutor(autr);
        System.out.println("------revisor-------");
        String rev=leer.nextLine();
        p.setRevisor(rev);
        System.out.println("------tutor------");
        String tut=leer.nextLine();
        p.setTutor(tut);
        material.add(p);
        guardar_datos();
} 
    
    public void guardar_datos(){
                           String ruta = "D:\\INFORMATICA\\informatica_2021\\PROG_III_2021\\Arch_maven\\lista_biblioteca.txt";
           if(material!=null){                
           try {
               FileOutputStream archivos = new FileOutputStream(ruta);
               ObjectOutputStream Os = new ObjectOutputStream(archivos);
               Os.writeObject(material);
               Os.close();
               archivos.close();
               
           } catch (FileNotFoundException ex) {
               Logger.getLogger(operaciones.class.getName()).log(Level.SEVERE, null, ex);
           }
           catch(IOException ex){
               Logger.getLogger(operaciones.class.getName()).log(Level.SEVERE, null, ex);
           }        
        System.out.println("guardado");
    }}
    
           public void lista_material(){
           String ruta = "D:\\INFORMATICA\\informatica_2021\\PROG_III_2021\\Arch_maven\\lista_biblioteca.txt";
           try {
               FileInputStream archivos = new FileInputStream(ruta);
               ObjectInputStream op = new ObjectInputStream(archivos);
               if(op != null){
                   material = (List<Material_bibliografico>)op.readObject();                   
               }else{
                   System.out.println("NO HAY REGISTRO ALGUNO");
               }
           } catch (FileNotFoundException e) {
               Logger.getLogger(operaciones.class.getName()).log(Level.SEVERE , null, e);
           } catch(IOException ex){
                Logger.getLogger(operaciones.class.getName()).log(Level.SEVERE, null, ex);
           } catch(ClassNotFoundException ex){
                Logger.getLogger(operaciones.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
        //MOSTRAR   
           public void muestra_libro(){
            lista_material();
           if(material != null){
               System.out.println("libros en biblioteca");
               for(Material_bibliografico m:material){
                  if(m instanceof libro){
                      //casteo
                      libro l=(libro) m;
                      l.mostrar();                  
                  }
                  if(m instanceof proyecto_grado){
                      //casteo
                      proyecto_grado p=(proyecto_grado) m;
                      p.mostrar();                  
                  }
               }               
           }
       }

        public void buscar(String mat){
            lista_material();
            for(Material_bibliografico m:material){
                  if(m instanceof libro){
                      //casteo
                      libro l=(libro) m;
                      if(l.getTitulo().equalsIgnoreCase(mat)){
                      l.mostrar();                  }
                  }
                  if(m instanceof proyecto_grado){
                      //casteo
                      proyecto_grado p=(proyecto_grado) m;
                                            if(p.getTitulo().equalsIgnoreCase(mat)){
                      p.mostrar();                  }
                                       
                  }
               } 
        }
        public void eliminar(String elim){
            int sw=0;
            lista_material(); 
            
            
        }
}

