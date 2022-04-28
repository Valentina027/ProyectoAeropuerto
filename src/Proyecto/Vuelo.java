package Proyecto;

import java.util.Objects;

public class Vuelo {

    private final String identificador;
    private final String ciudadOrigen;
    private final String ciudadDestino;
    private final double precio;
    private final int numMaxPasajeros;
    private int numActualPasajeros;
    private final Pasajero[] ListaPasajeros;

    public Vuelo(String identificador, String ciudadOrigen, String ciudadDestino, double precio, int numMaxPasajeros) {
        this.identificador = identificador;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.precio = precio;
        this.numMaxPasajeros = numMaxPasajeros;
        this.numActualPasajeros = 0;
        this.ListaPasajeros = new Pasajero [numMaxPasajeros];
    }

    public void insertarPasajero (Pasajero pasajero){
        ListaPasajeros [numActualPasajeros] = pasajero;
        numActualPasajeros++;
    }

    public String getIdentificador() {
        return identificador;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public double getPrecio() {
        return precio;
    }

    public int getNumMaxPasajeros() {
        return numMaxPasajeros;
    }

    public int getNumActualPasajeros() {
        return numActualPasajeros;
    }

    public Pasajero getPasajero (int i){
        return ListaPasajeros[i];
    }

    public Pasajero getPasajero (String pasaporte){
        boolean encontrado = false;
        int i = 0;
        Pasajero pas=null;
        while ((!encontrado)&&(i<ListaPasajeros.length)) {
            if (Objects.equals(pasaporte, ListaPasajeros[i].getPasaporte())){
                encontrado = true;
                 pas = ListaPasajeros[i];
         }
         i++;

     }
     return pas;
  }
}
