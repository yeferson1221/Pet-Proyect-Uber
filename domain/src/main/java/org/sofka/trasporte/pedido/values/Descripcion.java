package org.sofka.trasporte.pedido.values;
import co.com.sofka.domain.generic.ValueObject;
import java.time.LocalDate;
import java.util.Objects;

public class Descripcion implements ValueObject<Descripcion.Props> {
    private final String descripcion;
    private final LocalDate fecha;

    public Descripcion(String descripcion) {
        this.descripcion = Objects.requireNonNull(descripcion);
        this.fecha = LocalDate.now();
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String descripcion() {
                return descripcion;
            }

            @Override
            public LocalDate fecha() {
                return fecha;
            }
        };
    }


    public interface Props {
        String descripcion();
        LocalDate fecha();
    }

    public Descripcion cambiarDescripcion(String descripcion){
        return new Descripcion(descripcion);
    }

}