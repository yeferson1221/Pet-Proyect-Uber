package co.com.sofka.trasporte.conductor.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class DatosContacto implements ValueObject<DatosContacto.Props> {

    private final String cel;
    private final String email;

    public DatosContacto(String cel, String email) {
        this.cel = Objects.requireNonNull(cel);
        this.email = Objects.requireNonNull(email);

        if (!email.matches("^[a-zA-Z0-9_!#$%&'\\*+/=?{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
            throw new IllegalArgumentException("ingrese un correo correcto ");
        }
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String Cel() {
                return cel;
            }

            @Override
            public String Email() {
                return email;
            }
        };
    }


    public interface Props {
        String Cel();
        String Email();

    }

}
