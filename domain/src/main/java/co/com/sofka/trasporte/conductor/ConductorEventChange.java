package co.com.sofka.trasporte.conductor;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.trasporte.conductor.events.ConductorAgregado;

public class ConductorEventChange extends EventChange {
    public ConductorEventChange(Conductor conductor) {
        apply((ConductorAgregado event) -> {
            conductor.cuentaConductor = new CuentaConductor(event.getCuentaConductorId(), event.getRol());
            conductor.vehiculo = new Vehiculo(event.getVehiculoId(), event.getMarca());
            conductor.datosContacto = event.getDatosContacto();
        });

        apply((RolCambiado event) -> {

            if (!conductor.cuentaConductor.identity().equals(event.getConductorId())) {
                throw new IllegalArgumentException("El Rol No se pudo Cambiar");
            }
                conductor.cuentaConductor.cambiarRol(event.getRol());
        });
    }

}
