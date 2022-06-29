package org.sofka.trasporte.pedido.values;
import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Valor implements ValueObject<Valor.Props> {
    private final String tipoDeMoneda;
    private final Integer cantidad;

    public Valor(String tipoDeMoneda, Integer cantidad) {
        this.tipoDeMoneda = Objects.requireNonNull(tipoDeMoneda);
        this.cantidad = Objects.requireNonNull(cantidad);
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String tipoDeMoneda() {
                return tipoDeMoneda;
            }

            @Override
            public Integer cantidad() {
                return cantidad;
            }
        };
    }

    public interface Props {
        String tipoDeMoneda();
        Integer cantidad();
    }

    public Valor cambiarCantidad(Integer cantidad) {
        return new Valor(this.tipoDeMoneda,cantidad);
    }

}