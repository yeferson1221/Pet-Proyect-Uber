package co.com.sofka.trasporte.pedido;
import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.trasporte.pedido.events.DescripcionIncidenteCambiado;
import co.com.sofka.trasporte.pedido.events.PedidoCreado;
import co.com.sofka.trasporte.pedido.events.UbicacionFinalCambiada;

public class PedidoEventChange extends EventChange {
    public PedidoEventChange(Pedido pedido) {
        apply((PedidoCreado event) -> {
            pedido.factura = new Factura(event.getFacturaId(), event.getValor());
            pedido.incidente = null;
            pedido.ubicacion = event.getUbicacion();
        });

        apply((DescripcionIncidenteCambiado event) -> {
            if(!pedido.incidente.identity().equals(event.getPedidoId())) {
                throw new IllegalArgumentException("El pedido no existe para este identificador");
            }
            pedido.incidente.cambiarDescripcion(event.getDescripcion());
        });

        apply((UbicacionFinalCambiada event) -> {
            if(pedido.ubicacion.value().direccionFinal().equals(null)) {
                throw new IllegalArgumentException("La direccion no esta ingresada");
            }
            pedido.ubicacion.cambiarUbicacionFinal(event.getUbicacion().value().direccionFinal());
        });

    }
}