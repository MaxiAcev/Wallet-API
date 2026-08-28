package com.mlc.billetera.service;

import com.mlc.billetera.model.Cuenta;
import com.mlc.billetera.model.TipoTransaccion;
import com.mlc.billetera.model.Transaccion;
import com.mlc.billetera.repository.CuentaRepository;
import com.mlc.billetera.repository.TransaccionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransaccionService {
    private final CuentaRepository cuentaRepository;
    private final TransaccionRepository transaccionRepository;

    public TransaccionService(CuentaRepository cuentaRepository, TransaccionRepository transaccionRepository) {
        this.cuentaRepository = cuentaRepository;
        this.transaccionRepository = transaccionRepository;
    }

    @Transactional
    public Transaccion realizarDeposito(String cbuDestino, BigDecimal monto){
        if (monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("❌El monto a depositar debe ser mayor a cero(0)💸");
        }

        Cuenta cuenta = cuentaRepository.findByCbu(cbuDestino)
                .orElseThrow(() -> new RuntimeException("Cuenta de destino no encontrada🔍"));

        BigDecimal nuevoSaldo = cuenta.getSaldo().add(monto);
        cuenta.setSaldo(nuevoSaldo);
        cuentaRepository.save(cuenta);

        Transaccion transaccion = new Transaccion(monto, TipoTransaccion.DEPOSITO, null, cuenta);
        return transaccionRepository.save(transaccion);
    }

    @Transactional
    public Transaccion realizarRetiro(String cbuRetiro, BigDecimal monto){
        if (monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("❌El monto a retirar ser mayor a cero(0)🪙");
        }

        Cuenta cuenta = cuentaRepository.findByCbu(cbuRetiro)
                .orElseThrow(() -> new RuntimeException("La cuenta no existe📛🔍"));

        if (cuenta.getSaldo().compareTo(monto) < 0) {
            throw new RuntimeException("No puede retirar dinero, su saldo es insuficiente");
        }

        BigDecimal saldoDescont = cuenta.getSaldo().subtract(monto);
        cuenta.setSaldo(saldoDescont);
        cuentaRepository.save(cuenta);

        Transaccion transaccion = new Transaccion(monto, TipoTransaccion.RETIRO, cuenta, null);
        return transaccionRepository.save(transaccion);
    }

    @Transactional
    public Transaccion realizarTransferencia(String cbuDestino,String cbuOrigen, BigDecimal monto){
        if (cbuDestino.equals(cbuOrigen)) {
            throw new RuntimeException("El CBU de origen no puede ser igual al de destino🧾");
        }

        if (monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("El monto a transferir debe ser mayor a cero(0)🪙");
        }

        Cuenta cuenta = cuentaRepository.findByCbu(cbuOrigen)
                .orElseThrow(() -> new RuntimeException("El CBU de origen no existe, intente nuevamente🧾"));
        Cuenta cuentaDos = cuentaRepository.findByCbu(cbuDestino)
                .orElseThrow(() -> new RuntimeException("El CBU de destino no existe, intente nuevamente🧾"));

        if (cuenta.getSaldo().compareTo(monto) < 0) {
            throw new RuntimeException("Saldo insuficiente📛💸");
        }

        BigDecimal saldoDescont = cuenta.getSaldo().subtract(monto);
        cuenta.setSaldo(saldoDescont);
        cuentaRepository.save(cuenta);

        BigDecimal montoTransf = cuentaDos.getSaldo().add(monto);
        cuentaDos.setSaldo(montoTransf);
        cuentaRepository.save(cuentaDos);

        Transaccion transaccion = new Transaccion(monto, TipoTransaccion.TRANSFERENCIA, cuenta, cuentaDos);
        return transaccionRepository.save(transaccion);
    }


    public List<Transaccion> obtenerHistotial(Long idCuenta) {
        return transaccionRepository.findByCuentaOriCuentaDest(idCuenta, idCuenta);
    }

}
