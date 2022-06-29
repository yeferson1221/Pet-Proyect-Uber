package co.com.sofka.transporte.pasajero;

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
import org.sofka.trasporte.pasajero.CuentaPasajero;
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
    CambiarRolCuentaUseCase usecase;

    @Test
    public void cambiarRol() {
        //arrange

//        PASO 2 - Se simula lacreacion de los diferentes elementos que solicita el nuevo comando
        CuentaId cuentaId = new CuentaId("1234");
        PasajeroId pasajeroId = new PasajeroId(PasajeroId.Type.CC, "54564");
        Rol rol = new Rol("Usuario");
        CuentaPasajero cuentaPasajero = new CuentaPasajero(cuentaId, rol);
//        PASO 1 se crea el comando con los diferentes parametros segun el comadno de dominio enlazado
        var command = new CambiarRolCuentaCommand(cuentaId, pasajeroId, rol);

//        PASO 3 - se utiliza el when para simular la creacion de los diferentes elementos que necesito para probar el test
        when(repository.getEventsBy(pasajeroId.value())).thenReturn(history());
        usecase.addRepository(repository);

//        act
        var events = UseCaseHandler
                .getInstance().syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

//        assert
        var event = (RolCuentaCambiado)events.get(0);
        Assertions.assertEquals((new Rol("Usuario")).value(), event.getRole().value());
    }

    private List<DomainEvent> history() {
        CuentaId cuentaId = new CuentaId("1234");
        Rol rol = new Rol("Usuario");
        MedioDepago medioDePago = new MedioDepago("Tarjeta", new Tarjeta("Credito", "MasterCard"));
        Email email = new Email("miller.gallegof@gmail.com");
        CuentaPasajero cuentaPasajero = new CuentaPasajero(cuentaId, rol);
        return List.of(
                new PasajeroCreado(cuentaId, rol, medioDePago, email)
        );
    }

}