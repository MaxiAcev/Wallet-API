package com.mlc.billetera.controller;

import com.mlc.billetera.dto.DepositoDTO;
import com.mlc.billetera.dto.RetiroDTO;
import com.mlc.billetera.dto.TransferenciaDTO;
import com.mlc.billetera.model.Transaccion;
import com.mlc.billetera.service.TransaccionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transacciones")
public class TransaccionController {
    private final TransaccionService transaccionService;

    public  TransaccionController(TransaccionService transaccionService) {
        this.transaccionService = transaccionService;
    }

    @PostMapping("/deposito")
    public Transaccion depositar(@RequestBody DepositoDTO depositoDTO) {
        return transaccionService.realizarDeposito(depositoDTO.getCbu(), depositoDTO.getMonto());
    }


    @PostMapping("/retiro")
    public Transaccion retirar(@RequestBody RetiroDTO retiroDTO) {
        return transaccionService.realizarRetiro(retiroDTO.getCbu(), retiroDTO.getMonto());
    }

    @PostMapping("/transferencia")
    public Transaccion transferir(@RequestBody TransferenciaDTO tranferenciaDTO) {
        return transaccionService.realizarTransferencia(tranferenciaDTO.getCbuOrigen(), tranferenciaDTO.getCbuDestino(), tranferenciaDTO.getMonto());
    }


    @GetMapping("/historial/{idCuenta}")
    public List<Transaccion> obtenerHistorial(@PathVariable Long idCuenta){
        return transaccionService.obtenerHistotial(idCuenta);
    }
}
