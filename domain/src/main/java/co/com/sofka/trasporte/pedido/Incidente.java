package co.com.sofka.trasporte.pedido;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.trasporte.pedido.values.Descripcion;
import co.com.sofka.trasporte.pedido.values.IncidenteId;

public class Incidente extends Entity<IncidenteId> {
    private Descripcion descripcion;

    public Incidente(IncidenteId entityId,Descripcion descripcion) {
        super(entityId);
        this.descripcion= descripcion;
    }
}
