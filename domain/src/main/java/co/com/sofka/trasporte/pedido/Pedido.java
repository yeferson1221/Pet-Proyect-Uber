package co.com.sofka.trasporte.pedido;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.trasporte.pedido.values.*;

import java.util.List;

public class Pedido extends AggregateEvent<PedidoId> {
    protected Factura factura;
    protected Incidente incidente;
    protected Ubicacion ubicacion;
    public Pedido(PedidoId entityId, FacturaId facturaId, Valor valor,Ubicacion ubicacion) {
        super(entityId);
        appendChange(new PedidoCreado(facturaId,valor,ubicacion)).apply();
        subscribe(new PedidoEventChange(this));
    }

    public Pedido(PedidoId entityId) {
        super(entityId);
        subscribe(new PedidoEventChange(this));
    }

    public void cambiarDescripcionIncidente(PedidoId pedidoId, Descripcion descripcion){
        appendChange(new DescripcionIncidenteCambiado(pedidoId,descripcion)).apply();
    }

    public void cambiarUbicacionFinal(PedidoId pedidoId, Ubicacion ubicacion){
        appendChange(new UbicacionFinalCambiada(pedidoId,ubicacion)).apply();
    }

    public static Pedido from(PedidoId entityId, List<DomainEvent> events){
        var pedido = new Pedido((entityId));
        events.forEach(pedido::applyEvent);
        return pedido;
    }

}
