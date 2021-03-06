package org.sofka.trasporte.pedido.values;

import co.com.sofka.domain.generic.Identity;

public class IncidenteId extends Identity {

    public IncidenteId(String uuid) {
        super(uuid);
    }

    public IncidenteId() {
    }


    public static IncidenteId of(String id) {
        return new IncidenteId(id);
    }
}
