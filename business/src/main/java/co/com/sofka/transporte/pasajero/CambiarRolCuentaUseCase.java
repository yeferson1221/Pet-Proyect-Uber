package co.com.sofka.transporte.pasajero;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.sofka.trasporte.pasajero.Pasajero;
import org.sofka.trasporte.pasajero.command.CambiarRolCuentaCommand;

public class CambiarRolCuentaUseCase extends UseCase<RequestCommand<CambiarRolCuentaCommand>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CambiarRolCuentaCommand> cambiarRolCuentaCommandRequestCommand) {
        var command = cambiarRolCuentaCommandRequestCommand.getCommand();
        var pasajero = Pasajero.from(
                  command.getPasajeroId(), repository().getEventsBy(command.getPasajeroId().value())
        );

        pasajero.cambiarRol(command.getPasajeroId(), command.getRole());

        emit().onResponse(new ResponseEvents(pasajero.getUncommittedChanges()));
    }
}
