package ar.edu.unahur.obj2.excepciones.helicopteros;

public class HelicopteroMilitar extends Helicoptero {
    public HelicopteroMilitar(Double combustible, Double kilometraje, Double capacidadTanque, Double reserva) {
        super(combustible, kilometraje, capacidadTanque, reserva);
    }

    @Override
    public String doAntesDeVolar() {
        this.restriccionCritica();
        return"Sistemas de armas...";
    }

    public void alFinalizar() {
        agregarMensaje("mision completada...");
    }

    public void restriccionCritica() {
        if (this.getModo().getClass().equals(Agresivo.class) && this.getCombustible() < 20) {
            throw new RuntimeException("abortar mision");
        }
    }
}
