package co.com.sofka.trasporte.pasajero.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Tarjeta implements ValueObject<Tarjeta.Props> {

    private final String tipoTarjeta;
    private final String detalle;

    public Tarjeta(String tipoTarjeta, String detalle) {
        this.tipoTarjeta = Objects.requireNonNull(tipoTarjeta);
        this.detalle = Objects.requireNonNull(detalle);
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String tipoTarjeta() {
                return tipoTarjeta;
            }

            @Override
            public String detalle() {
                return detalle;
            }
        };
    }

    public interface Props {
        String tipoTarjeta();
        String detalle();
    }
}
