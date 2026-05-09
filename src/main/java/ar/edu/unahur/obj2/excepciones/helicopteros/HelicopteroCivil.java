package ar.edu.unahur.obj2.excepciones.helicopteros;

public class HelicopteroCivil extends Helicoptero{

    public HelicopteroCivil(Double combustible, Double kilometraje, Double capacidadTanque, Double reserva) {
        super(combustible, kilometraje, capacidadTanque, reserva);
    }

    @Override
    public String doAntesDeVolar(){
        return "Pasajeros y equipaje...";
    }

    public void alFinalizar(){
        agregarMensaje("Vuelo civil completado: "+ this.getKilometraje() +"km. Pasajeros...");
    }
}
