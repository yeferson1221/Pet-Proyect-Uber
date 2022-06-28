package co.com.sofka.trasporte.conductor;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.trasporte.conductor.values.ConductorId;
import co.com.sofka.trasporte.conductor.values.DatosContacto;


public class Conductor extends AggregateEvent<ConductorId>{
    protected CuentaConductor cuentaConductor;
    protected Vehiculo vehiculo;
    protected DatosContacto datosContacto;

    public Conductor(ConductorId entityId) {
        super(entityId);
    }
}
