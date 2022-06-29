package co.com.sofka.trasporte.pasajero;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.trasporte.pasajero.events.EmailCambiado;
import co.com.sofka.trasporte.pasajero.events.PasajeroCreado;
import co.com.sofka.trasporte.pasajero.events.RolCuentaCambiado;
import co.com.sofka.trasporte.pasajero.values.*;

import java.util.List;

public class Pasajero extends AggregateEvent<PasajeroId> {

    protected CuentaPasajero cuentaPasajero;
    protected Localizacion localizacion;
    protected MedioDepago medioDepago;
    protected Email email;

    public Pasajero(PasajeroId entityId, CuentaId cuentaId, Rol rol, MedioDepago medioDepago, Email email) {
        super(entityId);
        appendChange(new PasajeroCreado(cuentaId, rol, medioDepago, email)).apply();
        subscribe(new PasajeroEventCahenge(this));
    }

    public Pasajero(PasajeroId entityId) {
        super(entityId);
        subscribe(new PasajeroEventCahenge(this));
    }

    public static Pasajero from(PasajeroId id, List<DomainEvent> events){
        var pasajero = new Pasajero((id));
        events.forEach(pasajero::applyEvent);
        return pasajero;
    }

    public void cambiarEmail(Email email) {
        appendChange(new EmailCambiado(email)).apply();
    }

    public void cambiarRol(PasajeroId pasajeroId ,Rol role) {
        appendChange(new RolCuentaCambiado(pasajeroId, role)).apply();
    }

}
