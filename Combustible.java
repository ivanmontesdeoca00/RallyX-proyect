public class Combustible {
    private int actual;
    private int capacidadMaxima;

    public Combustible(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.actual = capacidadMaxima;
    }

    public void consumir(int cantidad) {
        this.actual -= cantidad;
        if (this.actual < 0) {
            this.actual = 0;
        }
    }

    public void recargar(int cantidad) {
        this.actual += cantidad;
        if (this.actual > capacidadMaxima) {
            this.actual = capacidadMaxima;
        }
    }

    public boolean estaVacio() {
        return this.actual <= 0;
    }

    public int getActual() { return actual; }
    public int getCapacidadMaxima() { return capacidadMaxima; }
}
