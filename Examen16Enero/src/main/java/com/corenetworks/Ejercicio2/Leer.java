package com.corenetworks.Ejercicio2;

import com.sun.source.tree.LambdaExpressionTree;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Leer {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Pon un numero");
        int respuesta = teclado.nextInt();
        if (respuesta >= 0 && respuesta <= 255) {
            try {
                FileReader fr = new FileReader("origen.txt");
                while (true){
                    int letra=0;
                    letra= (char) fr.read();
                    if((char)letra==respuesta){
                        System.out.println((char)letra);
                        break;
                    }else {
                        System.out.println("No");
                        break;
                }
                    }


            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else {
            System.out.println("No esta en los digitos permitidos");
        }


    }
}
