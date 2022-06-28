package co.com.sofka.trasporte.pedido.values;
import co.com.sofka.domain.generic.ValueObject;

public class Ubicacion implements ValueObject<Ubicacion.Props> {
    private final String direccionInicial;
    private final String direccionFinal;

    public Ubicacion(String direccionInicial, String direccionFinal) {
        this.direccionInicial = direccionInicial;
        this.direccionFinal = direccionFinal;
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String direccionInicial() {
                return direccionInicial;
            }

            @Override
            public String direccionFinal() {
                return direccionFinal;
            }
        };
    }

    public interface Props {
        String direccionInicial();
        String direccionFinal();
    }
}