import java.util.Random;
import java.util.Scanner;

public class JogoDoAdvinha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int pontuacaoTotal = 0;
        boolean continuar = true;

        System.out.println("Bᴇᴍ-ᴠɪɴᴅᴏ ᴀᴏ Jᴏɢᴏ ᴅᴏ Aᴅɪᴠɪɴʜᴀ");

        while (continuar) {
            int numeroSorteado = random.nextInt(100) + 1;
            int tentativas = 0;
            boolean acertou = false;

            System.out.println("Tᴇɴᴛᴇ ᴀᴅɪᴠɪɴʜᴀ ᴏ ɴᴜ́ᴍᴇʀᴏ (ᴇɴᴛʀᴇ 1 ᴇ 100): ");

            while (!acertou) {
                System.out.println("Dɪɢɪᴛᴇ sᴇᴜ ᴘᴀʟᴘɪᴛᴇ: ");
                int palpite = scanner.nextInt();
                tentativas++;

                if (palpite == numeroSorteado) {
                    System.out.println("Parabens você acertou!");
                    int pontos = calcularPontos(tentativas);
                    pontuacaoTotal += pontos;
                    System.out.println("Você ganhou " + pontos + "pontos nessa rodada.");
                    acertou = true;

                } else if (Math.abs(palpite - numeroSorteado) <= 10) {

                    System.out.println("Quente! Você está perto.");
                } else {
                    System.out.println("Frio! Você está longe");
                }
            }

            System.out.println("Pontuação total: " + pontuacaoTotal);
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
