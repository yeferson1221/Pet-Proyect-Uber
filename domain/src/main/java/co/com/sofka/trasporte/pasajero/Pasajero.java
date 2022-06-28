package co.com.sofka.trasporte.pasajero;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.trasporte.pasajero.values.Email;
import co.com.sofka.trasporte.pasajero.values.MedioDepago;
import co.com.sofka.trasporte.pasajero.values.PasajeroId;

public class Pasajero extends AggregateEvent<PasajeroId> {

    protected CuentaPasajero cuentaPasajero;
    protected MedioDepago medioDepago;
    protected Email email;

    public Pasajero(PasajeroId entityId, CuentaPasajero cuentaPasajero, MedioDepago medioDepago, Email email) {
        super(entityId);
        this.cuentaPasajero = cuentaPasajero;
        this.medioDepago = medioDepago;
        this.email = email;
    }


}
