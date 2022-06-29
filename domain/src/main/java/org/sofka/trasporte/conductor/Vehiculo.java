package org.sofka.trasporte.conductor;

import co.com.sofka.domain.generic.Entity;
import org.sofka.trasporte.conductor.values.Marca;
import org.sofka.trasporte.conductor.values.VehiculoId;

public class Vehiculo extends Entity<VehiculoId> {
   private Marca marca;

   public Vehiculo(VehiculoId entityId, Marca marca) {
      super(entityId);
      this.marca = marca;
   }

   public void  cambiarVehiculo(Marca marcaCambiada ) {
   this.marca = marca.cambiarMarca(marcaCambiada.value());
   }
}
