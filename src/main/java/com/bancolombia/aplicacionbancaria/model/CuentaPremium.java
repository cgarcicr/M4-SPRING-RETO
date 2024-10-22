package com.bancolombia.aplicacionbancaria.model;

import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
public class CuentaPremium extends Cuenta{

    public CuentaPremium() {
    }

    public CuentaPremium(BigDecimal saldo, String numeroCuenta) {
        super(saldo, numeroCuenta);
    }

    @Override
    public void aplicarComision() {
        // No se aplica comisión en cuentas premium
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
