package co.com.sofka.trasporte.conductor.values;

import co.com.sofka.domain.generic.Identity;
import co.com.sofka.trasporte.conductor.values.ConductorId;

public class CuentaConductorId extends Identity {
    public CuentaConductorId(String valor, ConductorId.Type type){
        super(type+"-"+valor);
    }

    public CuentaConductorId(String id) {
        super(id);
    }
    public enum Type {
        PASAPORTE, CC, TI
    }
}
