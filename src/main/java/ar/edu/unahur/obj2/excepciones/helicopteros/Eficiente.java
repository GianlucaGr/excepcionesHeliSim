package ar.edu.unahur.obj2.excepciones.helicopteros;

public class Eficiente implements ModoDeVuelo{

    @Override
    public Double consumo() {
        return 14.0;
    }

    @Override
    public Integer velocidadMaxima() {
        return 180;
    }

}
