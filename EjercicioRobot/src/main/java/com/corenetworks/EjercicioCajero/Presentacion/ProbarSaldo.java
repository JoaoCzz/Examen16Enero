package com.corenetworks.EjercicioCajero.Presentacion;

import com.corenetworks.EjercicioCajero.Persistencia.AccesoCuentaBancaria;

import java.sql.SQLException;

public class ProbarSaldo {
    public static void main(String[] args) {
        AccesoCuentaBancaria ac= new AccesoCuentaBancaria();
        try {
            System.out.println(ac.SolicitarSaldo("12345"));
        } catch (SQLException e) {
            System.out.println(e.toString());
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        }

        try {
            System.out.println(ac.Obtenerpin("12345"));
        } catch (SQLException e) {
            System.out.println(e.toString());
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());        }
        try {
            ac.ActualizarSaldo("12345",300);
        } catch (SQLException e) {
            System.out.println(e.toString());
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        }

    }


}
