package Util;
import java.util.Random;

public class GeneradorDatos {
    private static final Random random = new Random();

    // Datos aleatorios
    public static int[] generarAleatorio(int tamanyo) {
        int[] arreglo = new int[tamanyo];
        for (int i = 0; i < tamanyo; i++) {
            arreglo[i] = random.nextInt(100000);
        }
        return arreglo;
    }

    // Datos ordenados (mejor caso)
    public static int[] generarOrdenado(int tamaño) {
        int[] arreglo = new int[tamaño];
        for (int i = 0; i < tamaño; i++) {
            arreglo[i] = i;
        }
        return arreglo;
    }

    // Datos invertidos (peor caso)
    public static int[] generarInvertido(int tamaño) {
        int[] arreglo = new int[tamaño];
        for (int i = 0; i < tamaño; i++) {
            arreglo[i] = tamaño - i;
        }
        return arreglo;
    }
}
