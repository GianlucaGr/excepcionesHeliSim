package ar.edu.unahur.obj2.excepciones.helicopteros;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.excepciones.misexcepciones.ValidarCombustibleException;

public abstract class Helicoptero {

    private ModoDeVuelo modo;
    private Double combustible;
    private Double kilometraje;
    private Double capacidadTanque;
    private Double reserva;
    private List<String> bitacora;

    public Helicoptero(Double combustible, Double kilometraje, Double capacidadTanque, Double reserva) {
        this.modo = new Eficiente();
        this.combustible = validarCombustible(combustible);
        this.kilometraje = kilometraje;
        this.capacidadTanque = capacidadTanque;
        this.reserva = capacidadTanque * 0.1;
        this.bitacora = new ArrayList<>();
    }

    private Double validarCombustible(Double combustible) {
        if (combustible < 0) {
            throw new ValidarCombustibleException("El combustible no debe ser menor a cero.");
        }
        return combustible;
    }

    public ModoDeVuelo getModo() {
        return modo;
    }

    public Double getCombustible() {
        return combustible;
    }

    public Double getKilometraje() {
        return kilometraje;
    }

    public Double getCapacidadTanque() {
        return capacidadTanque;
    }

    public Double getReserva() {
        return reserva;
    }

    public List<String> getBitacora() {
        return bitacora;
    }

    public void cambiarDeModo(ModoDeVuelo nuevoModo){
        modo = nuevoModo;
    }

    public Double consumo(){
        return modo.consumo();
    }

    public Integer velocidadMaxima(){
        return modo.velocidadMaxima();
    }

    protected void agregarMensaje(String mensaje){
        bitacora.add(mensaje);
    }

    public void antesDeVolar(){
        agregarMensaje(this.doAntesDeVolar());
    }

    protected abstract String doAntesDeVolar();
}
