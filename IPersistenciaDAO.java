import java.io.IOException;

public interface IPersistenciaDAO {
    boolean guardarPartida(PartidaGuardada partida, String rutaArchivo);
    PartidaGuardada cargarPartida(String rutaArchivo) throws IOException, ClassNotFoundException;
}