package com.bancolombia.aplicacionbancaria.controller;

import com.bancolombia.aplicacionbancaria.model.*;
import com.bancolombia.aplicacionbancaria.service.CuentaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {

    private final CuentaService cuentaService;

    public CuentaController(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    @GetMapping("/saldo")
    public BigDecimal obtenerSaldo(@Valid @RequestBody CuentaDTO cuentaDTO) {
        return cuentaService.obtenerSaldo(cuentaDTO);
    }

    @GetMapping("/transacciones/{numeroCuenta}")
    public List<Transaccion> obtenerUltimasTransacciones(@PathVariable Long numeroCuenta) {
        return cuentaService.obtenerUltimasTransacciones(numeroCuenta);
    }

    @PostMapping("/depositarSucursal")
    public BigDecimal depositarSucursal(@Valid @RequestBody DepositoDTO depositoDTO) {
        return cuentaService.depositarSucursal(depositoDTO);
    }

    @PostMapping("/depositarCajero")
    public BigDecimal depositarCajero(@Valid @RequestBody DepositoDTO depositoDTO) {
        return cuentaService.depositarCajero(depositoDTO);
    }

    @PostMapping("/depositarOtraCuenta")
    public BigDecimal depositarOtraCuenta(@Valid @RequestBody DepositoDTO depositoDTO) {
        return cuentaService.depositarOtraCuenta(depositoDTO);
    }

    @PostMapping("/compraFisica")
    public BigDecimal compraFisica(@Valid @RequestBody CompraDTO compraDTO) {
        return cuentaService.compraFisica(compraDTO);
    }

    @PostMapping("/compraWeb")
    public BigDecimal compraWeb(@Valid @RequestBody CompraDTO compraDTO) {
        return cuentaService.compraWeb(compraDTO);
    }

    @PostMapping("/retirarCajero")
    public BigDecimal retirarCajero(@Valid @RequestBody RetiroDTO retiroDTO) {
        return cuentaService.retirarCajero(retiroDTO);
    }


}
