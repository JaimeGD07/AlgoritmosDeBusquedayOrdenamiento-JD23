package Ordenamiento;

public class Seleccion {
    public static void ordenar(int[] arreglo) {
        int n = arreglo.length;

        for (int i = 0; i < n - 1; i++) {
            int indiceMin = i;

            for (int j = i + 1; j < n; j++) {
                if (arreglo[j] < arreglo[indiceMin]) {
                    indiceMin = j;
                }
            }

            int temp = arreglo[indiceMin];
            arreglo[indiceMin] = arreglo[i];
            arreglo[i] = temp;
        }
    }
}
