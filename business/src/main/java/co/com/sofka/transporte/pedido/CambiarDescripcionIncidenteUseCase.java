package co.com.sofka.transporte.pedido;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.sofka.trasporte.pedido.Pedido;
import org.sofka.trasporte.pedido.command.CambiarDescripcionIncidenteCommand;

public class CambiarDescripcionIncidenteUseCase extends UseCase<RequestCommand<CambiarDescripcionIncidenteCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarDescripcionIncidenteCommand> cambiarDescripcionIncidenteCommandRequestCommand) {

        var command = cambiarDescripcionIncidenteCommandRequestCommand.getCommand();
        var pedido = Pedido.from(
                command.getPedidoId(), repository().getEventsBy(command.getPedidoId().value())
        );

        pedido.cambiarDescripcionIncidente(command.getPedidoId(), command.getDescripcion(),command.getIncidenteId());

        emit().onResponse(new ResponseEvents(pedido.getUncommittedChanges()));

    }
}
