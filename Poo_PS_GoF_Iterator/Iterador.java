public class Iterador implements IIteradorAbstracto {
    private Album unaColeccion;
    private int actual;
    private int incremento;

    public Iterador(Album laColeccion) {
        this.unaColeccion = laColeccion;
        actual = 0;
        incremento = 1;
    }

    public Lamina Primera() {
        actual = 0;
        return unaColeccion.GetLamina(actual);
    }

    public Lamina Siguiente() {
        actual += incremento;
        if (!EstaTerminado())
            return unaColeccion.GetLamina(actual);
        else
            return null;
    }

    public int GetIncremento() {
        return incremento;
    }
    public void SetIncremento(int incremento) {
        this.incremento = incremento;
    }
    public Lamina LaminaActual() {
        return unaColeccion.GetLamina(actual);
    }
    public boolean EstaTerminado() {
        if (actual >= unaColeccion.GetCantidad())
            return true;
        else
            return false;
    }
}