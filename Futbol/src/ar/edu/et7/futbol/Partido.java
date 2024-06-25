package ar.edu.et7.futbol;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Partido extends JFrame {
    private EquipoLocal equipoLocal;
    private EquipoVisitante equipoVisitante;
    private Timer timer;
    private int timeElapsed;

    public Partido(EquipoLocal equipoLocal, EquipoVisitante equipoVisitante) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;

        setTitle("Partido de Futbol");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // Configurar un Timer para la duración del partido
        timeElapsed = 0;
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeElapsed++;
                if (timeElapsed >= 120) { // 2 minutos
                    timer.stop();
                    dispose(); // Cerrar la ventana después de 2 minutos
                }
                repaint(); // Redibujar la pantalla
            }
        });
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawCampo(g);
        drawEquipo(g, equipoLocal, 100);
        drawEquipo(g, equipoVisitante, 500);
    }

    private void drawCampo(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(50, 50, 700, 500);

        g.setColor(Color.WHITE);
        g.drawRect(50, 50, 700, 500);
        g.drawLine(400, 50, 400, 550);
    }

    private void drawEquipo(Graphics g, Equipo equipo, int xOffset) {
        int y = 100;
        for (Jugador jugador : equipo.getJugadores()) {
            g.drawString(jugador.getNombre() + " (" + jugador.getPosicion() + ")", xOffset, y);
            y += 40;
        }
    }

    public static void main(String[] args) {
        DirectorTecnico dtLocal = new DirectorTecnico("DT Local");
        EquipoLocal equipoLocal = new EquipoLocal("Equipo Local", dtLocal);
        equipoLocal.agregarJugador(new Arquero("Arquero Local", 1));
        equipoLocal.agregarJugador(new LateralDerecho("Lateral Derecho Local", 2));
        equipoLocal.agregarJugador(new LateralIzquierdo("Lateral Izquierdo Local", 3));
        equipoLocal.agregarJugador(new Central("Central Local", 4));
        equipoLocal.agregarJugador(new MedioCampista("Mediocampista Local", 5));
        equipoLocal.agregarJugador(new Volante("Volante Local", 6));
        equipoLocal.agregarJugador(new Extremo("Extremo Local", 7));
        equipoLocal.agregarJugador(new Delantero("Delantero Local", 8));
        equipoLocal.agregarJugador(new DelanteroCentro("Delantero Centro Local", 9));

        DirectorTecnico dtVisitante = new DirectorTecnico("DT Visitante");
        EquipoVisitante equipoVisitante = new EquipoVisitante("Equipo Visitante", dtVisitante);
        equipoVisitante.agregarJugador(new Arquero("Arquero Visitante", 1));
        equipoVisitante.agregarJugador(new LateralDerecho("Lateral Derecho Visitante", 2));
        equipoVisitante.agregarJugador(new LateralIzquierdo("Lateral Izquierdo Visitante", 3));
        equipoVisitante.agregarJugador(new Central("Central Visitante", 4));
        equipoVisitante.agregarJugador(new MedioCampista("Mediocampista Visitante", 5));
        equipoVisitante.agregarJugador(new Volante("Volante Visitante", 6));
        equipoVisitante.agregarJugador(new Extremo("Extremo Visitante", 7));
        equipoVisitante.agregarJugador(new Delantero("Delantero Visitante", 8));
        equipoVisitante.agregarJugador(new DelanteroCentro("Delantero Centro Visitante", 9));

        new Partido(equipoLocal, equipoVisitante);
    }
}
