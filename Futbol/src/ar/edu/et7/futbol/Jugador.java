package ar.edu.et7.futbol;

public abstract class Jugador {
    protected String nombre;
    protected String posicion;
    protected int numero;

    public Jugador(String nombre, String posicion, int numero) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public int getNumero() {
        return numero;
    }
}
