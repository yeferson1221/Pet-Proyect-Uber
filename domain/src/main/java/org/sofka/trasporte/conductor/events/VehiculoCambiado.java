package org.sofka.trasporte.conductor.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.trasporte.conductor.values.ConductorId;
import org.sofka.trasporte.conductor.values.Marca;

public class VehiculoCambiado extends DomainEvent {
    private final ConductorId conductorId;
    private final Marca marca;

    public VehiculoCambiado(ConductorId conductorId, Marca marca) {
        super("co.com.sofka.trasporte.VehiculoCambiado");
        this.conductorId = conductorId;
        this.marca = marca;
    }

    public ConductorId getConductorId() {
        return conductorId;
    }

    public Marca getMarca() {
        return marca;
    }
}
