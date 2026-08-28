package com.mlc.billetera.dto;

import java.math.BigDecimal;

public class DepositoDTO {
    private String cbu;
    private BigDecimal monto;

    public DepositoDTO(){}

    public DepositoDTO(String cbu, BigDecimal monto) {
        this.cbu = cbu;
        this.monto = monto;
    }

    public String getCbu() {
        return cbu;
    }

    public void setCbu(String cbuOrigen) {
        this.cbu = cbuOrigen;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }
}
