import java.util.Scanner;

public class OrdenacaoAtividade2 {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        System.out.print("Informe a quantidade de numeros: ");
        int total = ler.nextInt();

        int[] valores = new int[total];

        for (int i = 0; i < total; i++) {
            System.out.print("Numero " + (i + 1) + ": ");
            valores[i] = ler.nextInt();
        }

        int[] valoresSelection = new int[total];
        int[] valoresInsertion = new int[total];

        copiarValores(valores, valoresSelection);
        copiarValores(valores, valoresInsertion);

        System.out.println();
        System.out.print("Antes de ordenar: ");
        imprimir(valores);

        long comecoSelection = System.nanoTime();
        Resultado r1 = fazerSelection(valoresSelection);
        long fimSelection = System.nanoTime();

        long comecoInsertion = System.nanoTime();
        Resultado r2 = fazerInsertion(valoresInsertion);
        long fimInsertion = System.nanoTime();

        System.out.println();
        System.out.println("Selection Sort");
        System.out.print("Depois: ");
        imprimir(valoresSelection);
        System.out.println("Comparacoes: " + r1.comparacoes);
        System.out.println("Trocas: " + r1.trocas);
        System.out.println("Tempo: " + (fimSelection - comecoSelection) + " ns");

        System.out.println();
        System.out.println("Insertion Sort");
        System.out.print("Depois: ");
        imprimir(valoresInsertion);
        System.out.println("Comparacoes: " + r2.comparacoes);
        System.out.println("Trocas: " + r2.trocas);
        System.out.println("Tempo: " + (fimInsertion - comecoInsertion) + " ns");

        ler.close();
    }

    public static void copiarValores(int[] origem, int[] destino) {
        for (int i = 0; i < origem.length; i++) {
            destino[i] = origem[i];
        }
    }

    public static void imprimir(int[] v) {
        System.out.print("[");

        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i]);
            if (i != v.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }

    public static Resultado fazerSelection(int[] v) {
        int comparacoes = 0;
        int trocas = 0;

        for (int i = 0; i < v.length - 1; i++) {
            int menorIndice = i;

            for (int j = i + 1; j < v.length; j++) {
                comparacoes++;

                if (v[j] < v[menorIndice]) {
                    menorIndice = j;
                }
            }

            if (menorIndice != i) {
                int temp = v[i];
                v[i] = v[menorIndice];
                v[menorIndice] = temp;
                trocas++;
            }
        }

        return new Resultado(comparacoes, trocas);
    }

    public static Resultado fazerInsertion(int[] v) {
        int comparacoes = 0;
        int trocas = 0;

        for (int i = 1; i < v.length; i++) {
            int guardado = v[i];
            int pos = i - 1;

            while (pos >= 0 && v[pos] > guardado) {
                comparacoes++;
                v[pos + 1] = v[pos];
                trocas++;
                pos--;
            }

            if (pos >= 0) {
                comparacoes++;
            }

            v[pos + 1] = guardado;
        }

        return new Resultado(comparacoes, trocas);
    }

    static class Resultado {
        int comparacoes;
        int trocas;

        Resultado(int comparacoes, int trocas) {
            this.comparacoes = comparacoes;
            this.trocas = trocas;
        }
    }
}
