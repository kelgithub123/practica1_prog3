/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practica1_ejercicio1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
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
 * @author kelvi
 */
public class operaciones_docente_materia {
    
   Scanner lee2=new Scanner (System.in); 
   private docente doc;
   private materia mat;
   List<docente> docente_txt;


    public operaciones_docente_materia() {
       crearDir();
       crearArch();
       docente_txt=new ArrayList<>(); 
       doc=new docente();
       mat=new materia();
    }
   
   public void regsitra_docente(){
    System.out.println("nombre::");
    String n=lee2.nextLine();
    doc.setNombre(n);
    System.out.println("AP paterno::");
    String ap=lee2.nextLine();   
    doc.setPaterno(ap);
    System.out.println("AP materno::");
       String am=lee2.nextLine();
       doc.setMaterno(am);
       System.out.println("titulo::");
       String tit=lee2.nextLine();
       doc.setTitulo(tit);
       System.out.println("carga horaria::");
       int ch=lee2.nextInt();
       doc.setCarga_horaria(ch);
       docente_txt.add(doc);
       lee2.nextLine();
    }
    
   public void registra_materia(){
        System.out.println("materia::");
        String mater=lee2.nextLine();
        mat.setNom_materia(mater);
        System.out.println("año de materia::");
        int a=lee2.nextInt();
        mat.setAno_materia(a);
        System.out.println("Horas materia::");
        int hm=lee2.nextInt();
        mat.setHoras_Materia(hm);        
   }
   
   public void asignar_materia(){
   doc.setMat(mat);
       System.out.println("asignado!");
   guardar_datos();    
   }

     public void crearDir(){
    Path path;
        path=Paths.get("D:\\INFORMATICA\\informatica_2021\\PROG_III_2021\\Arch_maven");
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
        path=Paths.get("D:\\INFORMATICA\\informatica_2021\\PROG_III_2021\\Arch_maven\\listadocente.txt");
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
     public void guardar_datos(){
           String ruta = "D:\\INFORMATICA\\informatica_2021\\PROG_III_2021\\Arch_maven\\listadocente.txt";
           try {
               FileOutputStream arch = new FileOutputStream(ruta);
               ObjectOutputStream o = new ObjectOutputStream(arch);
               o.writeObject(docente_txt);
               o.close();
               arch.close();
               
           } catch (FileNotFoundException ex) {
               Logger.getLogger(operaciones_docente_materia.class.getName()).log(Level.SEVERE, null, ex);
           }
           catch(IOException ex){
               Logger.getLogger(operaciones_docente_materia.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
     
     public void lee_docentes(){
           String ruta = "D:\\INFORMATICA\\informatica_2021\\PROG_III_2021\\Arch_maven\\listadocente.txt";
           try {
               FileInputStream archivos = new FileInputStream(ruta);
               ObjectInputStream op = new ObjectInputStream(archivos);
               if(op != null){
                 docente_txt= (List<docente>)op.readObject();
               }else{
                   System.out.println("NO HAY REGISTRO ALGUNO");
               }
           } catch (FileNotFoundException e) {
               Logger.getLogger(operaciones_docente_materia.class.getName()).log(Level.SEVERE , null, e);
           } catch(IOException ex){
                Logger.getLogger(operaciones_docente_materia.class.getName()).log(Level.SEVERE, null, ex);
           } catch(ClassNotFoundException ex){
                Logger.getLogger(operaciones_docente_materia.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
     
     public void mostrar_docente(){
     lee_docentes();
         System.out.println("-----------------------");
     for(docente d:docente_txt){
         d.mostrar_doc();
         //obtiene docente muestra sus datos 
         //obtiene el atributo de materia, y muestra propiedades de materia
         d.getMat().mostrar_mat();
     }
         System.out.println("-----------------------");
     }
}
