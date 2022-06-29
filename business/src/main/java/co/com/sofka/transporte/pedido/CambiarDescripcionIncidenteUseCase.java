package co.com.sofka.transporte.pedido;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.sofka.trasporte.pedido.command.CambiarDescripcionIncidenteCommand;

public class CambiarDescripcionIncidenteUseCase extends UseCase<RequestCommand<CambiarDescripcionIncidenteCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarDescripcionIncidenteCommand> cambiarDescripcionIncidenteCommandRequestCommand) {

    }
}
