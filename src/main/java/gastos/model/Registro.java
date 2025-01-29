package gastos.model;

public class Registro {
    private int id;
    private String nombre;
    private int monto;
    private int estado;
    public Registro(int id, String nombre, int monto, int estado)
    {
        super();
        this.id=id;
        this.nombre=nombre;
        this.monto=monto;
        this.estado=estado;
    }

    public int getId(){return id;}
    public void setId(int id){this.id=id;}
    public String getNombre(){return nombre;}
    public void setNombre(String nombre){this.nombre=nombre;}
    public int getMonto(){return monto;}
    public void setMonto(int monto){this.monto=monto;}
    public int getEstado(){return estado;}
    public void setEstado(int estado){this.estado=estado;}



}
