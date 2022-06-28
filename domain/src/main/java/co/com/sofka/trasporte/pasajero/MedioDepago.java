package co.com.sofka.trasporte.pasajero;

import co.com.sofka.domain.generic.ValueObject;

public class MedioDepago implements ValueObject<MedioDepago.Props> {

    private final String tipo;
    private final Tarjeta tarjeta;

    public MedioDepago(String tipo, Tarjeta tarjeta) {
        this.tipo = tipo;
        this.tarjeta = tarjeta;
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
