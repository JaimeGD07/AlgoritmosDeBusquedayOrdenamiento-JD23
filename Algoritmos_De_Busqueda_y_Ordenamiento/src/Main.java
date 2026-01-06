import java.util.Scanner;

import Busqueda.*;
import Ordenamiento.*;
import Util.*;

/**
 * Clase principal que ejecuta pruebas de rendimiento para algoritmos
 * de ordenamiento y búsqueda.
 */
public class Main {

    //tamaño que define un arreglo aleatorio de enteros de muestra para la prueba de los algoritmos
    private static final int PEQUENO = 100;
    private static final int MEDIANO = 1000;
    private static final int GRANDE = 10000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);//scanner unicamente para la seleccion del menu
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
        } while (opcion != 3);//realiza el codigo del do while siempre que no sea 3
    }

    //metodo que despliega el menu en consola y usado en main
    private static void mostrarMenu() {
        System.out.println("\nTodos los resultados obtenidos estan expresados en nano-segundos (ns)");
        System.out.println("\n1. Ordenamientos");
        System.out.println("2. Busquedas");
        System.out.println("3. Salir");
        System.out.print("Opcion: ");
    }

    //codigo que realiza la prueba de los algoritmos de ordenamiento
    /**
     * Prueba y compara el rendimiento de diferentes algoritmos de ordenamiento.
     * Cada algoritmo trabaja sobre una copia del mismo arreglo desordenado
     * para garantizar condiciones justas de comparación.
     */
    private static void probarOrdenamientos() {
        // Generamos un arreglo aleatorio de tamaño pequeño, mediano o grande
        int[] datos = GeneradorDatos.generarAleatorio(MEDIANO);

        // Medimos cada algoritmo usando una COPIA del arreglo original
        // para que todos ordenen exactamente los mismos datos desordenados
        System.out.println("Burbuja: " + medir(() -> Burbuja.ordenar(UtilArreglos.copiar(datos))) + " ns"); //resultado de tiempo en nanosegundos
        System.out.println("Insercion: " + medir(() -> Insercion.ordenar(UtilArreglos.copiar(datos))) + " ns");
        System.out.println("Seleccion: " + medir(() -> Seleccion.ordenar(UtilArreglos.copiar(datos))) + " ns");
    }

    //codigo que realiza la prueba de los algoritmos de busqueda
    /**
     * Prueba y compara el rendimiento de diferentes algoritmos de búsqueda.
     *
     * Búsqueda secuencial: Busca en el arreglo desordenado.
     * Búsqueda binaria: Necesita ordenar primero, así que medimos solo la búsqueda,
     *                   no el tiempo de ordenamiento.
     */
    private static void probarBusquedas() {
        // Generamos un arreglo aleatorio del tamaño pequeño, mediano o grande
        int[] datos = GeneradorDatos.generarAleatorio(MEDIANO);
        // Buscamos un elemento en una posición aleatoria
        int posicionAleatoria = (int)(Math.random() * datos.length);
        int valor = datos[posicionAleatoria];

        System.out.println("Posicion aleatoria seleccionada: " + posicionAleatoria);
        System.out.println("Elemento objetivo a buscar: " + valor);
        // Búsqueda secuencial en el arreglo desordenado original
        System.out.println("Secuencial: " + medir(() -> BusquedaSecuencial.buscar(datos, valor)) + " ns");

        // Para búsqueda binaria: necesitamos ordenar primero
        int[] copia = UtilArreglos.copiar(datos);// Copiamos para no modificar el original
        Insercion.ordenar(copia);// Ordenamos la copia
        // Ahora medimos solo el tiempo de búsqueda (no incluye el tiempo de ordenar)
        System.out.println("Binaria: " + medir(() -> BusquedaBinaria.buscar(copia, valor)) + " ns");
    }

    //metodo que calcula los tiempos de ejecucion de los algoritmos
    /**
     * * Funcionamiento:
     *      * 1. Toma el tiempo inicial (System.nanoTime())
     *      * 2. Ejecuta la acción (accion.run())
     *      * 3. Toma el tiempo final y calcula la diferencia
     */
    private static long medir(Runnable accion) {
        long ini = System.nanoTime();
        accion.run();
        return System.nanoTime() - ini;
    }
}
