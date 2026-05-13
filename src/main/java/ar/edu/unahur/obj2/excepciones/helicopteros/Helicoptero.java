package ar.edu.unahur.obj2.excepciones.helicopteros;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.excepciones.modosDeVuelo.IModoDeVuelo;

public abstract class Helicoptero {
    protected IModoDeVuelo modoDeVuelo;//= new ModoEficiente();
    protected Double combustible;
    protected Double kilometrosRecorridos;
    protected Double capacidadDelTanque;
    protected Double reserva;
    protected List<String> bitacora = new ArrayList<>();

    public Helicoptero(Double combustible, Double capacidadDelTanque) {
        if(combustible < 0){
            throw new IllegalArgumentException("El combustible no puede ser negativo");
        }
        else{
            this.combustible = combustible;
        }
        this.capacidadDelTanque = capacidadDelTanque;
        this.reserva = combustible * 0.10;
    }

    

}

