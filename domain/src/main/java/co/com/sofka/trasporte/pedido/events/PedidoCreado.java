package co.com.sofka.trasporte.pedido.events;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.trasporte.pedido.values.FacturaId;
import co.com.sofka.trasporte.pedido.values.Ubicacion;
import co.com.sofka.trasporte.pedido.values.Valor;

public class PedidoCreado extends DomainEvent {
    private final FacturaId facturaId;
    private final Valor valor;
    private final Ubicacion ubicacion;

    public PedidoCreado(FacturaId facturaId, Valor valor, Ubicacion ubicacion) {
        super("co.com.sofka.trasporte.PedidoCreado");
        this.facturaId = facturaId;
        this.valor = valor;
        this.ubicacion = ubicacion;
    }

    public FacturaId getFacturaId() {
        return facturaId;
    }

    public Valor getValor() {
        return valor;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }
}
