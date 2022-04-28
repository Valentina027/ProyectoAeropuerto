package Proyecto;

public class Compañia {
    private final String nombre;
    private Vuelo[] ListaVuelos = new Vuelo[10];
    private int numVuelo=0;

    public Compañia(String nombre) {
        this.nombre = nombre;
    }

    public Compañia(String nombre, Vuelo[] v) {
        this.nombre = nombre;
        ListaVuelos =v;
        numVuelo = v.length;
    }

    public void insertarVuelo (Vuelo vuelo) {
        ListaVuelos [numVuelo] = vuelo;
        numVuelo++;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumVuelo() {
        return numVuelo;
    }

    public Vuelo getVuelo (int i){
        return ListaVuelos [i];
    }

    public Vuelo getVuelo (String id) {
        boolean encontrado = false;
        int i = 0;
        Vuelo v = null;
        while ((!encontrado) && (i < ListaVuelos.length)) {
            if (id.equals(ListaVuelos[i].getIdentificador())) {
                encontrado = true;
                v = ListaVuelos[i];

            }
            i++;
        }
        return v;
    }
}
