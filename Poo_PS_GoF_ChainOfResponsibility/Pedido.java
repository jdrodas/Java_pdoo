public class Pedido
{
    //atributos de la clase
    private String aprobador, descripcion;
    private int valor;
    //constructor de la clase
    public Pedido()
    {
        aprobador = "";
        descripcion = "";
        valor = 0;
    }

    public String GetAprobador(){
        return aprobador;
    }

    public void SetAprobador(String aprobador){
        this.aprobador = aprobador;
    }

    public String GetDescripcion(){
        return descripcion;
    }

    public void SetDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public int GetValor(){
        return valor;
    }

    public void SetValor(int valor){
        this.valor = valor;
    }
}
