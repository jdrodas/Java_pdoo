import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Aplicación para simular la venta de zapatos");

        //Aqui pedimos cuantos zapatos tendrá la tienda
        Scanner sc = new Scanner(System.in);
        int cantidadZapatos =0;
        boolean datoCorrecto = false;

        do {
            try {
                System.out.print("\nIngresa la cantidad de zapatos que tendrá la tienda: ");
                cantidadZapatos = sc.nextInt();

                if (cantidadZapatos > 0)
                    datoCorrecto = true;
                else {
                    System.out.println("El dato ingresado no representa una cantidad válida. Intenta nuevamente!");
                }
            }
            catch (InputMismatchException errorDato) {
                System.out.println("El dato ingresado no está en el formato correcto. Intenta nuevamente!");
                sc.next();
            }
        }
        while(!datoCorrecto);

        //Aqui creo una instancia de la clase tienda
        Tienda miTiendita = new Tienda(cantidadZapatos);

        //Aqui leo los estilos disponibles
        System.out.println("Los estilos disponibles son:");

        String[] losEstilos = miTiendita.getEstilos();
        for(String estilo: losEstilos)
            System.out.println("- " + estilo);

        //Aqui leo los colores
        System.out.println("\nLos Colores Disponibles son:");

        String[] losColores = miTiendita.getColores();
        for(String color: losColores)
            System.out.println("- " + color);

        //Aqui leo las tallas
        System.out.println("\nLas tallas disponibles son:");

        int[] lasTallas = miTiendita.getTallas();
        for(int talla: lasTallas)
            System.out.println("- " + talla);

        System.out.println("\nLa tienda quedó surtida con estos zapatos:");

        int contador = 1;
        Zapato[] losZapatos = miTiendita.getZapatos();

        for(Zapato unZapato : losZapatos) {
            System.out.println("No. " + contador +
                    ", Talla: " + unZapato.getTalla() +
                    ", Color: " + unZapato.getColor() +
                    ", Estilo: " + unZapato.getEstilo());
            contador++;
        }
    }
}