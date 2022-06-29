package org.sofka.trasporte.pasajero.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.trasporte.pasajero.values.Email;

public class EmailCambiado extends DomainEvent {
    private final Email email;

    public EmailCambiado(Email email) {
        super("co.com.sofka.trasporte.EmailCambiado");
        this.email = email;
    }

    public Email getEmail() {
        return email;
    }
}
