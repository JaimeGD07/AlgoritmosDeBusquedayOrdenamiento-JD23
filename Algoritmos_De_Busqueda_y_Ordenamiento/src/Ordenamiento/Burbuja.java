package Ordenamiento;

/**
 * Implementación del algoritmo de ordenamiento Burbuja (Bubble Sort).
 *
 * Funcionamiento: Compara elementos adyacentes y los intercambia si están
 * en el orden incorrecto. Repite este proceso hasta que el arreglo esté ordenado.
 *
 * Características:
 * - Complejidad: O(n²) - Lento para arreglos grandes
 * - Ventaja: Simple de entender e implementar
 * - Desventaja: Uno de los algoritmos más lentos
 * - Nombre: Se llama "burbuja" porque los valores más grandes "flotan" hacia el final
 */
public class Burbuja {
    public static void ordenar(int[] arreglo) {
        int n = arreglo.length;

        // Bucle externo: controla el número de pasadas completas
        // Necesitamos n-1 pasadas porque en cada pasada al menos un elemento
        // queda en su posición final
        for (int i = 0; i < n - 1; i++) {
            // Bucle interno: compara elementos adyacentes
            // Usamos "n - i - 1" porque los últimos i elementos ya están ordenados
            // después de cada pasada
            for (int j = 0; j < n - i - 1; j++) {
                // Si el elemento actual es mayor que el siguiente, los intercambiamos
                if (arreglo[j] > arreglo[j + 1]) {
                    // Intercambio usando variable temporal
                    int temp = arreglo[j];// Guardamos el valor actual
                    arreglo[j] = arreglo[j + 1];// Movemos el siguiente al actual
                    arreglo[j + 1] = temp;// Ponemos el guardado en el siguiente
                }
            }
        }
    }
}
