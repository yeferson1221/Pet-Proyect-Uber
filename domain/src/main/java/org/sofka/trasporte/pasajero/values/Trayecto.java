package org.sofka.trasporte.pasajero.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Trayecto implements ValueObject<Trayecto.Props> {

    private final String direccionInicial;
    private final String direccionFinal;
    private final Integer distancia;

    public Trayecto(String direccionInicial, String direccionFinal, Integer distancia) {
        this.direccionInicial = Objects.requireNonNull(direccionInicial);
        this.direccionFinal = Objects.requireNonNull(direccionFinal);
        this.distancia = Objects.requireNonNull(distancia);

        if (distancia <= 0) {
            throw new IllegalArgumentException("La distancia no puede ser menor a 0");
        }
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String direccionInicial() {
                return direccionInicial;
            }

            @Override
            public String direccionFinal() {
                return direccionFinal;
            }

            @Override
            public Integer distancia() {
                return distancia;
            }
        };
    }


    public interface Props {
        String direccionInicial();
        String direccionFinal();
        Integer distancia();
    }
}
