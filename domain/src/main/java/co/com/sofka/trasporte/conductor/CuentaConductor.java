package co.com.sofka.trasporte.conductor;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.generic.Identity;
import co.com.sofka.trasporte.pasajero.CuentaId;

public class CuentaConductor extends Entity<CuentaConductorId> {
    private CuentaBancaria cuentaBancaria;
    private Rol rol;

    public CuentaConductor(CuentaConductorId entityId, CuentaBancaria cuentaBancaria, Rol rol) {
        super(entityId);
        this.cuentaBancaria = cuentaBancaria;
        this.rol = rol;
    }

    public void cambiarRol(Rol role){
        this.rol=rol.cambiarRol(role.value());
    }
}
