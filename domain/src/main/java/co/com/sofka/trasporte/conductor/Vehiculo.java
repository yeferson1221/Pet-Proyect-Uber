package co.com.sofka.trasporte.conductor;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.generic.Identity;

public class Vehiculo extends Entity<VehiculoId> {
   private Marca marca;

   public Vehiculo(VehiculoId entityId) {
      super(entityId);
   }
}
