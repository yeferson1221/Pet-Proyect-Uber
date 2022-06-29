package org.sofka.trasporte.pasajero.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class MedioDepago implements ValueObject<MedioDepago.Props> {

    private final String tipo;
    private final Tarjeta tarjeta;

    public MedioDepago(String tipo, Tarjeta tarjeta) {
        this.tipo = Objects.requireNonNull(tipo);
        this.tarjeta = Objects.requireNonNull(tarjeta);
    }

//    Metodo para cambair una tarjeta
    public MedioDepago cambiarTarjeta(Tarjeta tarjeta) {
        return new MedioDepago(tipo, tarjeta);
    }


    @Override
    public Props value() {
        return new Props() {
            @Override
            public String tipo() {
                return tipo;
            }

            @Override
            public Tarjeta tarjeta() {
                return tarjeta;
            }
        };
    }

    public interface Props {
        String tipo();
        Tarjeta tarjeta();
    }
}
