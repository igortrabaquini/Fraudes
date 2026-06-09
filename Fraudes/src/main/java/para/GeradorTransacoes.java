package para;

import java.util.ArrayList;
import java.util.Random;

public class GeradorTransacoes {

    public static void gerador(ArrayList<Transacao> transacoes, int quantidade) {

        Random random = new Random();

        // Gera transações aleatórias
       
        for (int i = 0; i < quantidade - 1; i++) {

            StringBuilder cpf = new StringBuilder();

           
            if (random.nextInt(19) == 0) {

              
                cpf.append("000");

               
                for (int j = 0; j < 8; j++) {
                    cpf.append(random.nextInt(10));
                }

                
                transacoes.add(
                        new Transacao(
                                String.valueOf(i + 1),
                                random.nextDouble(10000) + 5000,
                                cpf.toString()
                        )
                );

            } else {

                // Gera um CPF comum com 11 dígitos
                for (int j = 0; j < 11; j++) {
                    cpf.append(random.nextInt(10));
                }

              
                if (cpf.toString().startsWith("000")) {
                    cpf.replace(0, 3, "111");
                }

                // Gera uma transação normal
                transacoes.add(
                        new Transacao(
                                String.valueOf(i + 1),
                                random.nextDouble(100000),
                                cpf.toString()
                        )
                );
            }
        }

        
        transacoes.add(
                new Transacao(
                        String.valueOf(quantidade),
                        7250,
                        "00000000000"
                )
        );
    }
}
