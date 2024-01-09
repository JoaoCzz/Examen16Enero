package com.corenetworks.Presentacion;

import com.corenetworks.Modelo.Clientes;
import com.corenetworks.Persistencia.AccesoClientes;
import com.corenetworks.Persistencia.AccesoSocios;
import com.corenetworks.Modelo.Clientes;
import com.corenetworks.Persistencia.AccesoClientes;

import java.sql.SQLException;

public class ProbarClientes {
    public static void main(String[] args) {
        AccesoClientes ac1 = new AccesoClientes();
        Clientes c1 = new Clientes("ANDOR", "CORE_NETWORKS", "JOHN");
        Clientes c2 = new Clientes("ANDOR", "NETWORKS_CORE", "JOHN");

        try {
            System.out.println(ac1.insertarUno(c1));
        } catch (SQLException e) {
            System.out.println(e.toString());
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        }
    }
}
