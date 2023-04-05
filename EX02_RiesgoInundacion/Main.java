import LogicaInundacion.GestionRiesgo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.print("Programa para Simular el monitoreo de zonas en riesgo de inundación");
        System.out.print("Se valorarán riesgos por inundación urbana, costera y fluvial");

        //Aqui pedimos cuantas zonas serán monitoreadas
        Scanner sc = new Scanner(System.in);
        int cantidadZonas=0;
        boolean datoCorrecto=false;

        do
        {
            try
            {
                System.out.print("\nIngresa la cantidad de zonas a monitorear: ");
                cantidadZonas = sc.nextInt();

                if (cantidadZonas <= 0)
                    System.out.print("La cantidad de zonas debe ser un entero positivo. Intenta nuevamente");
                else
                    datoCorrecto = true;
            }
            catch (InputMismatchException errorDato) {
                System.out.println("El dato ingresado no está en el formato correcto. Intenta nuevamente!");
                sc.next();
            }
        }
        while (!datoCorrecto);

        System.out.print("\n\nGenerando simulación de inundación para " + cantidadZonas + " zonas... ");

        GestionRiesgo gestor = new GestionRiesgo(cantidadZonas);

        System.out.print("Finalizado!");

        //Aqui visualizamos resultados
        System.out.print("\n\n **** Resultados Obtenidos de la simulación *** ");

        System.out.print(gestor.ObtieneInformacionZonas());

        System.out.print("Porcentaje zonas en riesgo: " + String.format("%.2f",gestor.ObtienePorcentajeZonasEnRiesgo()) +"%");

        System.out.print("\nEl porcentaje de zonas en riesgo por tipo de zona es:\n");
        System.out.print(gestor.ObtienePorcentajeZonasEnRiesgoPorTipoZona());

        System.out.print("\nEl porcentaje de zonas en riesgo por tipo de riesgo es:\n");
        System.out.print(gestor.ObtienePorcentajeZonasEnRiesgoPorTipoRiesgo());
    }
}