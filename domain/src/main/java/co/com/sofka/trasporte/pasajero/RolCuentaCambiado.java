package co.com.sofka.trasporte.pasajero;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.trasporte.pasajero.values.PasajeroId;
import co.com.sofka.trasporte.pasajero.values.Rol;

public class RolCuentaCambiado extends DomainEvent {
    private final PasajeroId pasajeroId;
    private final Rol role;

    public RolCuentaCambiado(PasajeroId pasajeroId, Rol role) {
        super("co.com.sofka.trasporte.RolCuentaCambiado");
        this.pasajeroId = pasajeroId;
        this.role = role;
    }

    public Rol getRole() {
        return role;
    }

    public PasajeroId getPasajeroId() {
        return pasajeroId;
    }
}
