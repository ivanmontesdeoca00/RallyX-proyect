public class Cronometro implements Runnable {
    private int tiempoRestante;
    private volatile boolean activo;
    private Thread hilo;

    public Cronometro(int tiempoInicialSegundos) {
        this.tiempoRestante = tiempoInicialSegundos;
        this.activo = false;
    }

    public synchronized void iniciar() {
        if (!activo) {
            activo = true;
            hilo = new Thread(this, "Hilo-Cronometro");
            hilo.start();
        }
    }

    public synchronized void detener() {
        activo = false;
        if (hilo != null) {
            hilo.interrupt();
        }
    }

    public synchronized void descontarTiempo() {
        if (tiempoRestante > 0) {
            tiempoRestante--;
        } else {
            activo = false;
        }
    }

    @Override
    public void run() {
        while (activo && tiempoRestante > 0) {
            try {
                Thread.sleep(1000); // 1 segundo
                descontarTiempo();
                // Opcional: Notificar avance
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        activo = false;
    }

    public synchronized int getTiempoRestante() {
        return tiempoRestante;
    }

    public synchronized void setTiempoRestante(int tiempoRestante) {
        this.tiempoRestante = tiempoRestante;
    }

    public boolean isActivo() {
        return activo;
    }
}
