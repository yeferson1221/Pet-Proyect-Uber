package org.sofka.trasporte.pedido;
import co.com.sofka.domain.generic.EventChange;
import org.sofka.trasporte.pedido.events.DescripcionIncidenteCambiado;
import org.sofka.trasporte.pedido.events.PedidoCreado;
import org.sofka.trasporte.pedido.events.UbicacionFinalCambiada;

public class PedidoEventChange extends EventChange {
    public PedidoEventChange(Pedido pedido) {
        apply((PedidoCreado event) -> {
            pedido.factura = new Factura(event.getFacturaId(), event.getValor());
            pedido.ubicacion = event.getUbicacion();
        });

        apply((IncidenteCreado event)->{
            pedido.incidente = new Incidente(event.getIncidenteId(), event.getDescripcion());
        });

        apply((DescripcionIncidenteCambiado event) -> {
         //   if(!pedido.incidente.identity().equals(event.getIncidenteId())) {
          //      throw new IllegalArgumentException("El pedido no existe para este identificador");
           // }
            pedido.incidente.cambiarNuevaDescripcion(event.getDescripcion());
        });



        apply((UbicacionFinalCambiada event) -> {
            if(pedido.ubicacion.value().direccionFinal().equals(null)) {
                throw new IllegalArgumentException("La direccion no esta ingresada");
            }
            pedido.ubicacion.cambiarUbicacionFinal(event.getUbicacion().value().direccionFinal());
        });

    }
}