package co.com.sofka.trasporte.pasajero.values;

import co.com.sofka.domain.generic.Identity;

import java.util.Objects;

public class LocalizacionId extends Identity {

    private final String latitud;
    private final String longitud;


    public LocalizacionId(String latitud, String longitud) {
        this.latitud = Objects.requireNonNull(latitud);
        this.longitud = Objects.requireNonNull(longitud);
    }



}
