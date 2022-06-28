package co.com.sofka.trasporte.pasajero;

import co.com.sofka.domain.generic.AggregateEvent;

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
