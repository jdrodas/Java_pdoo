public class ZapatoModa extends Zapato {

    //Zona de Atributos
    private int cantidad;

    public ZapatoModa() {
        cantidad = 0;
        talla = 0;
        estilo = "ninguno";
        color = "Sin asignar";
    }

    public ZapatoModa(String estilo, String color, int talla, int cantidad)
    {
        this.cantidad = cantidad;
        this.color = color;
        this.talla = talla;
        this.estilo = estilo;
    }

    public int getCantidad()
    {
        return cantidad;
    }

    public void setCantidad(int datoCantidad)
    {
        if (datoCantidad > 0)
            cantidad = datoCantidad;
        else
            cantidad = 0;
    }
}
