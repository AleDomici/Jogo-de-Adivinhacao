import java.util.Random;
import java.util.Scanner;

public class JogoDoAdvinha {
            /**
             * Inicia o jogo do Adivinha
             * O jogo sorteia um número aleatório e o jogador tenta adivinhar esse número.
             * O jogador pode jogar várias vezes e a pontuação é acumulada
             * Ao final de cada rodada, o jogador decide se quer continuar ou sair do game
             *
             * @param args Argumentos de linha de comando (não utilizado)
             */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random(); // Para gerar números aleatórios

        int pontuacaoTotal = 0;             //Variável que acumula a pontuação total ao longo das rodadas
        boolean continuar = true;           //Controle de fluxo para loop principal

        System.out.println("Bᴇᴍ-ᴠɪɴᴅᴏ ᴀᴏ Jᴏɢᴏ ᴅᴏ Aᴅɪᴠɪɴʜᴀ");

                    // Loop que permite jogar várias rodadas

        while (continuar) {
            int numeroSorteado = random.nextInt(100) + 1;       //Sorteia um número entre 1 e 100
            int tentativas = 0;         //Contador de tentativas por rodada
            boolean acertou = false;        //Flag que indica se o jogador acertou o número

            System.out.println("Tᴇɴᴛᴇ ᴀᴅɪᴠɪɴʜᴀ ᴏ ɴᴜ́ᴍᴇʀᴏ (ᴇɴᴛʀᴇ 1 ᴇ 100): ");

            while (!acertou) {          //Loop que permite tentar adivinhar até acertar
                System.out.println("Dɪɢɪᴛᴇ sᴇᴜ ᴘᴀʟᴘɪᴛᴇ: ");         //solicita
                int palpite = scanner.nextInt();                        //lê
                tentativas++;               //incrementa o contador

                if (palpite == numeroSorteado) {            //se acertar exibe a mensagem alcularPontos
                    System.out.println("Parabens você acertou!");
                    int pontos = calcularPontos(tentativas);
                    pontuacaoTotal += pontos;               //acumula pontos
                    System.out.println("Você ganhou " + pontos + "pontos nessa rodada.");
                    acertou = true;             //define que acertou

                } else if (Math.abs(palpite - numeroSorteado) <= 10) {

                    System.out.println("Quente! Você está perto.");        // Caso esteja perto "quente"
                } else {
                    System.out.println("Frio! Você está longe");           //caso esteja longe "frio"
                }
            }

            System.out.println("Pontuação total: " + pontuacaoTotal);           //Exibe pontuação total acumulada após fechar a rodada
            System.out.println("Deseja jogar outra rodada? (s/n):");

            continuar = scanner.next().equalsIgnoreCase("s");
        }
        System.out.println("\n=== Obrigado por jogar! Sua pontuação final foi: " + pontuacaoTotal + " ===");
        scanner.close();
    }

    /**
     * Calcula os pontos com base no número de tentativas.
     * Menos tentativas resultam em mais pontos.
     *
     * @param tentativas Número de tentativas realizadas pelo jogador para acertar o número
     * @return A quantidade de pontos que o jogador recebe, dependendo das tentativas.
     */

    private static int calcularPontos(int tentativas) {
        if (tentativas == 1) {
            return 100;
        } else if (tentativas <= 3) {
            return 70;
        } else if (tentativas <= 5) {
            return 50;
        } else {
            return 30;
        }
    }
}
