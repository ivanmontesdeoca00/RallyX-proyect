public class NaveEnemiga extends Enemigo {
    private String patronMovimiento;
    private Jugador objetivo;

    public NaveEnemiga(Posicion posicion, int velocidad, int agresividad, Jugador objetivo) {
        super(posicion, velocidad, agresividad);
        this.objetivo = objetivo;
        this.patronMovimiento = "ZIGZAG";
    }

    @Override
    public void ejecutarCicloIA() {
        patrullar();
    }

    public void patrullar() {
        // Desplazamiento periódico según patronMovimiento
    }

    public void bloquearRuta() {
        // Intenta colocarse delante del jugador
    }

    @Override
    public void perseguir(Jugador jugador) {
        // Ajusta la trayectoria hacia el jugador
    }

    @Override
    public void colisionarConJugador() {
        if (objetivo != null) {
            objetivo.perderVida();
        }
    }

    @Override
    public void aumentarAgresividad() {
        this.agresividad++;
    }

    public String getPatronMovimiento() {
        return patronMovimiento;
    }

    public void setPatronMovimiento(String patronMovimiento) {
        this.patronMovimiento = patronMovimiento;
    }
}