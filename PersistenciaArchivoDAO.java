import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PersistenciaArchivoDAO implements IPersistenciaDAO {

    @Override
    public boolean guardarPartida(PartidaGuardada partida, String rutaArchivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            oos.writeObject(partida);
            return true;
        } catch (IOException e) {
            System.err.println("Error al guardar la partida: " + e.getMessage());
            return false;
        }
    }

    @Override
    public PartidaGuardada cargarPartida(String rutaArchivo) throws IOException, ClassNotFoundException {
        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) {
            return null;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (PartidaGuardada) ois.readObject();
        }
    }
}