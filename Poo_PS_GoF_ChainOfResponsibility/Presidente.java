public class Presidente extends Ejecutivo{

    public Presidente()
    {
        nombre = "";
        cargo = "Presidente";
        monto = 0;
        jefe = null;
    }

    @Override
    public void ProcesaPedido(Pedido laCompra)
    {
        //Si el valor del pedido es menor que el monto del Presidente
        //se puede aprobar el pedido
        if (laCompra.GetValor() <= monto)
            laCompra.SetAprobador("Aprobado por " +  cargo + " " + nombre);
        else
            laCompra.SetAprobador("El pedido debe aprobarse en Junta Directiva");


    }
}
