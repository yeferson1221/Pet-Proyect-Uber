package org.sofka.trasporte.pedido;
import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.trasporte.pedido.values.Descripcion;
import org.sofka.trasporte.pedido.values.IncidenteId;
import org.sofka.trasporte.pedido.values.PedidoId;

public class IncidenteCreado extends DomainEvent {
    private final PedidoId pedidoId;
    private final Descripcion descripcion;

    private final IncidenteId incidenteId;

    public IncidenteCreado(PedidoId pedidoId, Descripcion descripcion, IncidenteId incidenteId) {
        super("org.sofka.trasporte.IncidenteCreado");
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
