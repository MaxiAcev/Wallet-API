package com.mlc.billetera.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "cuentas")
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCuenta;

    @Column(name = "cbu", nullable = false, unique = true)
    private String cbu;

    @Column(name = "saldo" , nullable = false)
    private BigDecimal saldo;

    @Column(name = "tipo_moneda", nullable = false)
    private String tipoMoneda;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    public Cuenta() {}

    public Cuenta(String cbu, BigDecimal saldo, String tipoMoneda, Usuario usuario) {
        this.cbu = cbu;
        this.saldo = saldo;
        this.tipoMoneda = tipoMoneda;
        this.usuario = usuario;
    }

    public Long getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Long idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getCbu() {
        return cbu;
    }

    public void setCbu(String cbu) {
        this.cbu = cbu;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public String getTipoMoneda() {
        return tipoMoneda;
    }

    public void setTipoMoneda(String tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
