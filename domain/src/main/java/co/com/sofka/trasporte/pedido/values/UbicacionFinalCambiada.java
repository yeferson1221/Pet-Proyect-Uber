package co.com.sofka.trasporte.pedido.values;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.trasporte.pedido.values.PedidoId;
import co.com.sofka.trasporte.pedido.values.Ubicacion;

public class UbicacionFinalCambiada extends DomainEvent {
    private final PedidoId pedidoId;
    private final Ubicacion ubicacion;

    public UbicacionFinalCambiada(PedidoId pedidoId, Ubicacion ubicacion) {
        super("co.com.sofka.trasporte.UbicacionFinalCambiada");
        this.pedidoId = pedidoId;
        this.ubicacion = ubicacion;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }
}
