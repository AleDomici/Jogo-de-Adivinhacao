import java.util.Random;
import java.util.Scanner;

public class JogoDoAdvinha {
    public static void main (String[] args) {
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
            }
            }

        }



    }

}
