public class CocheRojo extends Enemigo {
    private Estrategia estrategia;
    private Jugador objetivo;

    public CocheRojo(Posicion posicion, int velocidad, int agresividad, Jugador objetivo) {
        super(posicion, velocidad, agresividad);
        this.objetivo = objetivo;
    }

    @Override
    public void ejecutarCicloIA() {
        if (objetivo != null) {
            perseguir(objetivo);
        }
    }

    @Override
    public void perseguir(Jugador jugador) {
        // Lógica de persecución del CocheRojo hacia el jugador
    }

    public void embestir() {
        // Ataque característico de embestida
    }

    @Override
    public void colisionarConJugador() {
        if (objetivo != null) {
            objetivo.perderVida();
        }
    }

    @Override
    public void aumentarAgresividad() {
        this.agresividad += 2;
    }

    public Estrategia getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(Estrategia estrategia) {
        this.estrategia = estrategia;
    }
}