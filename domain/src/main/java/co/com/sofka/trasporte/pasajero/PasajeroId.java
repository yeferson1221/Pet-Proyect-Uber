package co.com.sofka.trasporte.pasajero;

import co.com.sofka.domain.generic.Identity;

public class PasajeroId extends Identity {

    public PasajeroId(Type tipo ,String valor) {
        super(tipo+"-"+valor);
    }

    public PasajeroId(String valor) {
        super(valor);
    }

    public PasajeroId() {
    }

    public enum Type {
        PASAPORTE, CC, TI
    }

}
