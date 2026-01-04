import java.util.Scanner;

import Busqueda.*;
import Ordenamiento.*;
import Util.*;

public class Main {

    private static final int PEQUENO = 100;
    private static final int MEDIANO = 1000;
    private static final int GRANDE = 10000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> probarOrdenamientos();
                case 2 -> probarBusquedas();
                case 3 -> System.out.println("Fin del programa");
                default -> System.out.println("Opcion invalida");
            }
        } while (opcion != 3);
    }

    private static void mostrarMenu() {
        System.out.println("\nTodos los resultados obtenidos estan expresados en nano-segundos (ns)");
        System.out.println("\n1. Ordenamientos");
        System.out.println("2. Busquedas");
        System.out.println("3. Salir");
        System.out.print("Opcion: ");
    }

    private static void probarOrdenamientos() {
        int[] datos = GeneradorDatos.generarAleatorio(MEDIANO);

        System.out.println("Burbuja: " + medir(() -> Burbuja.ordenar(UtilArreglos.copiar(datos))) + " ns"); //resultado de tiempo en nanosegundos
        System.out.println("Insercion: " + medir(() -> Insercion.ordenar(UtilArreglos.copiar(datos))) + " ns");
        System.out.println("Seleccion: " + medir(() -> Seleccion.ordenar(UtilArreglos.copiar(datos))) + " ns");
    }

    private static void probarBusquedas() {
        int[] datos = GeneradorDatos.generarAleatorio(MEDIANO);
        int valor = datos[datos.length / 2];

        System.out.println("Secuencial: " + medir(() -> BusquedaSecuencial.buscar(datos, valor)) + " ns");

        int[] copia = UtilArreglos.copiar(datos);
        Insercion.ordenar(copia);
        System.out.println("Binaria: " + medir(() -> BusquedaBinaria.buscar(copia, valor)) + " ns");
    }

    private static long medir(Runnable accion) {
        long ini = System.nanoTime();
        accion.run();
        return System.nanoTime() - ini;
    }
}
