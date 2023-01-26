public class Zapato {

    //Zona de Atributos
    private String estilo, color;
    private int talla;

    //Zona de Constructor
    public Zapato(){
        talla = 0;
        estilo = "ninguno";
        color = "Sin asignar";
    }

    public void setTalla(int datoTalla) {
        if (datoTalla >= 28 && datoTalla <= 44)
            talla = datoTalla;
        else
            talla = 0;
    }
    public int getTalla() {
        return talla;
    }

    public void setEstilo(String datoEstilo) {
        estilo = datoEstilo;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setColor(String datoColor) {
        color = datoColor;
    }

    public String getColor() {
        return color;
    }
}