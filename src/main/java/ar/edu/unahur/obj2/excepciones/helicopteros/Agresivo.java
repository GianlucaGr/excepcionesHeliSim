package ar.edu.unahur.obj2.excepciones.helicopteros;

public class Agresivo implements ModoDeVuelo{

    @Override
    public Double consumo() {
    return 6.0;    
    }

    @Override
    public Integer velocidadMaxima() {
        return 280;
    }

}
