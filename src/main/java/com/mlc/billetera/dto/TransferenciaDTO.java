package com.mlc.billetera.dto;

import java.math.BigDecimal;

public class TransferenciaDTO {
    private String cbuOrigen;
    private String cbuDestino;
    private BigDecimal monto;

    public TransferenciaDTO() {}

    public TransferenciaDTO(String cbuOrigen, String cbuDestino, BigDecimal monto) {
        this.cbuOrigen = cbuOrigen;
        this.cbuDestino = cbuDestino;
        this.monto = monto;
    }

    public String getCbuOrigen() {
        return cbuOrigen;
    }

    public void setCbuOrigen(String cbuOrigen) {
        this.cbuOrigen = cbuOrigen;
    }

    public String getCbuDestino() {
        return cbuDestino;
    }

    public void setCbuDestino(String cbuDestino) {
        this.cbuDestino = cbuDestino;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }
}
