package co.com.sofka.trasporte.conductor;

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
}
