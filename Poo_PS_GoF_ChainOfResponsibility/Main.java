public class Main {
    public static void main(String[] args) {
        System.out.println("Patrón GoF - Cadena de Responsabilidad");
        System.out.println("Aprobación de Pedidos");

        LogicaAprobacionPedido laLogica = new LogicaAprobacionPedido();

        //1 - Definir nombres y montos de la jerarquía de ejecutivos
        System.out.println("\n *** Definición de la jerarquía de ejecutivos");
        laLogica.InicializaJerarquiaEjecutivos();

        System.out.println("\nLa jerarquía de cargos de la empresa es asi:");

        for(Ejecutivo unEjecutivo : laLogica.GetLosEjecutivos())
            System.out.println("- " + unEjecutivo.toString());

        System.out.println("Validamos la integridad de la jerarquía de ejecutivos...");

        String mensajeEvaluacion = laLogica.EvaluaJerarquia();

        if (!mensajeEvaluacion.equals("correcto"))
        {
            System.out.println("Jerarquía errónea. {mensajeEvaluacion}");
            System.out.println("No se puede aprobar pedidos hasta que no se solucione la jerarquía de ejecutivos");
        }
        else
        {
            System.out.println("Jerarquía válida. Todo está correcto!");
            //Aqui comenzamos a realizar pedidos y verificar quien los aprueba
            Pedido pedidoUno = new Pedido();
            pedidoUno.SetDescripcion("Palito de Queso Gluten Free con hilos de oro");
            pedidoUno.SetValor(4500000);

            laLogica.SetPedido(pedidoUno);
            String resultadoAprobacion = laLogica.ProcesarPedido();

            System.out.println("\nSe intentó comprar: " + pedidoUno.GetDescripcion() +
                    " con un valor de "+ pedidoUno.GetValor() + "." +
                    "\nEl resultado de la compra fue: " + resultadoAprobacion);
        }
    }
}