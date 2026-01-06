package Ordenamiento;

/**
 * Implementación del algoritmo de ordenamiento por Inserción (Insertion Sort).
 *
 * Funcionamiento: Construye el arreglo ordenado de a un elemento a la vez,
 * insertando cada elemento en su posición correcta dentro de la parte ya ordenada.
 *
 * Características:
 * - Complejidad: O(n²) en el peor caso, O(n) en el mejor caso
 * - Ventaja: Muy eficiente para arreglos pequeños o casi ordenados
 * - Ventaja: Más rápido que Burbuja en la práctica
 * - Analogía: Como ordenar cartas en tu mano, una por una
 */
public class Insercion {
    public static void ordenar(int[] arreglo) {
        int n = arreglo.length;
        // Comenzamos desde i=1 porque consideramos que el primer elemento (i=0)
        // ya está "ordenado" por sí solo
        for (int i = 1; i < n; i++) {
            // Guardamos el elemento actual que vamos a insertar
            int actual = arreglo[i];
            // j comienza en la posición anterior al elemento actual
            // Vamos a comparar con los elementos de la parte ya ordenada
            int j = i - 1;

            // Mientras no lleguemos al inicio (j >= 0) Y
            // el elemento en j sea mayor que el actual
            while (j >= 0 && arreglo[j] > actual) {
                // Movemos el elemento una posición a la derecha
                // para hacer espacio para insertar el actual
                arreglo[j + 1] = arreglo[j];
                j--;// Nos movemos hacia la izquierda
            }
            // Insertamos el elemento actual en su posición correcta
            // j+1 porque j se decrementó una vez de más en el while,
            // o porque encontramos la posición correcta
            arreglo[j + 1] = actual;
        }
    }
}
