package LogicaInundacion;

import java.util.ArrayList;

public class Zona {
    private boolean estaEnRiesgo;
    private int nivelMar, distanciaRio, totalHabitantes;
    private double areaPoblacion, densidadPoblacional;
    private String ubicacion, tipoZona;
    private ArrayList<String> losRiesgos;

    public Zona() {
        losRiesgos = new ArrayList<String>();
        nivelMar = 0;
        distanciaRio = 0;
        totalHabitantes = 0;
        areaPoblacion = 0;
        densidadPoblacional = 0;
        ubicacion = "";
        tipoZona = "";

        estaEnRiesgo = false;
    }

    public Zona(int nivelMar,
                int distanciaRio,
                int totalHabitantes,
                double areaPoblacion,
                String ubicacion,
                String tipoZona) {
        this.nivelMar = nivelMar;
        this.distanciaRio = distanciaRio;
        this.totalHabitantes = totalHabitantes;
        this.areaPoblacion = areaPoblacion;
        this.ubicacion = ubicacion;
        this.tipoZona = tipoZona;

        if (areaPoblacion == 0)
            densidadPoblacional = 0;
        else
            densidadPoblacional = (double) totalHabitantes / areaPoblacion;

        losRiesgos = new ArrayList<String>();
        estaEnRiesgo = false;
    }

    public boolean GetEstaEnRiesgo() {
        return estaEnRiesgo;
    }

    public void SetEstaEnRiesgo(boolean valor) {
        estaEnRiesgo = valor;
    }

    public String GetTipoZona() {
        return tipoZona;
    }

    public void SetTipoZona(String valor) {
        tipoZona = valor;
    }

    public String GetUbicacion() {
        return ubicacion;
    }

    public void SetUbicacion(String valor) {
        ubicacion = valor;
    }

    public int GetNivelMar() {
        return nivelMar;
    }

    public void SetNivelMar(int valor) {
        nivelMar = valor;
    }

    public int GetDistanciaRio() {
        return distanciaRio;
    }

    public void SetDistanciaRio(int valor) {
        distanciaRio = valor;
    }

    public double GetDensidadPoblacional() {
        return densidadPoblacional;
    }

    public ArrayList<String> GetLosRiesgos() {
        return losRiesgos;
    }

    @Override
    public String toString() {
            String informacion = "Esta es una zona " + ubicacion + " del tipo " + tipoZona + ",\n " +
                    "con un nivel del mar de " + nivelMar + " mts, y a una distancia del rio de " + distanciaRio + ",\n " +
                    "tiene " + totalHabitantes + " habitantes y un área de " + String.format("%.2f", areaPoblacion) + ",\n " +
                    "con una densidad de " + String.format("%.2f", densidadPoblacional) + ".\n";

            if (!estaEnRiesgo)
                informacion += " No está en riesgo";
            else {
                informacion += " Está en riesgo de:";

                for (String riesgo : losRiesgos)
                    informacion += "\n\t" + riesgo;
            }

            return informacion;
    }
}