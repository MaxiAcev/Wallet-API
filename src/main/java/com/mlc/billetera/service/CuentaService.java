package com.mlc.billetera.service;

import com.mlc.billetera.model.Cuenta;
import com.mlc.billetera.model.Usuario;
import com.mlc.billetera.repository.CuentaRepository;
import com.mlc.billetera.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CuentaService {
    private final CuentaRepository cuentaRepository;
    private final UsuarioRepository usuarioRepository;

    public CuentaService(CuentaRepository cuentaRepository, UsuarioRepository usuarioRepository) {
        this.cuentaRepository = cuentaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public Cuenta crearCuenta(Long idUsuario, Cuenta cuenta) {
        Usuario usuarioNoEncontrado = usuarioRepository.findById(idUsuario)
                .orElseThrow(()-> new RuntimeException("Usuario no encontrado📛👤"));
        cuenta.setUsuario(usuarioNoEncontrado);

        if (cuenta.getSaldo() == null) {
            cuenta.setSaldo(BigDecimal.ZERO);
        }
        return cuentaRepository.save(cuenta);
    }

    public Optional<Cuenta> obtenerPorCbu(String cbu) {
        return cuentaRepository.findByCbu(cbu);
    }

    public List<Cuenta> obtenerCuentasPorUsuario(Long idUsuario) {
        return cuentaRepository.findByUsuarioIdUsuario(idUsuario);
    }
}
