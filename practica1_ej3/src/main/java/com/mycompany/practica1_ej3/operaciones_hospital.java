/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practica1_ej3;

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
public class operaciones_hospital {
     private especialidad esp;
    private hospital hosp;
    List<hospital> lista_hosp;
    Scanner lee2=new Scanner (System.in);

    public operaciones_hospital() { 
        //llama los emtodos para crear directorio y archivo
        crearDir();
        crearArch();
        lista_hosp=new ArrayList<>();
        hosp=new hospital();
    }
    
    
    public void crear_esp() {
        esp = new especialidad();
        System.out.println("nombre especialidad");
        String n = lee2.nextLine();
        esp.setNombre_Especialidad(n);
        hosp.adicionar_especialidad(esp);
    }
    
    public void crear_hosp(){
        
        System.out.println("NOMBRE DE HOSPITAL");
        String nh = lee2.nextLine();
        hosp.setNombrehosp(nh);        
        System.out.println("DIRECCION");
        String ar = lee2.nextLine();
        hosp.setDirec(ar);
        System.out.println("NIVEL");
        int niv = lee2.nextInt();
        hosp.setNivel(niv);
    }
    
    public void almacena_hosp(){
        lista_hosp.add(hosp);
        System.out.println("hospital almacenado");
        guardar_datos();//en archivo txt
    }
    
    
    public void mostrar_esp_hosp(String a){
        lee_datos();
        for(hospital al:lista_hosp){
            if(al.getNombrehosp().equalsIgnoreCase(a)){
            al.mostrar();
            System.out.println("-------------especialdiades-----------------");
            for(especialidad c:al.getLista_especialidad()){
            c.mostrar();
            }}
        }
    }
    public void buscar_hosp_esp(String ca){
        System.out.println("buscando");
        lee_datos();
        for(hospital al:lista_hosp){            
            for(especialidad c:al.getLista_especialidad()){
                System.out.println("hospitales con al especialdiad buscada");
            if(c.getNombre_Especialidad().equalsIgnoreCase(ca)){
                System.out.println("HOSPITAL::"+al.getNombrehosp());
                System.out.println("DIRECCION::"+al.getDirec());
                }
            }}
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
        path=Paths.get("D:\\INFORMATICA\\informatica_2021\\PROG_III_2021\\Arch_maven\\lista_hospital.txt");
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
           String ruta = "D:\\INFORMATICA\\informatica_2021\\PROG_III_2021\\Arch_maven\\lista_hospital.txt";
           try {
               FileOutputStream arch = new FileOutputStream(ruta);
               ObjectOutputStream o = new ObjectOutputStream(arch);
               o.writeObject(lista_hosp);
               o.close();
               arch.close();
               
           } catch (FileNotFoundException ex) {
               Logger.getLogger(operaciones_hospital.class.getName()).log(Level.SEVERE, null, ex);
           }
           catch(IOException ex){
               Logger.getLogger(operaciones_hospital.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
     //ctrl+chift+c comentar lineas
     //lectura de datos de archivo
     public void lee_datos(){
           String ruta = "D:\\INFORMATICA\\informatica_2021\\PROG_III_2021\\Arch_maven\\lista_hospital.txt";
           try {
               FileInputStream archivos = new FileInputStream(ruta);
               ObjectInputStream op = new ObjectInputStream(archivos);
               if(op != null){
                 lista_hosp= (List<hospital>)op.readObject();
               }else{
                   System.out.println("NO HAY REGISTRO ALGUNO");
               }
           } catch (FileNotFoundException e) {
               Logger.getLogger(operaciones_hospital.class.getName()).log(Level.SEVERE , null, e);
           } catch(IOException ex){
                Logger.getLogger(operaciones_hospital.class.getName()).log(Level.SEVERE, null, ex);
           } catch(ClassNotFoundException ex){
                Logger.getLogger(operaciones_hospital.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    
    

}
