package com.mlc.billetera.repository;

import com.mlc.billetera.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CuentaRepository extends JpaRepository<Cuenta,Long> {
    Optional<Cuenta> findByCbu(String cbu);
    List<Cuenta> findByUsuarioIdUsuario(Long idUsuario);
}
