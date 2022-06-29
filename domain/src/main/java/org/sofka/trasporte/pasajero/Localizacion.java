package org.sofka.trasporte.pasajero;

import co.com.sofka.domain.generic.Entity;
import org.sofka.trasporte.pasajero.values.LocalizacionId;
import org.sofka.trasporte.pasajero.values.Trayecto;

public class Localizacion extends Entity<LocalizacionId> {
    private Trayecto trayecto;
    public Localizacion(LocalizacionId entityId, Trayecto trayecto) {
        super(entityId);
        this.trayecto = trayecto;
    }

}
