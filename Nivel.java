import java.util.ArrayList;
import java.util.List;

public class Nivel {
    private int numero;
    private final int maximo = 10;
    private int tiempoPorNivel;
    private Laberinto laberinto;
    private List<BanderaGasolina> banderas;
    private List<Enemigo> enemigos;
    private ObjetivoFinal objetivoFinal;

    public Nivel(int numero, Jugador jugador) {
        this.numero = numero;
        this.tiempoPorNivel = 300; // 5 minutos por nivel
        this.laberinto = new Laberinto(50, 50);
        this.banderas = new ArrayList<>();
        this.enemigos = new ArrayList<>();
        configurarNivel(jugador);
    }

    private void configurarNivel(Jugador jugador) {
        // Banderas del nivel
        banderas.add(new BanderaGasolina(new Posicion(5, 5), false));
        banderas.add(new BanderaGasolina(new Posicion(15, 10), false));
        banderas.add(new BanderaGasolina(new Posicion(25, 20), true)); // Bandera especial

        // Enemigos con los parámetros: (posicion, velocidad, agresividad, jugador [, vida])
        enemigos.add(new CocheRojo(new Posicion(30, 30), 2, 3, jugador));

        if (numero >= 5) {
            enemigos.add(new EnemigoEspecial(new Posicion(10, 40), 3, 4, jugador));
            enemigos.add(new NaveEnemiga(new Posicion(20, 5), 3, 2, jugador));
        }

        if (numero == 10) {
            enemigos.add(new JefeFinal(new Posicion(45, 45), 4, 5, jugador, 100));
            this.objetivoFinal = new ObjetivoFinal("Destruir al Jefe Final y recoger todas las banderas");
        }
    
    }

    public boolean verificarCompletado() {
        for (BanderaGasolina b : banderas) {
            if (!b.estaRecogida()) return false;
        }
        if (esNivelFinal() && objetivoFinal != null) {
            return objetivoFinal.verificarEstado();
        }
        return true;
    }

    public boolean esNivelFinal() {
        return numero == maximo;
    }

    public int getNumero() { return numero; }
    public Laberinto getLaberinto() { return laberinto; }
    public List<BanderaGasolina> getBanderas() { return banderas; }
    public List<Enemigo> getEnemigos() { return enemigos; }
    public ObjetivoFinal getObjetivoFinal() { return objetivoFinal; }
}
