import java.util.Scanner;

public class BubbleSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Programa programa = new Programa(sc);
        programa.executar();

        sc.close();
    }
}

class Programa {
    private Scanner scanner;
    private OrdenacaoBubbleSort bubbleSort;

    public Programa(Scanner scanner) {
        this.scanner = scanner;
        this.bubbleSort = new OrdenacaoBubbleSort();
    }

    public void executar() {
        System.out.print("Digite a quantidade de valores: ");
        int n = scanner.nextInt();

        int[] vetor = new int[n];

        System.out.println("Digite os valores:");
        for (int i = 0; i < n; i++) {
            System.out.print("Valor " + (i + 1) + ": ");
            vetor[i] = scanner.nextInt();
        }

        System.out.println("\nVetor original:");
        Exibicao.mostrarVetor(vetor);

        Resultado resultado = bubbleSort.ordenar(vetor);

        System.out.println("\nVetor ordenado:");
        Exibicao.mostrarVetor(vetor);

        System.out.println("\nResultado da Ordenação");
        System.out.println("Tempo de execução da ordenação: " + resultado.getTempo() + " ns");
        System.out.println("Total de comparações: " + resultado.getComparacoes());
        System.out.println("Total de trocas: " + resultado.getTrocas());
    }
}

class OrdenacaoBubbleSort {

    public Resultado ordenar(int[] vetor) {
        int comparacoes = 0;
        int trocas = 0;

        long inicio = System.nanoTime();

        for (int i = 0; i < vetor.length - 1; i++) {
            for (int j = 0; j < vetor.length - 1 - i; j++) {
                comparacoes++;

                if (vetor[j] > vetor[j + 1]) {
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                    trocas++;
                }
            }
        }

        long fim = System.nanoTime();
        long tempo = fim - inicio;

        return new Resultado(comparacoes, trocas, tempo);
    }
}

class Resultado {
    private int comparacoes;
    private int trocas;
    private long tempo;

    public Resultado(int comparacoes, int trocas, long tempo) {
        this.comparacoes = comparacoes;
        this.trocas = trocas;
        this.tempo = tempo;
    }

    public int getComparacoes() {
        return comparacoes;
    }

    public int getTrocas() {
        return trocas;
    }

    public long getTempo() {
        return tempo;
    }
}

class Exibicao {
    public static void mostrarVetor(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println();
    }
}
