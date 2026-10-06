public class JuegoRallyX {
    // Atributos existentes del diagrama
    private int nivelActual;
    private EstadoJuego estado;
    private Jugador jugador;
    private Cronometro cronometro;
    private Puntuacion puntuacion;
    
    // Atributo nuevo para la persistencia
    private IPersistenciaDAO persistenciaDAO;
    private final String ARCHIVO_GUARDADO = "rallyx_save.dat";

    public JuegoRallyX() {
        this.persistenciaDAO = new PersistenciaArchivoDAO();
        this.cronometro = new Cronometro(300); // 5 minutos por nivel
        // Inicializar demás componentes...
    }

    // --- Persistencia ---
    public boolean guardarPartida() {
        int tiempo = cronometro != null ? cronometro.getTiempoRestante() : 0;
        int combustible = (jugador != null && jugador.getCombustible() != null) ? jugador.getCombustible().getActual() : 0;
        int vidas = jugador != null ? jugador.getVidas() : 3;
        int puntos = puntuacion != null ? puntuacion.getPuntos() : 0;

        PartidaGuardada datos = new PartidaGuardada(nivelActual, vidas, combustible, puntos, tiempo);
        return persistenciaDAO.guardarPartida(datos, ARCHIVO_GUARDADO);
    }

    public boolean cargarPartida() {
        try {
            PartidaGuardada datos = persistenciaDAO.cargarPartida(ARCHIVO_GUARDADO);
            if (datos == null) return false;

            this.nivelActual = datos.getNivelActual();
            if (this.cronometro != null) {
                this.cronometro.setTiempoRestante(datos.getTiempoRestante());
            }
            // Restaurar vidas, combustible y puntos en los objetos correspondientes
            return true;
        } catch (Exception e) {
            System.err.println("No se pudo cargar la partida: " + e.getMessage());
            return false;
        }
    }

    // --- Concurrencia ---
    public void iniciarPartida() {
        if (cronometro != null) {
            cronometro.iniciar(); // Arranca el hilo del reloj
        }
        // Si hay una lista de enemigos en el nivel, se inicia el hilo de cada uno:
        // for (Enemigo e : enemigos) { e.iniciarComportamiento(); }
    }

    public void pausarOJuegoTerminado() {
        if (cronometro != null) {
            cronometro.detener();
        }
        // for (Enemigo e : enemigos) { e.detenerComportamiento(); }
    }
}