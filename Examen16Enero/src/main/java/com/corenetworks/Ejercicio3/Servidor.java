package com.corenetworks.Ejercicio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Random;

public class Servidor {
    public static void main(String[] args) {
        Random Autorizacion= new Random();
        String datos[]=null;
        String codigo;
        try {
            ServerSocket s1= new ServerSocket(3000);
            while (true){
                System.out.println("Esperando");
                Socket so1= s1.accept();
                BufferedReader br= new BufferedReader(new InputStreamReader(so1.getInputStream()));
                datos= br.readLine().split(",");
                PrintWriter MaE= new PrintWriter(so1.getOutputStream(),true);
                double cantidad= Double.parseDouble(datos[4]);
                System.out.println(Arrays.toString(datos));
               switch (Autorizacion.nextInt(0,3)){
                   case 0:
                       codigo="0000";
                       MaE.println(datos[0]+"Transaccion Aceptada "+codigo+" "+datos[1]);
                       break;
                   case 1:
                       codigo="9137";
                       MaE.println(datos[0]+"Error al intentar validar la tarjeta "+ codigo+" "+datos[1]);
                        break;
                   case 2:
                      codigo="9221";
                      MaE.println(datos[0]+" El cliente no esta introduciendo el CVV "+ codigo+" "+datos[1]);
                       break;
                   case 3:
                       codigo="9677";
                       MaE.println(datos[0]+" Saldo Insuficiente " +codigo +" "+datos[1]);
                       break;


               }


            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
