public class Camino {
    private Posicion inicio;
    private Posicion fin;

    public Camino(Posicion inicio, Posicion fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    public boolean contiene(Posicion p) {
        int minX = Math.min(inicio.getX(), fin.getX());
        int maxX = Math.max(inicio.getX(), fin.getX());
        int minY = Math.min(inicio.getY(), fin.getY());
        int maxY = Math.max(inicio.getY(), fin.getY());
        return p.getX() >= minX && p.getX() <= maxX && p.getY() >= minY && p.getY() <= maxY;
    }

    public Posicion getInicio() { return inicio; }
    public Posicion getFin() { return fin; }
}
