import java.util.List;

public class Smokescreen {
    private int duracion;
    private int radio;
    private Posicion posicion;

    public Smokescreen(int duracion, int radio) {
        this.duracion = duracion;
        this.radio = radio;
    }

    public void activar(Posicion pos) {
        if (pos != null) {
            this.posicion = new Posicion(pos.getX(), pos.getY());
            System.out.println(">> Cortina de humo (Smokescreen) desplegada en " + this.posicion);
        }
    }

    public void confundir(List<Enemigo> enemigos) {
        if (posicion == null || enemigos == null) {
            return;
        }

        for (Enemigo e : enemigos) {
            if (e != null && e.isActivo() && e.getPosicion() != null) {
                if (e.getPosicion().distanciaA(this.posicion) <= radio) {
                    e.setConfundido(true);
                    System.out.println(">> ¡" + e.getClass().getSimpleName() + " cegado por el humo!");
                }
            }
        }
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    public Posicion getPosicion() {
        return posicion;
    }
}