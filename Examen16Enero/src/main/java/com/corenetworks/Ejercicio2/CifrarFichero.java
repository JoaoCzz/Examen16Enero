package com.corenetworks.Ejercicio2;

import java.io.FileWriter;
import java.io.IOException;

public class CifrarFichero {
    public static void main(String[] args) {
        try( FileWriter f1 = new FileWriter("origen.txt");) {
f1.write("Ejercicio del examen");
        } catch (IOException e) {
            System.out.println(e.toString());
        }

    }
}
