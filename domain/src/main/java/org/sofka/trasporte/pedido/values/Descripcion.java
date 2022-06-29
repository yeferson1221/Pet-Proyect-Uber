package org.sofka.trasporte.pedido.values;
import co.com.sofka.domain.generic.ValueObject;

import java.util.Date;
import java.util.Objects;

public class Descripcion implements ValueObject<Descripcion.Props> {
    private final String descripcion;
    private final Date fecha;

    public Descripcion(String descripcion, Date fecha) {
        this.descripcion = Objects.requireNonNull(descripcion);
        this.fecha = Objects.requireNonNull(fecha);
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String descripcion() {
                return descripcion;
            }

            @Override
            public Date fecha() {
                return fecha;
            }
        };
    }

    public interface Props {
        String descripcion();
        Date fecha();
    }

    public Descripcion cambiarDescripcion(String descripcion){
        return new Descripcion(descripcion,this.fecha);
    }

}
