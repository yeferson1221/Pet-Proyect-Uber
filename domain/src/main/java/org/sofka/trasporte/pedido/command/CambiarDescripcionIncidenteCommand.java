package org.sofka.trasporte.pedido.command;

import co.com.sofka.domain.generic.Command;
import org.sofka.trasporte.pedido.values.Descripcion;
import org.sofka.trasporte.pedido.values.PedidoId;

// Siempre debe de extender de COMMAND "Command"
public class CambiarDescripcionIncidenteCommand extends Command {
    private final PedidoId pedidoId;
    private final Descripcion descripcion;

    public CambiarDescripcionIncidenteCommand(PedidoId pedidoId, Descripcion descripcion) {
        this.pedidoId = pedidoId;
        this.descripcion = descripcion;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

}