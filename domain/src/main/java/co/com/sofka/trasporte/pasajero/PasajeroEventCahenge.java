package co.com.sofka.trasporte.pasajero;

import co.com.sofka.domain.generic.EventChange;

public class PasajeroEventCahenge extends EventChange {
    public PasajeroEventCahenge(Pasajero pasajero) {
        apply((PasajeroCreado event) -> {
            pasajero.cuentaPasajero = new CuentaPasajero(event.getCuentaId(), event.getRol());
            pasajero.localizacion = null;
            pasajero.medioDepago = event.getMedioDepago();
            pasajero.email = event.getEmail();
        });

        apply((EmailCambiado event) -> {
            pasajero.cambiarEmail(event.getEmail());
        });

        apply((RolCuentaCambiado event) -> {
            if (!pasajero.cuentaPasajero.identity().equals(event.getPasajeroId())) {
                throw new IllegalArgumentException("El Rol No se pudo Cambiar");
            }
            pasajero.cuentaPasajero.cambiarRol(event.getRole());
        });
    }
}
