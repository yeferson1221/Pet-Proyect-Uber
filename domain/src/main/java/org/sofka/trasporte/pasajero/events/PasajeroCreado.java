package org.sofka.trasporte.pasajero.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.trasporte.pasajero.values.CuentaId;
import org.sofka.trasporte.pasajero.values.Email;
import org.sofka.trasporte.pasajero.values.MedioDepago;
import org.sofka.trasporte.pasajero.values.Rol;

public class PasajeroCreado extends DomainEvent {
    private final CuentaId cuentaId;
    private final Rol rol;
    private final MedioDepago medioDepago;
    private final Email email;

    public PasajeroCreado(CuentaId cuentaId, Rol rol, MedioDepago medioDepago, Email email) {
        super("co.com.sofka.trasporte.PasajeroCreado");

        this.cuentaId = cuentaId;
        this.rol = rol;
        this.medioDepago = medioDepago;
        this.email = email;
    }

    public CuentaId getCuentaId() {
        return cuentaId;
    }

    public Rol getRol() {
        return rol;
    }

    public MedioDepago getMedioDepago() {
        return medioDepago;
    }

    public Email getEmail() {
        return email;
    }
}
