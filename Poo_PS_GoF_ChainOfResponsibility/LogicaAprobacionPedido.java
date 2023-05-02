public class LogicaAprobacionPedido
{

    private Ejecutivo[] jerarquiaEjecutivos;
    private Pedido unPedido;

    public LogicaAprobacionPedido()
    {
        jerarquiaEjecutivos = new Ejecutivo[4];
        unPedido = new Pedido();
    }

    public Ejecutivo[] GetLosEjecutivos(){
        return jerarquiaEjecutivos;
    }

    public Pedido GetPedido(){
        return unPedido;
    }

    public void SetPedido(Pedido unPedido){
        this.unPedido = unPedido;
    }

    public void InicializaJerarquiaEjecutivos()
    {
        jerarquiaEjecutivos[0] = new Coordinador();
        jerarquiaEjecutivos[1] = new Director();
        jerarquiaEjecutivos[2] = new Gerente();
        jerarquiaEjecutivos[3] = new Presidente();

        //Asignación de atributos para el coordinador
        jerarquiaEjecutivos[0].SetNombre("Bob");
        jerarquiaEjecutivos[0].SetMonto(50000);
        jerarquiaEjecutivos[0].SetJefe(jerarquiaEjecutivos[1]);

        //Asignación de atributos para el director
        jerarquiaEjecutivos[1].SetNombre("Dora");
        jerarquiaEjecutivos[1].SetMonto(500000);
        jerarquiaEjecutivos[1].SetJefe(jerarquiaEjecutivos[2]);

        //Asignación de atributos para el Gerente
        jerarquiaEjecutivos[2].SetNombre("Clemente");
        jerarquiaEjecutivos[2].SetMonto(750000);
        jerarquiaEjecutivos[2].SetJefe(jerarquiaEjecutivos[3]);

        //Asignación de atributos para el Presidente
        jerarquiaEjecutivos[3].SetNombre("Vicente");
        jerarquiaEjecutivos[3].SetMonto(5000000);
        jerarquiaEjecutivos[3].SetJefe(null);
    }

    public void InicializaJerarquiaEjecutivos(Ejecutivo[] losEjecutivos)
    {
        jerarquiaEjecutivos = losEjecutivos;
    }

    public String EvaluaJerarquia()
    {
        String mensajeError = "";

        //Validar que solamente el último ejecutivo de la jerarquía sea el único sin jefe
        int contadorEjecutivosSinJefe = 0;
        for (int i = jerarquiaEjecutivos.length - 1; i >= 0; i--)
        {
            if (jerarquiaEjecutivos[i].GetJefe() == null)
                contadorEjecutivosSinJefe++;
        }

        //Si hay más de un ejecutivo sin jefe, hay error en la jerarquía
        if (contadorEjecutivosSinJefe > 1)
        {
            mensajeError = "Hay "+ contadorEjecutivosSinJefe + " ejecutivos sin jefe";
            return mensajeError;
        }

        if (jerarquiaEjecutivos[(jerarquiaEjecutivos.length - 1)].GetJefe() != null)
        {
            mensajeError = "El último ejecutivo en la jerarquía no es el único sin jefe";
            return mensajeError;
        }

        //Validar con un ciclo que los montos de los ejecutivos sean mayores que cero
        for (int i = 0; i < jerarquiaEjecutivos.length; i++)
        {
            if (jerarquiaEjecutivos[i].GetMonto() <= 0)
            {
                mensajeError = "El monto asingado para el ejecutivo " +
                        jerarquiaEjecutivos[i].GetCargo() + " " +
                        jerarquiaEjecutivos[i].GetNombre() +" no es mayor que cero";
                return mensajeError;
            }
        }

        //Validar con un ciclo que los montos de los ejecutivos tengan jerarquía
        for (int i = 0; i < jerarquiaEjecutivos.length - 1; i++)
        {
            if (jerarquiaEjecutivos[i].GetMonto() >= jerarquiaEjecutivos[i + 1].GetMonto())
            {
                mensajeError = "El monto $" + jerarquiaEjecutivos[i].GetMonto() +
                        " del ejecutivo " + jerarquiaEjecutivos[i].GetCargo() +
                        " no es inferior al de "+ jerarquiaEjecutivos[i + 1].GetCargo() +
                        " que tiene un monto de " + jerarquiaEjecutivos[i + 1].GetMonto();
                return mensajeError;
            }
        }

        //Si las validaciones funcionaron correctamente, se da el parte de confianza
        mensajeError = "correcto";
        return mensajeError;
    }

    public String ProcesarPedido()
    {
        jerarquiaEjecutivos[0].ProcesaPedido(unPedido);
        return unPedido.GetAprobador();
    }
}
