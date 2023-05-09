import java.util.ArrayList;

public class Album implements IColeccionAbstracta {
    private ArrayList<Lamina> lasLaminas;
    private String nombre;

    public Album() {
        this.lasLaminas = new ArrayList<Lamina>();
        this.nombre ="";
    }

    public Iterador CrearIterador() {
        return new Iterador(this);
    }

    public int GetCantidad() {
        return lasLaminas.size();
    }

    public String GetNombre() {
        return nombre;
    }

    public void SetNombre(String nombre) {
        this.nombre = nombre;
    }

    public Lamina GetLamina(int posicion) {
        return lasLaminas.get(posicion);
    }
    public void SetLamina(Lamina unaLamina){
        lasLaminas.add(unaLamina);
    }
}
