public class BanderaGasolina extends Entidad {
    private boolean recogida;
    private final boolean esEspecial;

    public BanderaGasolina(Posicion posicion, boolean esEspecial) {
        super(posicion);
        this.recogida = false;
        this.esEspecial = esEspecial;
    }

    public void recoger() {
        this.recogida = true;
        this.activo = false;
    }

    public boolean estaRecogida() {
        return recogida;
    }

    public boolean isEsEspecial() {
        return esEspecial;
    }

    @Override
    public String getTipoEntidad() {
        return esEspecial ? "Bandera Especial (S)" : "Bandera Gasolina";
    }
}
