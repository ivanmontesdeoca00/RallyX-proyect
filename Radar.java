import java.util.ArrayList;
import java.util.List;

public class Radar {
    private List<Entidad> objetosDetectados;
    private int rango;

    public Radar(int rango) {
        this.rango = rango;
        this.objetosDetectados = new ArrayList<>();
    }

    public void actualizar(List<Entidad> entidadesEnMapa) {
        this.objetosDetectados.clear();
        for (Entidad e : entidadesEnMapa) {
            if (e.isActivo()) {
                this.objetosDetectados.add(e);
            }
        }
    }

    public void mostrarBanderas() {
        System.out.println("--- [RADAR: BANDERAS] ---");
        for (Entidad e : objetosDetectados) {
            if (e instanceof BanderaGasolina) {
                System.out.println(" * " + e.getTipoEntidad() + " en " + e.getPosicion());
            }
        }
    }

    public void mostrarEnemigos() {
        System.out.println("--- [RADAR: AMENAZAS] ---");
        for (Entidad e : objetosDetectados) {
            if (e instanceof Enemigo) {
                System.out.println(" ! " + e.getTipoEntidad() + " en " + e.getPosicion());
            }
        }
    }

    public List<Entidad> getObjetosDetectados() { return objetosDetectados; }
}
