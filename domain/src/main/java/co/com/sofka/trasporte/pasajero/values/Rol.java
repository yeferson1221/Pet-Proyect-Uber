package co.com.sofka.trasporte.pasajero.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Rol implements ValueObject<String> {

    private final String rol;

    public Rol(String rol) {
        this.rol = Objects.requireNonNull(rol);

    }

    @Override
    public String value() {
        return rol;
    }

    public Rol cambiarRol(String role) {
        return new Rol(role);
    }

}
