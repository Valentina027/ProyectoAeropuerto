package Proyecto;

public class AeropuertoPrivado  extends Aeropuerto{
    private String ListaEmpresas[] = new String[10];
    private int numEmpresa;

    public AeropuertoPrivado(String nombre, String ciudad, String pais) {
        super(nombre, ciudad, pais);
    }

    public AeropuertoPrivado(String nombre, String ciudad, String pais, Compañia[] c, String e) {
        super(nombre, ciudad, pais, c);
        this.ListaEmpresas = e;
        numEmpresa = e.length();
    }

    public void insertarEmpresas ( String e[]){
        this.ListaEmpresas = e;
        this.numEmpresa = e.length;
    }

    public void insertarEmpresa (String e){
        ListaEmpresas [numEmpresa] = e;
        numEmpresa++;
    }

    public String[] getListaEmpresas() {
        return ListaEmpresas;
    }

    public int getNumEmpresa() {
        return numEmpresa;
    }
}
