package Busqueda;

/**
 * Clase que implementa el algoritmo de búsqueda binaria
 * La búsqueda binaria solo funciona en arreglos ordenados
 */
public class BusquedaBinaria {
    /**
     * El metodo busca un elemento en un arreglo ordenado usando búsqueda binaria
     * el arreglo que recibe es el arreglo ordenado donde debe buscar
     * el objetivo es el valor que queremos encontrar
     * y retorna índice donde se encuentra el objetivo, o -1 si no existe
     */
    public static int buscar(int[] arreglo, int objetivo) {
        // Inicializamos los límites de búsqueda
        int izquierda = 0; // Primer índice del arreglo
        int derecha = arreglo.length - 1; // Último índice del arreglo

        // Mientras el rango de búsqueda sea válido
        while (izquierda <= derecha) {
            // Calculamos el índice del medio
            int medio = (izquierda + derecha) / 2;

            // Si encontramos el objetivo, retornamos su posición
            if (arreglo[medio] == objetivo) {
                return medio;
            }

            // Si el valor del medio es menor que el objetivo,
            // buscamos en la mitad derecha
            if (arreglo[medio] < objetivo) {
                izquierda = medio + 1;
            } else {
                // Si el valor del medio es mayor que el objetivo,
                // buscamos en la mitad izquierda
                derecha = medio - 1;
            }
        }
        // Si salimos del bucle, el elemento no existe en el arreglo
        return -1;
    }
}
