package com.corenetworks.Persistencia;

import com.corenetworks.Modelo.Socio;

import java.sql.SQLException;
import java.sql.Statement;

public class AccesoSocios extends Conexion{
    public boolean alta(Socio s) throws SQLException, ClassNotFoundException {
        Statement sentencia;
        int resultado=0;
        String sql= "insert into socios (carnet,dni)values('"+ s.getCarnet() + "','" + s.getDni() + "');";
        abrirConexion();
        sentencia= miConexion.createStatement();
        resultado= sentencia.executeUpdate(sql);
return resultado>0;
    }

}
