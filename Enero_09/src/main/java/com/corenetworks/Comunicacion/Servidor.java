package com.corenetworks.Comunicacion;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        PrintWriter fw = null;
        BufferedReader bf;


        try(ServerSocket servidor = new ServerSocket(3001);) {
            while (true) {
                System.out.println("En espera...");
                Socket s1 = servidor.accept();
                bf = new BufferedReader(new InputStreamReader(s1.getInputStream()));
                System.out.println(bf.readLine());
                PrintWriter sRespuesta = new PrintWriter(s1.getOutputStream(),true);
                sRespuesta.println("Listo");
            }
        } catch (IOException e) {
            System.out.println(e.toString());


        }
    }
}



