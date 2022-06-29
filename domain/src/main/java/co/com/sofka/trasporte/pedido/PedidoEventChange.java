package co.com.sofka.trasporte.pedido;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.trasporte.pedido.values.DescripcionIncidenteCambiado;
import co.com.sofka.trasporte.pedido.values.PedidoCreado;

public class PedidoEventChange extends EventChange {
    public PedidoEventChange(Pedido pedido) {
        apply((PedidoCreado event) -> {
            pedido.factura = new Factura(event.getFacturaId(), event.getValor());
            pedido.incidente = null;
            pedido.ubicacion = event.getUbicacion();
        });

        apply((DescripcionIncidenteCambiado event) -> {
            if(!pedido.incidente.identity().equals(event.getPedidoId())) {
                throw new IllegalArgumentException("La cuenta no existe para este identificador");
            }
            pedido.incidente.cambiarDescripcion(event.getDescripcion());
        });

    }
}