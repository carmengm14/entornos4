package com.company;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.print("Introduce el número para la criba de Erastótenes: ");

        int datos = lector.nextInt();
        int[] arrayDatos = new int[datos];
        System.out.println("\nNumero inicial hasta :" + datos);
        for (int i = 0; i < arrayDatos.length; i++) {
            if (i % 10 == 0) System.out.println();
            System.out.print(i + 1+ "\t");
        }
        arrayDatos = generarPrimos(datos);
        System.out.println("\nNumero de primos hasta:" + datos);
        for (int i = 0; i < arrayDatos.length; i++) {
            if (i % 10 == 0) System.out.println();
            System.out.print(arrayDatos[i] + "\t");
        }
    }

    public static int[] generarPrimos (int max)
    {
        int i,j;
        if (max >= 2) {
            // Declaraciones
            int tamanyo = max + 1; // Tamaño del array
            boolean [] esPrimo = new boolean[tamanyo];
            // Inicializar el array
            for (i = 0; i < tamanyo; i++)
                esPrimo[i] = true;
            // Eliminar el 0 y el 1, que no son primo
            esPrimo[0] = esPrimo[1] = false;
            // Criba
            for (i = 2; i < Math.sqrt(tamanyo) + 1; i++) {
                if (esPrimo[i]) {
                    // Eliminar los múltiplos de i
                    for (j = 2 * i; j < tamanyo; j += i)
                        esPrimo[j] = false;
                }
            }

            int contador = 0;
            for (i = 0; i < tamanyo; i++) {
                if (esPrimo[i])
                    contador++;
            }

            int [] primos = new int[contador];
            for (i = 0, j = 0; i < tamanyo; i++) {
                if (esPrimo[i])
                    primos[j++] = i;
            }
            return primos;
        } else { // max < 2
            return new int[0];
        }
    }
}
