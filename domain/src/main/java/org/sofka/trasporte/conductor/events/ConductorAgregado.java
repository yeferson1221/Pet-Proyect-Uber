package org.sofka.trasporte.conductor.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.trasporte.conductor.values.*;

public class ConductorAgregado extends DomainEvent {
    private final CuentaConductorId cuentaConductorId;
    private final Rol rol;
    private final VehiculoId vehiculoId;
    private final Marca marca;
    private final DatosContacto datosContacto;

    public ConductorAgregado(CuentaConductorId cuentaConductorId, Rol rol, VehiculoId vehiculoId, Marca marca, DatosContacto datosContacto) {
        super("co.com.sofka.trasporte.ConductorAgregado");

        this.cuentaConductorId = cuentaConductorId;
        this.rol = rol;
        this.vehiculoId = vehiculoId;
        this.marca = marca;
        this.datosContacto = datosContacto;
    }


    public CuentaConductorId getCuentaConductorId() {
        return cuentaConductorId;
    }

    public Rol getRol() {
        return rol;
    }

    public VehiculoId getVehiculoId() {
        return vehiculoId;
    }

    public Marca getMarca() {
        return marca;
    }

    public DatosContacto getDatosContacto() {
        return datosContacto;
    }
}
