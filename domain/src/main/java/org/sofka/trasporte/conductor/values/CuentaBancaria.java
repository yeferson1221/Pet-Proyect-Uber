package org.sofka.trasporte.conductor.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class CuentaBancaria implements ValueObject<CuentaBancaria.Props>{
    private final String tipoCuenta;
    private final Long numeroCuenta;
    private final String banco;

    public CuentaBancaria(String tipoCuenta, Long numeroCuenta, String banco) {
        this.tipoCuenta = Objects.requireNonNull(tipoCuenta);
        this.numeroCuenta = Objects.requireNonNull(numeroCuenta);
        this.banco = Objects.requireNonNull(banco);
    }


    @Override
    public Props value() {
        return new Props() {
            @Override
            public String TipoCuenta() {
                return tipoCuenta;
            }

            @Override
            public Long NumeroCuenta() {
                return numeroCuenta;
            }

            @Override
            public String Banco() {
                return banco;
            }
        };
    }

    public interface Props {
        String TipoCuenta();
        Long NumeroCuenta();
        String Banco();
    }


}
