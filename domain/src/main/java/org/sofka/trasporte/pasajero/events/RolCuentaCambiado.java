package org.sofka.trasporte.pasajero.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.trasporte.pasajero.values.CuentaId;
import org.sofka.trasporte.pasajero.values.PasajeroId;
import org.sofka.trasporte.pasajero.values.Rol;

public class RolCuentaCambiado extends DomainEvent {


    private final PasajeroId pasajeroId;
    private final CuentaId cuentaId;
    private final Rol role;

    public RolCuentaCambiado(PasajeroId pasajeroId, CuentaId cuentaId, Rol role) {
        super("co.com.sofka.trasporte.RolCuentaCambiado");
        this.pasajeroId = pasajeroId;
        this.cuentaId = cuentaId;
        this.role = role;
    }

    public Rol getRole() {
        return role;
    }

    public CuentaId getCuentaId() {
        return cuentaId;
    }

    public PasajeroId getPasajeroId() {
        return pasajeroId;
    }
}
