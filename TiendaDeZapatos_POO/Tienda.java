
import java.util.Random;
public class Tienda {

    //Zona de atributos
    private int cantidadZapatos;
    private Zapato[] losZapatos;
    private String[] losEstilos, losColores;
    private int[] lasTallas;
    private boolean estaLista;

    //Zona de Constructores
    public Tienda() {
        cantidadZapatos= 0;
        estaLista = false;
        inicializaArreglos();
    }

    public Tienda(int cantidadZapatos) {
        if (cantidadZapatos > 0)
            this.cantidadZapatos = cantidadZapatos;
        else
        {
            this.cantidadZapatos = 0;
            estaLista = false;
        }

        inicializaArreglos();
    }

    private void inicializaArreglos()
    {
        losEstilos = new String[]{
                "Tenis",
                "Botas",
                "Crocs Metaleras",
                "Mocasines",
                "Sandalia Gladiadora" };

        losColores = new String[] {
                        "Verde Selva",
                        "Azul Petróleo",
                        "Rojo Sangre",
                        "Café derrumbe de montaña"
                };

        lasTallas = new int[] { 28, 30, 32, 34, 36, 38, 40, 42, 44 };

        //Aqui inicializamos el arreglo de los zapatos
        //Siempre y cuando tengamos una cantidad válida

        if (cantidadZapatos > 0)
        {
            losZapatos = new Zapato[cantidadZapatos];
            Random aleatorio = new Random();

            for (int i = 0; i < losZapatos.length; i++) {
                losZapatos[i] = new Zapato();

                losZapatos[i].setTalla(lasTallas[aleatorio.nextInt(lasTallas.length)]);
                losZapatos[i].setColor(losColores[aleatorio.nextInt(losColores.length)]);
                losZapatos[i].setEstilo(losEstilos[aleatorio.nextInt(losEstilos.length)]);
            }

            //La tienda está lista para vender
            estaLista = true;
        }
    }

    public String[] getColores() {
        return losColores;
    }
    public String[] getEstilos() {
        return losEstilos;
    }

    public int[] getTallas(){
        return lasTallas;
    }

    public Zapato[] getZapatos(){
        return losZapatos;
    }

    public ZapatoModa ObtieneEstiloModa(){
        ZapatoModa zapatoResultado = CalculaEstiloMayor(losZapatos, losEstilos);
        return zapatoResultado;
    }

    public ZapatoModa CalculaEstiloMayor(Zapato[] arregloZapatos, String[] arregloEstilos)
    {
        int[] contadorEstilos = new int[arregloEstilos.length];

        //Precaución: Garantiza que todos los contadores inicien en 0
        for (int i = 0; i < contadorEstilos.length; i++)
            contadorEstilos[i] = 0;

        //Aqui recorremos los arreglos de estilo y zapato
        for (int i = 0; i < arregloEstilos.length; i++)
        {
            for (int j = 0; j < arregloZapatos.length; j++)
            {
                if (arregloEstilos[i] == arregloZapatos[j].getEstilo())
                    contadorEstilos[i]++;
            }
        }

        //Aqui identificamos el mayor, el estilo que más zapatos tiene, el primero de ellos
        int valorMayor = contadorEstilos[0];
        int posicionMayor = 0;

        for (int i = 1; i < contadorEstilos.length; i++)
        {
            if (contadorEstilos[i] > valorMayor)
            {
                valorMayor = contadorEstilos[i];
                posicionMayor = i;
            }
        }

        //Aqui declaramos el objeto resultado
        ZapatoModa zapatoResultado = new ZapatoModa();

        zapatoResultado.setCantidad(valorMayor);
        zapatoResultado.setEstilo(losEstilos[posicionMayor]);

        return zapatoResultado;
    }
}
