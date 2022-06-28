package co.com.sofka.trasporte.conductor;

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
            public String tipoCuenta() {
                return null;
            }

            @Override
            public Long NumeroCuenta() {
                return null;
            }

            @Override
            public String Banco() {
                return null;
            }
        };
    }

    public interface Props {
        String tipoCuenta();
        Long NumeroCuenta();
        String Banco();
    }


}
