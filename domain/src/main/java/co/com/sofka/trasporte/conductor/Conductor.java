package co.com.sofka.trasporte.conductor;

import co.com.sofka.domain.generic.AggregateEvent;


public class Conductor extends AggregateEvent<ConductorId>{
    protected CuentaConductor cuentaConductor;
    protected Vehiculo vehiculo;
    protected DatosContacto datosContacto;
}
