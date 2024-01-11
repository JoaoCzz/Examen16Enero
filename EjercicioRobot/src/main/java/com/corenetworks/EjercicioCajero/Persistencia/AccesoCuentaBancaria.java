package com.corenetworks.EjercicioCajero.Persistencia;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccesoCuentaBancaria extends Conexion{
    public double SolicitarSaldo(String ntarjeta) throws SQLException, ClassNotFoundException {
        PreparedStatement sentencia=null;
        String sql= "Select saldo from cuenta_bancaria where no_tarjeta = ?";
        double resultado=0;
        ResultSet rejilla= null;
        abrirConexion();
        sentencia= miConexion.prepareStatement(sql);
        sentencia.setString(1,ntarjeta);
        rejilla= sentencia.executeQuery();

        if (rejilla.next()){
            resultado = Double.parseDouble(rejilla.getString("saldo").replace("€","").replace(".","").replace(",","."));
            System.out.println(rejilla.getBigDecimal("saldo"));
        }
return resultado;
    }
    public String Obtenerpin(String ntarjeta) throws SQLException, ClassNotFoundException {
        PreparedStatement sentencia=null;
        String sql= "Select pin from cuenta_bancaria where no_tarjeta = ?";
         String resultado=null;
        ResultSet rejilla= null;
        abrirConexion();
        sentencia= miConexion.prepareStatement(sql);
        sentencia.setString(1,ntarjeta);
        rejilla= sentencia.executeQuery();

        if (rejilla.next()){
            resultado = rejilla.getString("pin");
        }
        return resultado;
    }
    public void ActualizarSaldo(String ntarjeta, double cantidad) throws SQLException, ClassNotFoundException {
        PreparedStatement sentencia=null;
        String sql= "UPDATE cuenta_bancaria set saldo = saldo + cast(? as money) where no_tarjeta = ?";
        abrirConexion();
        sentencia= miConexion.prepareStatement(sql);
        sentencia.setBigDecimal(1,new BigDecimal(cantidad));
        sentencia.setString(2,ntarjeta);
        sentencia.executeQuery();
    }

}
