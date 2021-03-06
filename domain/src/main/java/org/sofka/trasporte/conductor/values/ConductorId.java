package org.sofka.trasporte.conductor.values;

import co.com.sofka.domain.generic.Identity;

public class ConductorId extends Identity {
    public ConductorId(String valor, Type type){
        super(type+"-"+valor);
    }

    public ConductorId(String id) {
        super(id);
    }
    public enum Type {
        PASAPORTE, CC, TI
    }
    public static ConductorId of(String id) {
        return new ConductorId(id);
    }
}
