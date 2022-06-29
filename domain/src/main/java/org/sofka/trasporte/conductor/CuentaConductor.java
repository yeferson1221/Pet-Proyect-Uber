package org.sofka.trasporte.conductor;

import co.com.sofka.domain.generic.Entity;
import org.sofka.trasporte.conductor.values.CuentaBancaria;
import org.sofka.trasporte.conductor.values.CuentaConductorId;
import org.sofka.trasporte.conductor.values.Rol;


public class CuentaConductor extends Entity<CuentaConductorId> {
    private CuentaBancaria cuentaBancaria;
    private Rol rol;

    public CuentaConductor(CuentaConductorId entityId, Rol rol) {
        super(entityId);
        this.cuentaBancaria = null;
        this.rol = rol;
    }


    public void cambiarRol(Rol role) {
        this.rol = rol.cambiarRol(role.value());
    }
}
