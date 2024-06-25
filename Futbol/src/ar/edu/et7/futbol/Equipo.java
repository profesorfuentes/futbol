package ar.edu.et7.futbol;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private String nombre;
    private List<Jugador> jugadores;
    private DirectorTecnico directorTecnico;

    public Equipo(String nombre, DirectorTecnico directorTecnico) {
        this.nombre = nombre;
        this.jugadores = new ArrayList<>();
        this.directorTecnico = directorTecnico;
    }

    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public String getNombre() {
        return nombre;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public DirectorTecnico getDirectorTecnico() {
        return directorTecnico;
    }
}

