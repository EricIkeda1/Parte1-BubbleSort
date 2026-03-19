import java.util.Scanner;

public class BubbleSortAnalise {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 1. Solicitar quantidade de elementos
        System.out.print("Digite a quantidade de valores: ");
        int n = sc.nextInt();

        // 2. Criar vetor com tamanho informado
        int[] vetor = new int[n];

        // 3. Ler os valores
        System.out.println("Digite os valores:");
        for (int i = 0; i < n; i++) {
            System.out.print("Valor " + (i + 1) + ": ");
            vetor[i] = sc.nextInt();
        }

        System.out.println("\nVetor original:");
        mostrarVetor(vetor);

        int comparacoes = 0;
        int trocas = 0;

        // Bubble Sort
        for (int i = 0; i < n - 1; i++) {

            // cada rodada do bubble
            System.out.println("\nPassada " + (i + 1) + ":");

            for (int j = 0; j < n - 1 - i; j++) {

                comparacoes++; 

                // troca os valores
                if (vetor[j] > vetor[j + 1]) {
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;

                    trocas++; 
                }
            }

            // mostra vetor a cada passada
            mostrarVetor(vetor);
        }

        // Resultado final
        System.out.println("\nVetor ordenado:");
        mostrarVetor(vetor);

        // resultado do algoritmo
        System.out.println("\n--- Análise do Bubble Sort ---");
        System.out.println("Total de comparações: " + comparacoes);
        System.out.println("Total de trocas: " + trocas);

        sc.close(); 
    }

    public static void mostrarVetor(int[] v) {
        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i] + " ");
        }
        System.out.println();
    }
}