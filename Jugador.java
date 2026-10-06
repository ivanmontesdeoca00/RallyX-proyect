public class Jugador extends Entidad {
    private int vidas;
    private Combustible combustible;

    public Jugador(Posicion posicion) {
        super(posicion);
        this.vidas = 3;
        this.combustible = new Combustible(100);
    }

    public void mover(Direccion direccion) {
        if (combustible.estaVacio()) {
            System.out.println("¡Sin combustible! El coche no responde.");
            perderVida();
            return;
        }

        switch (direccion) {
            case ARRIBA: posicion.setY(posicion.getY() - 1); break;
            case ABAJO: posicion.setY(posicion.getY() + 1); break;
            case IZQUIERDA: posicion.setX(posicion.getX() - 1); break;
            case DERECHA: posicion.setX(posicion.getX() + 1); break;
        }

        combustible.consumir(1);
        System.out.println("Jugador se desplaza a " + posicion + " | Combustible: " + combustible.getActual());

        if (combustible.estaVacio()) {
            System.out.println("¡Combustible agotado!");
            perderVida();
        }
    }

    public void recogerBandera(BanderaGasolina bandera) {
        if (bandera != null && !bandera.estaRecogida()) {
            bandera.recoger();
            if (bandera.isEsEspecial()) {
                System.out.println(">> ¡Bandera Especial recogida! Se recargan 40 de combustible.");
                combustible.recargar(40);
            } else {
                System.out.println(">> Bandera normal recogida.");
            }
        }
    }

    public Smokescreen usarSmokescreen() {
        if (combustible.getActual() >= 10) {
            combustible.consumir(10);
            Smokescreen smoke = new Smokescreen(5, 4);
            smoke.activar(this.posicion);
            System.out.println("Smokescreen activado (-10 combustible). Restante: " + combustible.getActual());
            return smoke;
        } else {
            System.out.println("Combustible insuficiente para activar Smokescreen.");
            return null;
        }
    }

    public boolean perderVida() {
        this.vidas--;
        System.out.println("¡Jugador pierde 1 vida! Vidas restantes: " + this.vidas);
        if (this.vidas > 0) {
            this.combustible = new Combustible(100);
        } else {
            this.activo = false;
        }
        return this.vidas > 0;
    }

    public int getVidas() { return vidas; }
    public Combustible getCombustible() { return combustible; }

    @Override
    public String getTipoEntidad() { return "Coche Jugador"; }
}
