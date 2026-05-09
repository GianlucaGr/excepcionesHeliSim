package ar.edu.unahur.obj2.excepciones.helicopteros;

public class Normal implements ModoDeVuelo {

    @Override
    public Double consumo() {
        return 9.0;
        }

    @Override
    public Integer velocidadMaxima() {
        return 220;
    }

}
