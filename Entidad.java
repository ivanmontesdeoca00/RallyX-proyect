/**
 * Superclase para todas las entidades presentes en el mapa detectables por el Radar.
 */
public abstract class Entidad {
    protected Posicion posicion;
    protected boolean activo;

    public Entidad(Posicion posicion) {
        this.posicion = posicion;
        this.activo = true;
    }

    public Posicion getPosicion() { return posicion; }
    public void setPosicion(Posicion posicion) { this.posicion = posicion; }

    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }

    public abstract String getTipoEntidad();
}
