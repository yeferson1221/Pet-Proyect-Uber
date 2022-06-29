package org.sofka.trasporte.pedido;

import co.com.sofka.domain.generic.Entity;
import org.sofka.trasporte.pedido.values.FacturaId;
import org.sofka.trasporte.pedido.values.Valor;

public class Factura extends Entity<FacturaId> {
    private Valor valor;

    public Factura(FacturaId entityId,Valor valor) {
        super(entityId);
        this.valor = valor;
    }
}
