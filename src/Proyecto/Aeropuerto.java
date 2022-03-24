package Proyecto;

public class Aeropuerto {
    private String nombre;
    private String ciudad;
    private String pais;
    private Compañia ListaCompañias[] = new Compañia[10];
    private int numCompañia;

    public Aeropuerto(String nombre, String ciudad, String pais) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        this.numCompañia =0;
    }

    public Aeropuerto(String nombre, String ciudad, String pais, Compañia c[]) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        ListaCompañias = c;
        this.numCompañia = c.length;
    }

    public void insertarCompañia ( Compañia compañia){
        ListaCompañias [numCompañia] = compañia;
        numCompañia++;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getPais() {
        return pais;
    }

    public Compañia[] getListaCompañias() {
        return ListaCompañias;
    }

    public int getNumCompañia() {
        return numCompañia;
    }

    public Compañia getCompañia (int i){
        return ListaCompañias [i];
    }

    public Compañia getCompañia(String nombre){
        boolean encontrado = false;
        int i =0;
        Compañia c= null;
        while ((!encontrado)&&(i<ListaCompañias.length)){
            if (nombre.equals(ListaCompañias [i].getNombre())){
                encontrado = true;
                c = ListaCompañias[i];
            }
            i++;
        }
        return c;
    }
}
