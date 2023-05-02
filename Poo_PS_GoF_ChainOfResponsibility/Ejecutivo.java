public abstract class Ejecutivo {
    //atributos de la clase
    protected String nombre,cargo;
    protected int monto;
    protected Ejecutivo jefe;

    //Constructor de la clase
    public Ejecutivo() {
        nombre = "";
        cargo = "";
        monto = 0;
        jefe = null;
    }

    public String GetNombre() {
        return nombre;
    }

    public void SetNombre(String nombre){
        this.nombre = nombre;
    }

    public String GetCargo() {
        return cargo;
    }

    public void SetCargo(String cargo){
        this.cargo = cargo;
    }

    public int GetMonto(){
        return monto;
    }

    public void SetMonto(int monto){
        this.monto = monto;
    }

    public Ejecutivo GetJefe(){
        return jefe;
    }

    public void SetJefe(Ejecutivo jefe){
        this.jefe = jefe;
    }

    public abstract void ProcesaPedido(Pedido laCompra);

    @Override
    public String toString() {

        String informacion = nombre + " es " + cargo +
                " y puede aprobar hasta " + monto + "\n";
        if (jefe != null)
            informacion += "\tel jefe es "+ jefe.GetNombre();
            else
        informacion += "\tNo tiene jefe asignado";

        return informacion;
    }
}
