public class EnemigoEspecial extends Enemigo {
    private final int apareceDesde = 5;
    private Jugador objetivo;

    public EnemigoEspecial(Posicion posicion, int velocidad, int agresividad, Jugador objetivo) {
        super(posicion, velocidad, agresividad);
        this.objetivo = objetivo;
    }

    @Override
    public void ejecutarCicloIA() {
        usarHabilidad();
    }

    public void usarHabilidad() {
        bloquearRuta();
    }

    public void bloquearRuta() {
        // Bloqueo avanzado de casillas del laberinto
    }

    @Override
    public void perseguir(Jugador jugador) {
        // Persecución con predicción de ruta
    }

    @Override
    public void colisionarConJugador() {
        if (objetivo != null) {
            objetivo.perderVida();
        }
    }

    @Override
    public void aumentarAgresividad() {
        this.agresividad += 3;
    }

    public int getApareceDesde() {
        return apareceDesde;
    }
}