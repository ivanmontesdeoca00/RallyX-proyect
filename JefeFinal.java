public class JefeFinal extends Enemigo {
    private final int apareceEn = 10;
    private int vida;
    private Jugador objetivo;

    public JefeFinal(Posicion posicion, int velocidad, int agresividad, Jugador objetivo, int vida) {
        super(posicion, velocidad, agresividad);
        this.objetivo = objetivo;
        this.vida = vida;
    }

    @Override
    public void ejecutarCicloIA() {
        if (vida > 0) {
            atacar();
        }
    }

    public void protegerObjetivos() {
        // Bloquea el acceso a las banderas o al objetivo del nivel 10
    }

    public void atacar() {
        if (objetivo != null) {
            perseguir(objetivo);
        }
    }

    public void derrotar() {
        this.vida = 0;
        detenerComportamiento();
    }

    @Override
    public void perseguir(Jugador jugador) {
        // Patrón agresivo de persecución final
    }

    @Override
    public void colisionarConJugador() {
        if (objetivo != null) {
            objetivo.perderVida();
        }
    }

    @Override
    public void aumentarAgresividad() {
        this.agresividad += 5;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getApareceEn() {
        return apareceEn;
    }
}