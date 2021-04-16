/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practica1_ej2;

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
 * @author kelvi
 */
public class operaciones_album {
    private Cancion can;
    private album alb;
    List<album> discos;
    Scanner lee2=new Scanner (System.in);

    public operaciones_album() { 
        //llama los emtodos para crear directorio y archivo
        crearDir();
        crearArch();
        discos=new ArrayList<>();
        alb=new album();
    }
    
    
    public void crearCancion() {
        can = new Cancion();
        System.out.println("nombre");
        String n = lee2.nextLine();
        can.setNombreCancion(n);
        System.out.println("genero");
        String g = lee2.nextLine();
        can.setGenero(g);
        System.out.println("duracion");
        float d = lee2.nextFloat();
        can.setDuracion(d);
        lee2.nextLine();
        //adicionando la cancion a album
        alb.adicionar_cancion(can);
    }
    
    public void crear_album(){
        
        System.out.println("ALBUM");
        String al = lee2.nextLine();
        alb.setNombre(al);
        System.out.println("ARTISTA");
        String ar = lee2.nextLine();
        alb.setArtista(ar);
        System.out.println("FORMATO");
        String f = lee2.nextLine();
        alb.setFormato(f);
    }
    
    public void almacena_album(){
        discos.add(alb);
        System.out.println("album almacenado");
        guardar_datos();//en archivo txt
    }
    
    public void mostrar_discos(){
        lee_datos();//de archivo txt
        for(album al:discos){
            al.mostrar();
            System.out.println("-------------canciones-----------------");
            for(Cancion c:al.getLista_temas()){
            c.mostrar();
            }
        }
    }
    
    //operaciones de archivo, crear directorio,crear archivo.txt y gusardar datos serializables que significa que 
    //para el guardado de transformaran en binario y cuando se recuperaran se lo hara tamienen binario que luego sera convertido a formato de programa
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
        path=Paths.get("D:\\INFORMATICA\\informatica_2021\\PROG_III_2021\\Arch_maven\\lista_album.txt");
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
           String ruta = "D:\\INFORMATICA\\informatica_2021\\PROG_III_2021\\Arch_maven\\lista_album.txt";
           try {
               FileOutputStream arch = new FileOutputStream(ruta);
               ObjectOutputStream o = new ObjectOutputStream(arch);
               o.writeObject(discos);
               o.close();
               arch.close();
               
           } catch (FileNotFoundException ex) {
               Logger.getLogger(operaciones_album.class.getName()).log(Level.SEVERE, null, ex);
           }
           catch(IOException ex){
               Logger.getLogger(operaciones_album.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
     //ctrl+chift+c comentar lineas
     //lectura de datos de archivo
     public void lee_datos(){
           String ruta = "D:\\INFORMATICA\\informatica_2021\\PROG_III_2021\\Arch_maven\\lista_album.txt";
           try {
               FileInputStream archivos = new FileInputStream(ruta);
               ObjectInputStream op = new ObjectInputStream(archivos);
               if(op != null){
                 discos= (List<album>)op.readObject();
               }else{
                   System.out.println("NO HAY REGISTRO ALGUNO");
               }
           } catch (FileNotFoundException e) {
               Logger.getLogger(operaciones_album.class.getName()).log(Level.SEVERE , null, e);
           } catch(IOException ex){
                Logger.getLogger(operaciones_album.class.getName()).log(Level.SEVERE, null, ex);
           } catch(ClassNotFoundException ex){
                Logger.getLogger(operaciones_album.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    
    
}
