package Proyecto;

import java.util.Scanner;

public class Principal {
    static Scanner entrada = new java.util.Scanner (System.in);
    final static int num= 4;
    static Aeropuerto aeropuertos [] = new Aeropuerto[num];

    public static void main(String[] args) {
        insertarDatosAeropuerto(aeropuertos);

    }

    public static void insertarDatosAeropuerto(Aeropuerto aero[]){
        aero [0] = new AeropuertoPublico("El Dorado", "Bogota", "Colombia",80000000);
        aero [0].insertarCompañia(new Compañia("AeroDorado"));
        aero [0].insertarCompañia(new Compañia("AVIANCA"));
        aero [0].getCompañia("AeroDorado").insertarVuelo(new Vuelo("IB20","Bogotá","Mexico",150.90,150));
        aero [0].getCompañia("AeroDorado").insertarVuelo(new Vuelo("IB21","Bogotá","Buenos Aires",180.99,120));
        aero [0].getCompañia("AVIANCA").insertarVuelo(new Vuelo("FC12","Bogota","Londres",500.90,180));
        aero [0].getCompañia("AeroDorado").getVuelo("IB20").insertarPasajero(new Pasajero("Valentina","20BGH","Colombiano"));
        aero [0].getCompañia("AeroDorado").getVuelo("IB20").insertarPasajero(new Pasajero("Santiago","20PKM","Colombiano"));
        aero [0].getCompañia("AVIANCA").getVuelo("FC12").insertarPasajero(new Pasajero("Jose","20JHK","Mexicano"));

    }

    public static void menu(){
        int opcion;

        do{
            System.out.println("\t.:MENU:.");
            System.out.println("1. Ver Aeropuertos gestionados (Publicos o Privados)");
            System.out.println("2. Ver empresas (Privado) o subvencion (Publico)");
            System.out.println("3. Listas compañias de un Aeropuerto");
            System.out.println("4. Lista de vuelos por compañia");
            System.out.println("5. Listar posibles vuelos de origen a destino");
            System.out.println("6. Salir");
            System.out.println("Opcion: ");
            opcion = entrada.nextInt();

            switch (opcion){
                case 1: // Ver Aeropuertos gestionados (Publicos o Privados
                    break;
                case 2: // Ver empresas (Privado) o subvencion (Publico)
                    break;
                case 3: //Listas compañias de un Aeropuerto
                    break;
                case 4: // Lista de vuelos por compañia
                    break;
                case 5: // Listar posibles vuelos de origen a destino
                    break;
                case 6: break;
                default: System.out.println(" Error, se equivoco de opcion de menu");
            }
            System.out.println("");

        }while (opcion!= 6);
    }

}
