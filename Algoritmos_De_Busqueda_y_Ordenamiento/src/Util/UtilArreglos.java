package Util;

public class UtilArreglos {
    /**
     * Crea una copia independiente de un arreglo de enteros.
     *
     *El arreglo que queremos copiar se le pasa como atributo
     *Retorna un nuevo arreglo con los mismos valores que el original
     *
     * Importante: Esta es una COPIA PROFUNDA para tipos primitivos.
     * Modificar la copia NO afecta al arreglo original.
     *
     * Ejemplo de uso:
     *   int[] datos = {1, 2, 3};
     *   int[] copia = UtilArreglos.copiar(datos);
     *   copia[0] = 999;  // datos[0] sigue siendo 1
     */
    public static int[] copiar(int[] original) {
        return original.clone();
    }
}
