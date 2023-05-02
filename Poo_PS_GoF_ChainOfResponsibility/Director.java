public class Director extends Ejecutivo{

    public Director()
    {
        nombre = "";
        cargo = "Director";
        monto = 0;
        jefe = null;
    }

    @Override
    public void ProcesaPedido(Pedido laCompra)
    {
        //Si el valor del pedido es menor que el monto del coordinador
        //se puede aprobar el pedido
        if (laCompra.GetValor() <= monto)
            laCompra.SetAprobador("Aprobado por " +  cargo + " " + nombre);
        else
            //Si hay jefe asignado, le pasamos el pedido para que lo apruebe
            if (jefe != null)
                jefe.ProcesaPedido(laCompra);
            else
                laCompra.SetAprobador("El coordinador no tiene jefe. No se puede aprobar!");
    }
}
