package com.corenetworks.EjercicioCajero.Modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CuentaBancaria {
    private String nmCuenta;
    private String tOperacion;
    private double cantidad;


}
