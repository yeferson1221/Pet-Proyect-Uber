package org.sofka.trasporte.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.sofka.trasporte.pedido.values.Descripcion;
import org.sofka.trasporte.pedido.values.PedidoId;

public class DescripcionIncidenteCambiado extends DomainEvent {
    private final PedidoId pedidoId;
    private final Descripcion descripcion;

    public DescripcionIncidenteCambiado(PedidoId pedidoId, Descripcion descripcion) {
        super("co.com.sofka.trasporte.DescripcionIncidenteCambiado");
        this.pedidoId = pedidoId;
        this.descripcion = descripcion;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
