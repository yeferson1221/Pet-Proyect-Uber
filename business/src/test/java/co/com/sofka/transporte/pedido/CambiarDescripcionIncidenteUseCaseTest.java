package co.com.sofka.transporte.pedido;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.sofka.trasporte.pedido.IncidenteCreado;
import org.sofka.trasporte.pedido.Pedido;
import org.sofka.trasporte.pedido.command.CambiarDescripcionIncidenteCommand;
import org.sofka.trasporte.pedido.events.DescripcionIncidenteCambiado;
import org.sofka.trasporte.pedido.events.PedidoCreado;
import org.sofka.trasporte.pedido.values.*;
import java.util.List;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CambiarDescripcionIncidenteUseCaseTest {
    @Mock
    DomainEventRepository repository;

    @InjectMocks
    CambiarDescripcionIncidenteUseCase usecase;

    @Test
    void cambiarDescripcion(){
        //arrange
        //Se simula los elementos que tienen que estar creado al cambiar la descripcion
        PedidoId pedidoId = new PedidoId("blabla");
        IncidenteId incidenteId = new IncidenteId("asda");
        Descripcion descripcion = new Descripcion("General");
        FacturaId facturaId = new FacturaId();
        Valor valor = new Valor("pesos",2);
        Ubicacion ubicacion = new Ubicacion("asda","asda");
        Pedido pedido = new Pedido(pedidoId,facturaId,valor,ubicacion);

        var command = new CambiarDescripcionIncidenteCommand(pedidoId,incidenteId,descripcion);
        when(repository.getEventsBy(pedidoId.value())).thenReturn(history());
        usecase.addRepository(repository);

        //act
        var events = UseCaseHandler
                .getInstance().syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (DescripcionIncidenteCambiado)events.get(0);
        Assertions.assertEquals("General", event.getDescripcion().value().descripcion());
    }

    private List<DomainEvent> history() {
        FacturaId facturaId = new FacturaId();
        Valor valor = new Valor("pesomiller",2);
        Ubicacion ubicacion = new Ubicacion("asda","asda");
        Descripcion descripcion = new Descripcion("General");
        PedidoId pedidoId = new PedidoId("blabla");
        IncidenteId incidenteId = new IncidenteId("asda");
        return List.of(
                new PedidoCreado(facturaId, valor, ubicacion),
                new IncidenteCreado(pedidoId,descripcion,incidenteId)
        );
    }

}