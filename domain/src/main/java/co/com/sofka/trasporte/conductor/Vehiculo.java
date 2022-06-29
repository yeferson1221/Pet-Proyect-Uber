package co.com.sofka.trasporte.conductor;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.trasporte.conductor.values.ConductorId;
import co.com.sofka.trasporte.conductor.values.Marca;
import co.com.sofka.trasporte.conductor.values.Rol;
import co.com.sofka.trasporte.conductor.values.VehiculoId;

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
