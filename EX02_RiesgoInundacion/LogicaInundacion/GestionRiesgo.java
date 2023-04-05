package LogicaInundacion;

import java.util.Random;

public class GestionRiesgo {
    private int cantidadZonas;
    private Zona[] lasZonas;
    private String[] lasUbicaciones;
    private String[] losTiposDeZona;
    private String[] losTiposDeRiesgos;

    public GestionRiesgo(int cantidadZonas) {
        this.cantidadZonas = cantidadZonas;
        lasUbicaciones = InicializaUbicaciones();
        losTiposDeZona = InicializaTiposZona();
        losTiposDeRiesgos = InicializaTiposRiesgos();

        lasZonas = InicializaZonas();

        //Se evalua el riesgo de las zonas
        EvaluaRiesgoZonas(lasZonas);
    }

    public GestionRiesgo() {
        this.cantidadZonas = 1;
        lasZonas = new Zona[cantidadZonas];
        lasUbicaciones = InicializaUbicaciones();
        losTiposDeZona = InicializaTiposZona();
        losTiposDeRiesgos = InicializaTiposRiesgos();

        //Se evalua el riesgo de las zonas
        EvaluaRiesgoZonas(lasZonas);
    }

    public Zona[] InicializaZonas() {
        Zona[] arregloZonas = new Zona[cantidadZonas];

        int nivelMar, distanciaRio, totalHabitantes;
        double areapoblacion;
        String unaUbicacion, unTipoZona;

        Random rnd = new Random();

        for (int i = 0; i < arregloZonas.length; i++) {
            nivelMar = rnd.nextInt(0, 3001);
            distanciaRio = rnd.nextInt(0, 2001);
            totalHabitantes = rnd.nextInt(1000, 1000001);
            areapoblacion = rnd.nextDouble() * 50;
            unaUbicacion = lasUbicaciones[rnd.nextInt(lasUbicaciones.length)];
            unTipoZona = losTiposDeZona[rnd.nextInt(losTiposDeZona.length)];

            arregloZonas[i] = new Zona(
                    nivelMar,
                    distanciaRio,
                    totalHabitantes,
                    areapoblacion,
                    unaUbicacion,
                    unTipoZona);
        }

        return arregloZonas;
    }

    public void InicializaZonas(Zona[] lasZonas) {
        //Se evalua el riesgo de las zonas
        EvaluaRiesgoZonas(lasZonas);

        //finalmente, se asigna al atributo
        this.lasZonas = lasZonas;
        this.cantidadZonas = lasZonas.length;
    }

    private String[] InicializaUbicaciones() {
        return new String[] { "Costera", "Montañosa" };
    }

    private String[] InicializaTiposZona() {
        return new String[] { "Rural", "Urbana" };
    }

    private String[] InicializaTiposRiesgos() {
        return new String[] {
                "Riesgo inundación fluvial",
                "Riesgo inundación costera",
                "Riesgo inundación urbana"
        };
    }

    private void EvaluaRiesgoZonas(Zona[] arregloZonas) {
        //Para cada zona, se evalua su riesgo de acuerdo a los requerimientos
        for (int i = 0; i < arregloZonas.length; i++) {
            //Evaluación de riesgo fluvial: losTiposDeRiesgos[0]
            if (arregloZonas[i].GetDistanciaRio() < 50 && arregloZonas[i].GetUbicacion().equals("Montañosa"))
                arregloZonas[i].GetLosRiesgos().add(losTiposDeRiesgos[0]);

            //Evaluamos Riesgo Costero: losTiposDeRiesgos[1]
            if (arregloZonas[i].GetUbicacion().equals("Costera") && arregloZonas[i].GetNivelMar() < 10)
                arregloZonas[i].GetLosRiesgos().add(losTiposDeRiesgos[1]);

            //Evaluamos Riesgo Urbano: losTiposDeRiesgos[2]
            if (arregloZonas[i].GetTipoZona().equals("Urbana") && arregloZonas[i].GetDensidadPoblacional() >= 100)
                arregloZonas[i].GetLosRiesgos().add(losTiposDeRiesgos[2]);

            // Detalle de elegancia: ¿Qué se está haciendo aqui?
            arregloZonas[i].SetEstaEnRiesgo(arregloZonas[i].GetLosRiesgos().size() > 0);
        }
    }
    public String ObtieneInformacionZonas() {
        String resultado = "Total Zonas monitoreadas: " + cantidadZonas + "\n";

        for (int i = 0; i < lasZonas.length; i++)
            resultado += "Zona No. "+(i + 1) + "\n" + lasZonas[i].toString() + "\n\n";

        return resultado;
    }

    public float ObtienePorcentajeZonasEnRiesgo() {
        float porcentaje;
        float totalZonasEnRiesgo = 0;

        for (Zona unaZona : lasZonas)
            if (unaZona.GetEstaEnRiesgo())
                totalZonasEnRiesgo++;

        porcentaje = (totalZonasEnRiesgo / cantidadZonas) * 100;

        return porcentaje;
    }

    public String ObtienePorcentajeZonasEnRiesgoPorTipoZona() {
        float[] valoresPorcentajes = new float[losTiposDeZona.length];

        for (int i = 0; i < valoresPorcentajes.length; i++)
            valoresPorcentajes[i] = 0;

        //Recorremos la colección de zonas, preguntando si está en riesgo y que en tipo de zona está
        for (int i = 0; i < lasZonas.length; i++) {
            if (lasZonas[i].GetEstaEnRiesgo()) {
                for (int j = 0; j < losTiposDeZona.length; j++) {
                    if (lasZonas[i].GetTipoZona().equals(losTiposDeZona[j])) {
                        valoresPorcentajes[j]++;
                    }
                }
            }
        }

        String informacionPorcentajes = "";

        //Luego de totalizado, calculamos el porcentaje
        for (int i = 0; i < valoresPorcentajes.length; i++) {
            informacionPorcentajes += losTiposDeZona[i] + ": " + valoresPorcentajes[i] + ", ";

            valoresPorcentajes[i] =
                    (valoresPorcentajes[i] / cantidadZonas) * 100;

            informacionPorcentajes += "que equivale a " + String.format("%.2f",valoresPorcentajes[i]) + "% \n";
        }

        return informacionPorcentajes;
    }

    public String ObtienePorcentajeZonasEnRiesgoPorTipoRiesgo()
    {
        float[] valoresPorcentajes = new float[losTiposDeRiesgos.length];

        for (int i = 0; i < valoresPorcentajes.length; i++)
            valoresPorcentajes[i] = 0;

        //Recorremos la colección de zonas, preguntando si está en riesgo y que en tipo de riesgo está
        for (int i = 0; i < lasZonas.length; i++) {
            if (lasZonas[i].GetEstaEnRiesgo()) {
                for (int j = 0; j < losTiposDeRiesgos.length; j++) {
                    if (lasZonas[i].GetLosRiesgos().contains(losTiposDeRiesgos[j])) {
                        valoresPorcentajes[j]++;
                    }
                }
            }
        }

        String informacionPorcentajes = "";

        //Luego de totalizado, calculamos el porcentaje
        for (int i = 0; i < valoresPorcentajes.length; i++) {
            informacionPorcentajes +=  losTiposDeRiesgos[i] +  ": " + valoresPorcentajes[i] + ", ";

            valoresPorcentajes[i] =
                    (valoresPorcentajes[i] / cantidadZonas) * 100;

            informacionPorcentajes += "que equivale a "+ String.format("%.2f",valoresPorcentajes[i]) +"% \n";
        }

        return informacionPorcentajes;
    }
}

