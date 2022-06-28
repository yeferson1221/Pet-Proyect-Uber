package co.com.sofka.trasporte.pedido;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.trasporte.pedido.values.PedidoId;
import co.com.sofka.trasporte.pedido.values.Ubicacion;

public class Pedido extends AggregateEvent<PedidoId> {
    protected Factura factura;
    protected Ubicacion ubicacion;

    public Pedido(PedidoId entityId) {
        super(entityId);
    }

}
