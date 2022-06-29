package org.sofka.trasporte.conductor.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Marca implements ValueObject<String> {
    private final String marca;

    public Marca(String marca) {
        this.marca = Objects.requireNonNull(marca);
    }

    @Override
    public String value() {
        return null;
    }

    public Marca cambiarMarca(String marca){
        return  new Marca(marca);
    }
}
