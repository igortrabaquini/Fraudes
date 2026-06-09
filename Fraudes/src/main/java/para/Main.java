package para;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Lista que armazenará as transações geradas
        ArrayList<Transacao> transacoes = new ArrayList<>();

        // Gera 1000 transações para teste
        GeradorTransacoes.gerador(transacoes, 1000);

        long inicio;
        long fim;

        System.out.println("=== PROCESSAMENTO SEQUENCIAL ===");

        // Marca o horário de início
        inicio = System.currentTimeMillis();

        // Filtra as transações suspeitas usando stream normal
        List<Transacao> suspeitasSequencial =
                transacoes.stream()
                          .filter(ValidadorFraude::ehSuspeita)
                          .toList();

        // Marca o horário de término
        fim = System.currentTimeMillis();

        // Mostra os resultados
        System.out.println("Tempo: " + (fim - inicio) + " ms");
        System.out.println("Quantidade de fraudes: " + suspeitasSequencial.size());

        System.out.println("\n=== PROCESSAMENTO PARALELO ===");

        // Marca o horário de início
        inicio = System.currentTimeMillis();

        // Filtra as transações suspeitas usando parallelStream
        List<Transacao> suspeitasParalelo =
                transacoes.parallelStream()
                          .filter(ValidadorFraude::ehSuspeita)
                          .toList();

        // Marca o horário de término
        fim = System.currentTimeMillis();

        // Mostra os resultados
        System.out.println("Tempo: " + (fim - inicio) + " ms");
        System.out.println("Quantidade de fraudes: " + suspeitasParalelo.size());
    }
}