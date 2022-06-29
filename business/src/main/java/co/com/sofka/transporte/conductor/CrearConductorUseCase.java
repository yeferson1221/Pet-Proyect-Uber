package co.com.sofka.transporte.conductor;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.sofka.trasporte.conductor.Conductor;
import org.sofka.trasporte.conductor.command.CrearConductorCommand;
import org.sofka.trasporte.conductor.values.*;

public class CrearConductorUseCase extends UseCase<RequestCommand<CrearConductorCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearConductorCommand> crearConductorCommandRequestCommand) {
        var command = crearConductorCommandRequestCommand.getCommand();
        var conductor = new Conductor(
                command.getConductorId(),
                new CuentaConductorId("ddd", ConductorId.Type.CC),
                command.getRol(),
                new VehiculoId(),
                new Marca("fdf"),
                new DatosContacto("ddd","de@hotmail.com")


        );

        emit().onResponse(new ResponseEvents(conductor.getUncommittedChanges()));
    }
}
