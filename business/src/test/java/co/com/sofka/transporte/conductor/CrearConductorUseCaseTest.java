package co.com.sofka.transporte.conductor;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.sofka.trasporte.conductor.Vehiculo;
import org.sofka.trasporte.conductor.command.CrearConductorCommand;
import org.sofka.trasporte.conductor.events.ConductorAgregado;
import org.sofka.trasporte.conductor.values.*;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CrearConductorUseCaseTest {
    @InjectMocks
    CrearConductorUseCase useCase;

    @Test
    public void crearConductor(){
        //arrange
        ConductorId conductorId = ConductorId.of("1");
        CuentaConductorId cuentaConductorId = new CuentaConductorId("dd", ConductorId.Type.CC);
        Rol rol = new Rol("Usuario");
        VehiculoId vehiculoid = new VehiculoId();
        Marca marca = new Marca("ff");
        DatosContacto datosContacto = new DatosContacto("dd","de@hotmail.com");
        var command = new CrearConductorCommand( conductorId, cuentaConductorId, rol, vehiculoid, marca, datosContacto);


        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();


        //assert
        var event = (ConductorAgregado)events.get(0);
        Assertions.assertEquals("Usuario", event.getRol().value());
        Assertions.assertEquals("Usuario", event.getRol().value());

    }

}