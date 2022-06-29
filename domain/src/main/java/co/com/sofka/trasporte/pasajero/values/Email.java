package co.com.sofka.trasporte.pasajero.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Email implements ValueObject<String> {

    private final String email;


    public Email(String email) {
        this.email = Objects.requireNonNull(email);

        if (!email.matches("^[a-zA-Z0-9_!#$%&'\\*+/=?{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
            throw new IllegalArgumentException("ingrese un correo correcto");
        }
    }

    @Override
    public String value() {
        return email;
    }

    public Email cambiarEmail(String email) {
        return new Email(email);
    }

}
