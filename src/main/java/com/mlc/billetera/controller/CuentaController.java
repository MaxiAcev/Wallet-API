package com.mlc.billetera.controller;

import com.mlc.billetera.model.Cuenta;
import com.mlc.billetera.service.CuentaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cuentas")
public class CuentaController {
    private final CuentaService cuentaService;

    public CuentaController(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    @PostMapping("/usuario/{idUsuario}")
    public Cuenta crearCuenta(@PathVariable Long idUsuario, @RequestBody Cuenta cuenta) {
        return cuentaService.crearCuenta(idUsuario, cuenta);
    }

    @GetMapping("/usuario/{idUsuario}")
    public List<Cuenta> obtenerPorUsuario(@PathVariable Long idUsuario) {
        return cuentaService.obtenerCuentasPorUsuario(idUsuario);
    }

    @GetMapping("/cbu/{cbu}")
    public Optional<Cuenta> obtenerPorCbu(@PathVariable String cbu) {
        return cuentaService.obtenerPorCbu(cbu);
    }
}
