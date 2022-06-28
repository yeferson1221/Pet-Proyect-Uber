package co.com.sofka.trasporte.conductor;

import co.com.sofka.domain.generic.AggregateEvent;


public class Conductor extends AggregateEvent<ConductorId>{
    protected Cuenta cuenta;
    protected Vehiculo vehiculo;
    protected DatosContacto datosContacto; 
}
