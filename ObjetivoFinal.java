public class ObjetivoFinal {
    private String descripcion;
    private boolean completado;

    public ObjetivoFinal(String descripcion) {
        this.descripcion = descripcion;
        this.completado = false;
    }

    public void completar() {
        this.completado = true;
        System.out.println(">> ¡Objetivo Final completado!: " + descripcion);
    }

    public boolean verificarEstado() {
        return completado;
    }

    public String getDescripcion() { return descripcion; }
}
