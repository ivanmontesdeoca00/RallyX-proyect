public abstract class Enemigo extends Entidad implements Runnable {
    protected int velocidad;
    protected int agresividad;
    protected volatile boolean activo;
    protected boolean confundido;
    protected Thread hilo;

    public Enemigo(Posicion posicion, int velocidad, int agresividad) {
        super(posicion);
        this.velocidad = velocidad;
        this.agresividad = agresividad;
        this.activo = false;
        this.confundido = false;
    }

    // --- SOLUCIÓN AL ERROR: Implementa getTipoEntidad() de Entidad ---
    @Override
    public String getTipoEntidad() {
        return getClass().getSimpleName();
    }

    public synchronized void iniciarComportamiento() {
        if (!activo) {
            activo = true;
            hilo = new Thread(this, "Hilo-" + getClass().getSimpleName());
            hilo.start();
        }
    }

    public synchronized void detenerComportamiento() {
        activo = false;
        if (hilo != null) {
            hilo.interrupt();
        }
    }

    @Override
    public void run() {
        while (activo) {
            try {
                int espera = Math.max(100, 1000 / (velocidad > 0 ? velocidad : 1));
                Thread.sleep(espera);
                
                if (!confundido) {
                    ejecutarCicloIA();
                } else {
                    Thread.sleep(1000);
                    setConfundido(false);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public abstract void ejecutarCicloIA();
    public abstract void perseguir(Jugador jugador);
    public abstract void colisionarConJugador();
    public abstract void aumentarAgresividad();

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public boolean isConfundido() {
        return confundido;
    }

    public void setConfundido(boolean confundido) {
        this.confundido = confundido;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getAgresividad() {
        return agresividad;
    }

    public void setAgresividad(int agresividad) {
        this.agresividad = agresividad;
    }
}