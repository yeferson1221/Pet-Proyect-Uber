package org.sofka.trasporte.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.trasporte.pedido.values.Descripcion;
import org.sofka.trasporte.pedido.values.IncidenteId;
import org.sofka.trasporte.pedido.values.PedidoId;

public class DescripcionIncidenteCambiado extends DomainEvent {
    private final PedidoId pedidoId;
    private final Descripcion descripcion;

    private final IncidenteId incidenteId;

    public DescripcionIncidenteCambiado(PedidoId pedidoId, Descripcion descripcion, IncidenteId incidenteId) {
        super("co.com.sofka.trasporte.DescripcionIncidenteCambiado");
        this.pedidoId = pedidoId;
        this.descripcion = descripcion;
        this.incidenteId = incidenteId;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public IncidenteId getIncidenteId() {
        return incidenteId;
    }
}
