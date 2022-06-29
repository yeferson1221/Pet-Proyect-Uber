package org.sofka.trasporte.pasajero;

import co.com.sofka.domain.generic.Entity;
import org.sofka.trasporte.pasajero.values.CuentaId;
import org.sofka.trasporte.pasajero.values.Rol;

public class CuentaPasajero extends Entity<CuentaId> {
    private Rol rol;

    public CuentaPasajero(CuentaId entityId, Rol rol) {
        super(entityId);
        this.rol = rol;
    }

    public void cambiarRol(Rol role) {
        this.rol = rol.cambiarRol(role.value());
    }

}
