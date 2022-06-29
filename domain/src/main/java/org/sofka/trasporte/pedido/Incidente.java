package org.sofka.trasporte.pedido;
import co.com.sofka.domain.generic.Entity;
import org.sofka.trasporte.pedido.values.Descripcion;
import org.sofka.trasporte.pedido.values.IncidenteId;

public class Incidente extends Entity<IncidenteId> {
    private Descripcion descripcion;

    public Incidente(IncidenteId entityId, Descripcion descripcion) {
        super(entityId);
        this.descripcion = descripcion;
    }

    public void cambiarDescripcion(Descripcion descripcionACambiar) {
        this.descripcion = descripcion.cambiarDescripcion(descripcionACambiar.value().descripcion());
    }

}
