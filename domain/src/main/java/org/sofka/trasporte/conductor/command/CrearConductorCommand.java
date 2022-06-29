package org.sofka.trasporte.conductor.command;

import co.com.sofka.domain.generic.Command;
import org.sofka.trasporte.conductor.values.*;

public class CrearConductorCommand extends Command {
    private final ConductorId conductorId;
    private final CuentaConductorId cuentaConductorId;
    private final Rol rol;
    private final VehiculoId vehiculoId;
    private final Marca marca;
    private final DatosContacto datosContacto;

    public CrearConductorCommand(ConductorId conductorId, CuentaConductorId cuentaConductorId, Rol rol, VehiculoId vehiculoId, Marca marca, DatosContacto datosContacto) {
        this.conductorId = conductorId;
        this.cuentaConductorId = cuentaConductorId;
        this.rol = rol;
        this.vehiculoId = vehiculoId;
        this.marca = marca;
        this.datosContacto = datosContacto;
    }

    public Marca getMarca() {
        return marca;
    }

    public ConductorId getConductorId() {
        return conductorId;
    }

    public Rol getRol() {
        return rol;
    }

    public CuentaConductorId getCuentaConductorId() {
        return cuentaConductorId;
    }

    public DatosContacto getDatosContacto() {
        return datosContacto;
    }

    public VehiculoId getVehiculoId() {
        return vehiculoId;
    }

}
