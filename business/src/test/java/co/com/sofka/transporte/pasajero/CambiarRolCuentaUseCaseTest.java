package co.com.sofka.transporte.pasajero;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.sofka.trasporte.pasajero.command.CambiarRolCuentaCommand;
import org.sofka.trasporte.pasajero.events.PasajeroCreado;
import org.sofka.trasporte.pasajero.events.RolCuentaCambiado;
import org.sofka.trasporte.pasajero.values.*;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CambiarRolCuentaUseCaseTest {
    @Mock
    DomainEventRepository repository;

    @InjectMocks
    CambiarRolCuentaUseCase useCase;

    @Test
    void cambiarRol() {
        //arrange

//        PASO 2 - Se simula lacreacion de los diferentes elementos que solicita el nuevo comando
        CuentaId cuentaId = new CuentaId();
        PasajeroId pasajeroId = new PasajeroId(PasajeroId.Type.CC, "54564");
        Rol rol = new Rol("Usuario");

//        PASO 1 se crea el comando con los diferentes parametros segun el comadno de dominio enlazado
        var command = new CambiarRolCuentaCommand(cuentaId, pasajeroId, rol);

//        PASO 3 - se utiliza el when para simular la creacion de los diferentes elementos que necesito para probar el test
        when(repository.getEventsBy(pasajeroId.value())).thenReturn(history());
        useCase.addRepository(repository);

//        act
        var events = UseCaseHandler
                .getInstance().syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

//        assert
        var event = (RolCuentaCambiado)events.get(0);
        Assertions.assertEquals(new Rol("Usuario"), event.getRole().value());
    }

    private List<DomainEvent> history() {
        CuentaId cuentaId = new CuentaId();
        Rol rol = new Rol("Usuario");
        MedioDepago medioDePago = new MedioDepago("Tarjeta", new Tarjeta("Credito", "MasterCard"));
        Email email = new Email("miller.gallegof@gmail.com");
        return List.of(
                new PasajeroCreado(cuentaId, rol, medioDePago, email)
        );
    }

}