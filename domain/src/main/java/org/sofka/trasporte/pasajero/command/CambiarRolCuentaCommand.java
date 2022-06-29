package org.sofka.trasporte.pasajero.command;

import co.com.sofka.domain.generic.Command;
import org.sofka.trasporte.pasajero.values.CuentaId;
import org.sofka.trasporte.pasajero.values.PasajeroId;
import org.sofka.trasporte.pasajero.values.Rol;

public class CambiarRolCuentaCommand extends Command {
    private final CuentaId cuentaId;
    private final PasajeroId pasajeroId;
    private final Rol role;

    public CambiarRolCuentaCommand(CuentaId cuentaId, PasajeroId pasajeroId, Rol role) {
        this.cuentaId = cuentaId;
        this.pasajeroId = pasajeroId;
        this.role = role;
    }

    public Rol getRole() {
        return role;
    }

    public PasajeroId getPasajeroId() {
        return pasajeroId;
    }

    public CuentaId getCuentaId() {
        return cuentaId;
    }
}
