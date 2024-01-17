package com.corenetworks.Ejercicio2;
import java.io.*;

public class Leer {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String AO = br.readLine();
            String AD = br.readLine();

            System.out.print("Ingrese un valor numérico entre 1 y 255: ");
            int num = Integer.parseInt(br.readLine());

            if (num < 1 || num > 255) {
                System.out.println("No esta entre 1  y 255 chao");
                return;
            }

            encriptarArchivo(AO, AD, num);

            System.out.println(" Ha sido cifrado");
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private static void encriptarArchivo(String archivoOrigen, String AD, int num) throws IOException {
        try (FileReader fr = new FileReader(archivoOrigen);
             FileWriter fw = new FileWriter(AD)) {

            int Char;
            while ((Char = fr.read()) != -1) {
                int aEncriptar = Char ^ num;
                fw.write(aEncriptar);
            }
        }
    }

    }

