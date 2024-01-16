package com.corenetworks.Ejercicio3;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDate;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        String Cuenta= "1234567891234584";
        String CVV= "244";
        String expira= "20240502";
        String dia= "20242116";
        double Cantidad= 3000;

        try (Socket s1 = new Socket("localhost",3000);){
            PrintWriter p1= new PrintWriter(s1.getOutputStream(),true);
            p1.printf("%s,%s,%s,%s,%.2f",dia,Cuenta,expira,CVV,Cantidad);
            p1.println(dia+","+Cuenta+","+expira+","+CVV+","+Cantidad);
            System.out.println("Esperando respuesta del servidor");
            BufferedReader MaR = new BufferedReader(new InputStreamReader(s1.getInputStream()));
            System.out.printf(MaR.readLine());
        } catch (IOException e) {
            System.out.println(e.toString());        }
    }
    }

