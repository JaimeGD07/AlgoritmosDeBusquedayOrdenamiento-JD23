package Ordenamiento;

/**
 * Implementación del algoritmo de ordenamiento por Selección (Selection Sort).
 *
 * Funcionamiento: Busca repetidamente el elemento más pequeño de la parte
 * no ordenada y lo coloca al inicio de esa parte.
 *
 * Características:
 * - Complejidad: O(n²) SIEMPRE (mejor, promedio y peor caso)
 * - Ventaja: Hace el MÍNIMO número de intercambios (n-1)
 * - Desventaja: Siempre hace todas las comparaciones, incluso si ya está ordenado
 * - Analogía: Como seleccionar la carta más pequeña repetidamente
 */
public class Seleccion {
    public static void ordenar(int[] arreglo) {
        int n = arreglo.length;

        // Bucle externo: recorre cada posición que necesita llenarse
        // Vamos hasta n-1 porque cuando solo queda 1 elemento, ya está ordenado
        for (int i = 0; i < n - 1; i++) {
            // Asumimos que el elemento en posición i es el mínimo
            int indiceMin = i;

            // Bucle interno: busca el elemento más pequeño en el resto del arreglo
            // Comienza en i+1 porque los elementos antes de i ya están ordenados
            for (int j = i + 1; j < n; j++) {
                // Si encontramos un elemento menor que el actual mínimo,
                // actualizamos el índice del mínimo
                if (arreglo[j] < arreglo[indiceMin]) {
                    indiceMin = j;
                }
            }

            // Intercambiamos el elemento mínimo encontrado con el elemento en posición i
            // Nota: Solo hacemos un intercambio por cada iteración del bucle externo
            int temp = arreglo[indiceMin];
            arreglo[indiceMin] = arreglo[i];
            arreglo[i] = temp;
        }
    }
}
