package org.sofka.trasporte.conductor.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.trasporte.conductor.values.ConductorId;
import org.sofka.trasporte.conductor.values.Rol;

public class RolCambiado extends DomainEvent {
    private final ConductorId conductorId;
    private final Rol rol;

    public RolCambiado(ConductorId conductorId, Rol rol) {
        super("co.com.sofka.trasporte.RolCambiado");
        this.conductorId = conductorId;
        this.rol = rol;
    }

    public Rol getRol() {
        return rol;
    }
    public ConductorId getConductorId() {
        return conductorId;
    }
}
