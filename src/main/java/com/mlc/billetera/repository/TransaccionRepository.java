package com.mlc.billetera.repository;

import com.mlc.billetera.model.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransaccionRepository extends JpaRepository<Transaccion,Long> {
    @Query("SELECT t FROM Transaccion t WHERE t.cuentaOrigen.idCuenta = :idOrigen OR t.cuentaDestino.idCuenta = :idDestino")
    List<Transaccion> findByCuentaOriCuentaDest(@Param("idOrigen") Long idOrigen, @Param("idDestino") Long idDestino);
}
