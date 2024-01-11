package com.corenetworks.EjercicioCajero.Presentacion;

import com.corenetworks.EjercicioCajero.Modelo.CuentaBancaria;
import com.corenetworks.EjercicioCajero.Persistencia.AccesoCuentaBancaria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.Scanner;

public class ClienteCajero {
    private static Scanner teclado = new Scanner(System.in);
    private static CuentaBancaria CB1 = new CuentaBancaria();
    private static String cuenta;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        if (solicitarPIN()) {
            while (true) {
                CuentaBancaria cB1 = solicitarDatos();
                if (cB1.getTOperacion() == null) {
                    break;
                }
                System.out.println(cB1.toString());
                try (Socket cliente = new Socket("localhost", 3000);) {
                    PrintWriter MaE = new PrintWriter(cliente.getOutputStream(), true);
                    MaE.println(cB1.getTOperacion() + "," + cB1.getNmCuenta() + "," + cB1.getCantidad());
                    System.out.println("Esperando respuesta del servidor");
                    try (BufferedReader MaR = new BufferedReader(new InputStreamReader(cliente.getInputStream()));) {
                        System.out.println(MaR.readLine());
                    }
                } catch (UnknownHostException e) {
                    System.out.println(e.toString());
                } catch (IOException e) {
                    System.out.println(e.toString());
                }
            }
        }
    }

    private static boolean solicitarPIN() throws SQLException, ClassNotFoundException {
        AccesoCuentaBancaria ac= new AccesoCuentaBancaria();
        System.out.printf("Escribir Cuenta --> ");
        cuenta=teclado.nextLine();
        int contador = 0;
        String pin = null;
        while (true) {
            System.out.println("Escriba el PIN");
            pin = teclado.nextLine();
            if (pin.equals(ac.Obtenerpin(cuenta))) {
                return true;
            } else {
                System.out.println("PIN INCORRECTO");
                contador++;
                if (contador == 3) {
                    System.out.println("Recoje tu tarjeta en una de nuestras sucursales");
                    return false;
                }
            }
        }
    }

    private static CuentaBancaria solicitarDatos() {
        int tipoOperacion = 0;
        while (true) {
            System.out.printf("%s %n", "-".repeat(50));
            System.out.printf("%s %n", "MENU BANCARIO");
            System.out.printf("%s %n", "-".repeat(50));
            System.out.printf("%s %n", "1)Consultar Saldo");
            System.out.printf("%s %n", "2) Retirar una cantidad");
            System.out.printf("%s %n", "3) Ingresar una cantidad");
            System.out.printf("%s %n", "4) Salir");
            System.out.printf("Escribir su opcion --->");
            tipoOperacion = teclado.nextInt();
            teclado.nextLine();
            switch (tipoOperacion) {
                case 1:
                    System.out.println(CB1.getCantidad());
                    break;
                case 2:
                    System.out.printf("Escribir la cantidad que desea retirar --->");
                    CB1.setCantidad(teclado.nextDouble());
                    break;
                case 3:
                    System.out.printf("Escribir la cantidad que desea ingresar --->");
                    CB1.setCantidad(teclado.nextDouble());
                    teclado.nextLine();
                    break;
                default:
                    System.out.println("Adios");
                    break;

            }
            CB1.setTOperacion(Integer.toString(tipoOperacion));
            return CB1;
        }
    }
}






