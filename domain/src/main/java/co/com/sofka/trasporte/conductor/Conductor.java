package co.com.sofka.trasporte.conductor;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.trasporte.conductor.events.ConductorAgregado;
import co.com.sofka.trasporte.conductor.events.VehiculoCambiado;
import co.com.sofka.trasporte.conductor.values.*;

import java.util.List;


public class Conductor extends AggregateEvent<ConductorId>{
    protected CuentaConductor cuentaConductor;
    protected Vehiculo vehiculo;
    protected DatosContacto datosContacto;

    public Conductor(ConductorId entityId, CuentaConductorId cuentaConductorId, Rol rol, VehiculoId vehiculoId, Marca marca, DatosContacto datosContacto ) {
        super(entityId);
        appendChange(new ConductorAgregado(cuentaConductorId, rol, vehiculoId, marca, datosContacto)).apply();
        subscribe(new ConductorEventChange(this));
    }

    public Conductor(ConductorId entityId ) {
        super(entityId);
        subscribe(new ConductorEventChange(this));
    }

    public static Conductor from(ConductorId conductorId, List<DomainEvent> events){
        var conductor = new Conductor(conductorId);
        events.forEach(conductor::applyEvent);
        return conductor;
    }

    public void agregarRolCuenta(ConductorId conductorId, Rol rol){
        appendChange(new RolCambiado(conductorId,rol)).apply();
    }

    public void cambiarMarcaVehiculo(ConductorId conductorId, Marca marca){
        appendChange(new VehiculoCambiado(conductorId,marca)).apply();
    }
}
