import java.util.ArrayList;
import java.util.List;

public class Laberinto {
    private List<Camino> caminos;
    private int ancho;
    private int alto;

    public Laberinto(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        this.caminos = new ArrayList<>();
        inicializarCaminos();
    }

    private void inicializarCaminos() {
        caminos.add(new Camino(new Posicion(0, 0), new Posicion(ancho, 0)));
        caminos.add(new Camino(new Posicion(0, 0), new Posicion(0, alto)));
        caminos.add(new Camino(new Posicion(0, alto), new Posicion(ancho, alto)));
        caminos.add(new Camino(new Posicion(ancho, 0), new Posicion(ancho, alto)));
    }

    public boolean permitirMovimiento(Posicion p) {
        if (p.getX() < 0 || p.getX() > ancho || p.getY() < 0 || p.getY() > alto) {
            return false;
        }
        return true;
    }

    public void calcularRuta() {
        System.out.println("Laberinto: recalculando nodos transitables para entidades.");
    }

    public List<Camino> getCaminos() { return caminos; }
    public int getAncho() { return ancho; }
    public int getAlto() { return alto; }
}
