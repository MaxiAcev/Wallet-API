package com.mlc.billetera.dto;

import java.math.BigDecimal;

public class RetiroDTO {
    private String cbu;
    private BigDecimal monto;

    public RetiroDTO(){}

    public RetiroDTO(String cbu, BigDecimal monto) {
        this.cbu = cbu;
        this.monto = monto;
    }

    public String getCbu() {
        return cbu;
    }

    public void setCbu(String cbuDestino) {
        this.cbu = cbuDestino;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }
}
