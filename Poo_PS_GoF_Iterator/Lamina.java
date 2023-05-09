public class Lamina {
    private String nombre;
    private int consecutivo;

    public Lamina(int consecutivo, String nombre) {
        this.consecutivo = consecutivo;
        this.nombre = nombre;
    }
    public String GetNombre() {
        return nombre;
    }

    public int GetConsecutivo() {
        return consecutivo;
    }

    @Override
    public String toString() {
        String informacion = "No. " + consecutivo + "\n" +
            "Nombre: "+ nombre +"\n";

        return informacion;
    }
}