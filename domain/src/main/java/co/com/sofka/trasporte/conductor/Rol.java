package co.com.sofka.trasporte.conductor;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Rol implements ValueObject<String> {
    private final String rol;

    public Rol(String rol) {
        this.rol = Objects.requireNonNull(rol);
    }

    public Rol cambiarRol(String rol){
        return new Rol(rol);
    }

    @Override
    public String value() {
        return null;
    }
}
