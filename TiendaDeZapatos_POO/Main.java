package TiendaDeZapatos_POO;

import java.util.Random;
public class Main {
    public static void main(String[] args) {
        System.out.println("Aplicación para simular la venta de 100 zapatos");
        System.out.println("Los estilos disponibles son:");

        String[] losEstilos = {
                "Tenis",
                "Botas",
                "Crocs Metaleras",
                "Mocasines",
                "Sandalia Gladiadora"
        };

        for(String estilo: losEstilos)
            System.out.println("- " + estilo);

        System.out.println("\nLos Colores Disponibles son:");

        String[] losColores = {
            "Verde Selva",
            "Azul Petróleo",
            "Rojo Sangre",
            "Café derrumbe de montaña"
        };

        for(String color: losColores)
            System.out.println("- " + color);

        System.out.println("\nLas tallas disponibles son:");
        int[] lasTallas = { 28, 30, 32, 34, 36, 38, 40, 42, 44 };

        for(int talla: lasTallas)
            System.out.println("- " + talla);

        Zapato[] losZapatos = new Zapato[100];
        Random aleatorio = new Random();

        for (int i = 0; i < losZapatos.length; i++) {
            losZapatos[i] = new Zapato();

            losZapatos[i].setTalla(lasTallas[aleatorio.nextInt(lasTallas.length)]);
            losZapatos[i].setColor(losColores[aleatorio.nextInt(losColores.length)]);
            losZapatos[i].setEstilo(losEstilos[aleatorio.nextInt(losEstilos.length)]);
        }

        System.out.println("\nLa tienda quedó surtida con estos zapatos:");

        int contador = 1;

        for(Zapato unZapato : losZapatos) {
            System.out.println("No. " + contador +
                                ", Talla: " + unZapato.getTalla() +
                                ", Color: " + unZapato.getColor() +
                                ", Estilo: " + unZapato.getEstilo());
            contador++;
        }
    }
}