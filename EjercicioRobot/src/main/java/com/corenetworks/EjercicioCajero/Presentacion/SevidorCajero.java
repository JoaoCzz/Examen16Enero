package com.corenetworks.EjercicioCajero.Presentacion;

import com.corenetworks.EjercicioCajero.Persistencia.AccesoCuentaBancaria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Arrays;

public class SevidorCajero {
    private static  double saldo;
    public static void main(String[] args) {
AccesoCuentaBancaria acb= new AccesoCuentaBancaria();
        String[] datos=null;
        try (ServerSocket servidor= new ServerSocket(3000);){
            while (true){
                System.out.println("Esperando peticion");
                Socket s1= servidor.accept();
                BufferedReader MaR= new BufferedReader(new InputStreamReader(s1.getInputStream()));
                datos =MaR.readLine().split(",");
                double cantidad= Double.parseDouble(datos[2]);
                System.out.println(Arrays.toString(datos));
                AccesoCuentaBancaria ac= new AccesoCuentaBancaria();
                saldo= ac.SolicitarSaldo(datos[1]);
                PrintWriter MaE= new PrintWriter(s1.getOutputStream(),true);

                switch (datos[0]){
                    case "1":
                        MaE.println("Su saldo es--->" +saldo);
                        break;
                    case "2":
                        if (saldo >= cantidad){
                            acb.ActualizarSaldo(datos[1],cantidad *-1);
                            MaE.println("Has retirado" + cantidad);
                            MaE.println("Tu saldo es-->" +saldo);

                        }else{
                            MaE.println("Saldo insuficiente");
                        }
                        break;
                    case "3":
                        MaE.println("Has sumado" + cantidad);
                        acb.ActualizarSaldo(datos[1],cantidad *-1);
                        MaE.println("Tu saldo es-->" +saldo);
                        break;
                }

            }



        } catch (IOException e) {
            System.out.println(e.toString());
        } catch (SQLException e) {
            System.out.println(e.toString());        }
        catch (ClassNotFoundException e) {
            System.out.println(e.toString());        }
    }


}
