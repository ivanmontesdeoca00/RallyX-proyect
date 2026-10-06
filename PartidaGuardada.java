import java.io.Serializable;

public class PartidaGuardada implements Serializable {
    private static final long serialVersionUID = 1L;

    private int nivelActual;
    private int vidasJugador;
    private int combustibleActual;
    private int puntaje;
    private int tiempoRestante;

    public PartidaGuardada(int nivelActual, int vidasJugador, int combustibleActual, int puntaje, int tiempoRestante) {
        this.nivelActual = nivelActual;
        this.vidasJugador = vidasJugador;
        this.combustibleActual = combustibleActual;
        this.puntaje = puntaje;
        this.tiempoRestante = tiempoRestante;
    }

    public int getNivelActual() { return nivelActual; }
    public int getVidasJugador() { return vidasJugador; }
    public int getCombustibleActual() { return combustibleActual; }
    public int getPuntaje() { return puntaje; }
    public int getTiempoRestante() { return tiempoRestante; }
}