package Proyecto;

import java.util.Scanner;

public class Principal {
    static Scanner entrada = new java.util.Scanner(System.in);
    final static int num = 4;
    static Aeropuerto[] aeropuertos = new Aeropuerto[num];

    public static void main(String[] args) {
        menu();
        insertarDatosAeropuerto(aeropuertos);

    }

    public static void insertarDatosAeropuerto(Aeropuerto[] aero) {
        aero[0] = new AeropuertoPublico("El Dorado", "Bogota", "Colombia", 80000000);
        aero[0].insertarCompañia(new Compañia("AeroDorado"));
        aero[0].insertarCompañia(new Compañia("AVIANCA"));
        aero[0].getCompañia("AeroDorado").insertarVuelo(new Vuelo("IB20", "Bogotá", "Mexico", 150.90, 150));
        aero[0].getCompañia("AeroDorado").insertarVuelo(new Vuelo("IB21", "Bogotá", "Buenos Aires", 180.99, 120));
        aero[0].getCompañia("AVIANCA").insertarVuelo(new Vuelo("FC12", "Bogota", "Londres", 500.90, 180));
        aero[0].getCompañia("AeroDorado").getVuelo("IB20").insertarPasajero(new Pasajero("Valentina", "20BGH", "Colombiano"));
        aero[0].getCompañia("AeroDorado").getVuelo("IB20").insertarPasajero(new Pasajero("Santiago", "20PKM", "Colombiano"));
        aero[0].getCompañia("AVIANCA").getVuelo("FC12").insertarPasajero(new Pasajero("Jose", "20JHK", "Mexicano"));

    }

