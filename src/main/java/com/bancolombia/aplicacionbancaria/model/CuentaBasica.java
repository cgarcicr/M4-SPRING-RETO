package com.bancolombia.aplicacionbancaria.model;

import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
public class CuentaBasica extends Cuenta{

    private static final BigDecimal COMISION = new BigDecimal("5.00");

    public CuentaBasica() {
    }

    public CuentaBasica(BigDecimal saldo, String numeroCuenta) {
        super(saldo, numeroCuenta);
    }

    @Override
    public void aplicarComision() {
        setSaldo(getSaldo().subtract(COMISION));
    }

    @Override
    public void depositarSucursal(BigDecimal monto) {

    }

    @Override
    public void depositarCajero(BigDecimal monto) {

    }

    @Override
    public void depositarOtraCuenta(BigDecimal monto) {

    }

    @Override
    public void compraFisica(BigDecimal monto) {

    }

    @Override
    public void compraWeb(BigDecimal monto) {

    }

    @Override
    public void retirarCajero(BigDecimal monto) {

    }

}
