package Busqueda;

/**
 * Clase que implementa el algoritmo de búsqueda secuencial (o lineal).
 * Este algoritmo revisa cada elemento uno por uno hasta encontrar el objetivo.
 */
public class BusquedaSecuencial {
    public static int buscar(int[] arreglo, int objetivo) {
        // Recorremos el arreglo desde el inicio hasta el final
        for (int i = 0; i < arreglo.length; i++) {
            // Si encontramos el objetivo, retornamos inmediatamente su posición
            if (arreglo[i] == objetivo) {
                return i;
            }
        }
        return -1;
    }
}