    public static void menu() {
        String nombreAeropuerto, nombreCompañia, origen, destino;
        int opcion;
        Aeropuerto aeropuerto;
        Compañia compañia;

        do {
            System.out.println("\t.:MENU:.");
            System.out.println("1. Ver Aeropuertos gestionados (Publicos o Privados)");
            System.out.println("2. Ver empresas (Privado) o subvencion (Publico)");
            System.out.println("3. Listas compañias de un Aeropuerto");
            System.out.println("4. Lista de vuelos por compañia");
            System.out.println("5. Listar posibles vuelos de origen a destino");
            System.out.println("6. Salir");
            System.out.println("Opcion: ");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1: // Ver Aeropuertos gestionados (Publicos o Privados
                    mostrarDatosAeropuertos(aeropuertos);
                    break;
                case 2: // Ver empresas (Privado) o subvencion (Publico)
                    mostrarPatrocinio(aeropuertos);
                    break;
                case 3: //Listas compañias de un Aeropuerto
                    entrada.nextLine();
                    System.out.println("\nDigite el nombre del Aeropuerto: ");
                    nombreAeropuerto = entrada.nextLine();
                    aeropuerto = buscarAeropuerto(nombreAeropuerto, aeropuertos);
                    if (aeropuerto == null) {
                        System.out.println(" El aeropuerto no existe ");
                    } else {
                        mostrarCompañias(aeropuerto);

                    }
                    break;
                case 4: // Lista de vuelos por Compañia
                    System.out.println("\nDigite el nombre del Aeropuerto: ");
                    nombreAeropuerto = entrada.nextLine();
                    aeropuerto = buscarAeropuerto(nombreAeropuerto, aeropuertos);
                    if (aeropuerto == null) {
                        System.out.println(" El aeropuerto no existe");
                    } else {
                        System.out.println(" Digite el nombre de la comapañia: ");
                        nombreCompañia = entrada.nextLine();
                        compañia = aeropuerto.getCompañia(nombreCompañia);
                        mostrarVuelos(compañia);
                    }
                    break;
                case 5: // Listar posibles vuelos de origen a destino
                    entrada.nextLine();
                    System.out.println("\nDigite la ciudad de origen: ");
                    origen = entrada.nextLine();
                    System.out.println("\nDigite la ciudad de destino: ");
                    destino = entrada.nextLine();
                    mostarVueloOrigenDestino(origen,destino,aeropuertos);
                    break;
                case 6:
                    break;
                default:
                    System.out.println(" Error, se equivoco de opcion de menu");
            }

        } while (opcion != 6);
    }

    public static void mostrarDatosAeropuertos(Aeropuerto[] aeropuertos) {
        for (Aeropuerto aeropuerto : aeropuertos) {
            if (aeropuerto instanceof AeropuertoPrivado) {
                System.out.println(" Aeropuerto privado");
                System.out.println(" Nombre: " + aeropuerto.getNombre());
                System.out.println("Ciudad: " + aeropuerto.getCiudad());
                System.out.println("Ciudad: " + aeropuerto.getPais());
            } else {
                System.out.println(" Aeropuerto publico");
                System.out.println(" Nombre: " + aeropuerto.getNombre());
                System.out.println("Ciudad: " + aeropuerto.getCiudad());
                System.out.println("Ciudad: " + aeropuerto.getPais());
            }
        }
    }

    public static void mostrarPatrocinio(Aeropuerto[] aeropuertos) {
        String[] empresas;

        for (Aeropuerto aeropuerto : aeropuertos) {
            if (aeropuerto instanceof AeropuertoPrivado) {
                System.out.println("Aeropuerto Privado:" + aeropuerto.getNombre());
                empresas = ((AeropuertoPrivado) aeropuerto).getListaEmpresas();
                System.out.println("Las empresas son:");
                for (String empresa : empresas) {
                    System.out.println(empresa);

                }
            } else {
                System.out.println("Aeropuerto publico: " + aeropuerto.getNombre());
                System.out.println("Subvencion: " + ((AeropuertoPublico) aeropuerto).getSubvencion());

            }
        }
    }

    public static Aeropuerto buscarAeropuerto(String nombre, Aeropuerto[] aeropuertos) {
        boolean encontrado = false;
        int i = 0;
        Aeropuerto aero = null;
        while ((!encontrado) && (aeropuertos.length > i)) {
            if (nombre.equals(aeropuertos[i].getNombre())) {
                encontrado = true;
                aero = aeropuertos[i];
            }
            i++;
        }
        return aero;
    }

    public static void mostrarCompañias(Aeropuerto aeropuerto) {
        System.out.println("\nDigite las compañias del aeropuerto: " + aeropuerto.getNombre());
        for (int i = 0; i < aeropuerto.getNumCompañia(); i++) {
            System.out.println(aeropuerto.getCompañia(i).getNombre());
        }
    }

    public static void mostrarVuelos(Compañia compañia) {
        Vuelo vuelo;
        System.out.println(" Los vuelos de la compañia: " + compañia.getNombre());
        for (int i = 0; i < compañia.getNumVuelo(); i++) {
            vuelo = compañia.getVuelo(i);
            System.out.println("Identificador: " + vuelo.getIdentificador());
            System.out.println(" Ciudad Origen: " + vuelo.getCiudadOrigen());
            System.out.println("Ciudad Destino " + vuelo.getCiudadDestino());
            System.out.println("Precio: " + vuelo.getPrecio());

        }
    }

    public static Vuelo[] buscarVuelosOrigenDestino(String origen, String destino, Aeropuerto[] aeropuertos) {
        Vuelo vuelo;
        int contador = 0;
        Vuelo[] listaVuelos;

        for (int i = 0; i < aeropuertos.length; i++) {
            for (int j = 0; j < aeropuertos[i].getNumCompañia(); j++) {
                for (int k = 0; k < aeropuertos[i].getCompañia(j).getNumVuelo(); k++) {
                    vuelo = aeropuertos[i].getCompañia(j).getVuelo(k);
                    if ((origen.equals(vuelo.getCiudadOrigen())) && (destino.equals(vuelo.getCiudadDestino()))) {
                        contador++;
                    }
                }
            }
        }
        listaVuelos = new Vuelo[contador];
        int q = 0;

        for (int i = 0; i < aeropuertos.length; i++) {
            for (int j = 0; j < aeropuertos[i].getNumCompañia(); j++) {
                for (int k = 0; k < aeropuertos[i].getCompañia(j).getNumVuelo(); k++) {
                    vuelo = aeropuertos[i].getCompañia(j).getVuelo(k);
                    if ((origen.equals(vuelo.getCiudadOrigen())) && (destino.equals(vuelo.getCiudadDestino()))) {
                        listaVuelos[q] = vuelo;
                        q++;
                    }
                }
            }
        }

        return listaVuelos;
    }

    public static void mostarVueloOrigenDestino (String origen, String destino, Aeropuerto[] aeropuerto){
        Vuelo vuelos [];
        vuelos = buscarVuelosOrigenDestino(origen, destino, aeropuertos);
        if (vuelos.length==0){
            System.out.println("No existen vuelos de esa ciudad de origen a destino");
        }
        else {
            System.out.println(" Vuelos encontrados: ");
            for (int i=0;i<vuelos.length;i++){
                System.out.println("Identificador: "+vuelos[i].getIdentificador());
                System.out.println("Ciudad origen: "+vuelos[i].getCiudadOrigen());
                System.out.println("Ciudad destino: "+vuelos[i].getCiudadDestino());
                System.out.println(" precio: "+vuelos[i].getPrecio());
            }
        }
    }
}