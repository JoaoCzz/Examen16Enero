package com.corenetworks.Ejercicio1;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File f1 = new File("C:\\Users\\tarde\\Documents\\Joao\\Ejercicio1.rar");
        System.out.println("Nombre del archivo ->" + f1.getName());
        System.out.println("Ruta absoluta -> "+ f1.getAbsolutePath());
        System.out.println("Es una carpeta ?" + f1.isDirectory());
        System.out.println("Es un fichero ? "+ f1.isFile());
        System.out.println("Ultima modificación ->"+ f1.lastModified());
        System.out.println("Existe ? "+ f1.exists());
    }
}