package com.bancolombia.aplicacionbancaria.service;

import com.bancolombia.aplicacionbancaria.model.*;
import com.bancolombia.aplicacionbancaria.repository.CuentaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CuentaService {

    private final CuentaRepository cuentaRepository;

    public CuentaService(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    public BigDecimal obtenerSaldo(CuentaDTO cuentaDTO) {
        Cuenta cuenta = cuentaRepository.findById(cuentaDTO.getNumeroCuenta())
                .orElseThrow(() -> new IllegalArgumentException("Cuenta no encontrada"));
        return cuenta.getSaldo();
    }

    public BigDecimal depositarSucursal(DepositoDTO depositoDTO) {
        Cuenta cuenta = cuentaRepository.findById(depositoDTO.getNumeroCuenta())
                .orElseThrow(() -> new IllegalArgumentException("Cuenta no encontrada"));
        cuenta.depositarSucursal(depositoDTO.getMonto());
        cuentaRepository.save(cuenta);
        return cuenta.getSaldo();
    }

    public BigDecimal depositarCajero(DepositoDTO depositoDTO) {
        Cuenta cuenta = cuentaRepository.findById(depositoDTO.getNumeroCuenta())
                .orElseThrow(() -> new IllegalArgumentException("Cuenta no encontrada"));
        cuenta.depositarCajero(depositoDTO.getMonto());
        cuentaRepository.save(cuenta);
        return cuenta.getSaldo();
    }

    public BigDecimal depositarOtraCuenta(DepositoDTO depositoDTO) {
        Cuenta cuenta = cuentaRepository.findById(depositoDTO.getNumeroCuenta())
                .orElseThrow(() -> new IllegalArgumentException("Cuenta no encontrada"));
        cuenta.depositarOtraCuenta(depositoDTO.getMonto());
        cuentaRepository.save(cuenta);
        return cuenta.getSaldo();
    }

    public BigDecimal compraFisica(CompraDTO compraDTO) {
        Cuenta cuenta = cuentaRepository.findById(compraDTO.getNumeroCuenta())
                .orElseThrow(() -> new IllegalArgumentException("Cuenta no encontrada"));
        cuenta.compraFisica(compraDTO.getMonto());
        cuentaRepository.save(cuenta);
        return cuenta.getSaldo();
    }

    public BigDecimal compraWeb(CompraDTO compraDTO) {
        Cuenta cuenta = cuentaRepository.findById(compraDTO.getNumeroCuenta())
                .orElseThrow(() -> new IllegalArgumentException("Cuenta no encontrada"));
        cuenta.compraWeb(compraDTO.getMonto());
        cuentaRepository.save(cuenta);
        return cuenta.getSaldo();
    }

    public BigDecimal retirarCajero(RetiroDTO retiroDTO) {
        Cuenta cuenta = cuentaRepository.findById(retiroDTO.getNumeroCuenta())
                .orElseThrow(() -> new IllegalArgumentException("Cuenta no encontrada"));
        cuenta.retirarCajero(retiroDTO.getMonto());
        cuentaRepository.save(cuenta);
        return cuenta.getSaldo();
    }

    public List<Transaccion> obtenerUltimasTransacciones(Long numeroCuenta) {
        Cuenta cuenta = cuentaRepository.findById(numeroCuenta)
                .orElseThrow(() -> new IllegalArgumentException("Cuenta no encontrada"));
        return cuenta.getListaTransacciones().stream()
                .sorted((t1, t2) -> t2.getFechaTransaccion().compareTo(t1.getFechaTransaccion()))
                .limit(5)
                .collect(Collectors.toList());
    }

}
