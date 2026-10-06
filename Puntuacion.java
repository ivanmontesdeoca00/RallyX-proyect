public class Puntuacion {
    private int puntos;
    private int puntuacionFinal;

    public Puntuacion() {
        this.puntos = 0;
        this.puntuacionFinal = 0;
    }

    public void sumarBandera(boolean esEspecial) {
        int valor = esEspecial ? 500 : 100;
        this.puntos += valor;
        System.out.println("[PUNTOS] +" + valor + " por bandera. Total: " + this.puntos);
    }

    public void sumarEnemigo() {
        this.puntos += 300;
        System.out.println("[PUNTOS] +300 por neutralizar enemigo con humo. Total: " + this.puntos);
    }

    public void registrarPuntuacionFinal(int bonusCombustible) {
        this.puntuacionFinal = this.puntos + bonusCombustible;
        System.out.println(">> Puntuación final registrada: " + this.puntuacionFinal + " (Bonus restante: +" + bonusCombustible + ")");
    }

    public int getPuntos() { return puntos; }
    public int getPuntuacionFinal() { return puntuacionFinal; }
}
