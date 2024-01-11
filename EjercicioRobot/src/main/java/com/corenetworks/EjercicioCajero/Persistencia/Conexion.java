package com.corenetworks.EjercicioCajero.Persistencia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Conexion {

        //1 Atributos
        protected Connection miConexion;

        //2 Metodos
        public void abrirConexion() throws ClassNotFoundException, SQLException {
            Class.forName("org.postgresql.Driver");
            miConexion = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5432/BancoCore",
                    "postgres", "postgres");
            System.out.println("Exito en la primera conexión");

        }
    }


