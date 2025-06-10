import java.util.Scanner;

public class CorretorProva {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Gabarito oficial
        char[] gabarito = {'B', 'A', 'C', 'D', 'B', 'C', 'A', 'A', 'B', 'E'};
        char[] respostas = new char[10];
        int acertos = 0;

        System.out.println("=== CORRETOR DE PROVA ===");
        System.out.println("Você irá responder 10 questões com alternativas de A a E.");
        System.out.println("Pressione ENTER para começar...");
        scanner.nextLine(); // Aguarda ENTER para iniciar

        // Ler as respostas do usuário
        for (int i = 0; i < 10; i++) {
            System.out.print("Questão " + (i + 1) + ": ");
            String entrada = scanner.next().trim(); // Lê a resposta e remove espaços

            // Trata letras minúsculas e protege contra entradas vazias
            while (entrada.isEmpty() || entrada.length() != 1 ||
                   !"ABCDEabcde".contains(entrada)) {
                System.out.print("Resposta inválida. Digite apenas A, B, C, D ou E: ");
                entrada = scanner.next().trim();
            }

            respostas[i] = Character.toUpperCase(entrada.charAt(0));
        }

        // Corrigir e contar os acertos
        for (int i = 0; i < 10; i++) {
            if (respostas[i] == gabarito[i]) {
                acertos++;
            }
        }

        // Exibir resultado
        System.out.println("\nVocê acertou " + acertos + " de 10 questões.");

        // Mensagem de aprovação ou reprovação
        if (acertos >= 7) {
            System.out.println("Resultado: ✅ Aprovado!");
        } else {
            System.out.println("Resultado: ❌ Reprovado.");
        }

        // Exibir correção individual
        System.out.println("\nCorreção:");
        for (int i = 0; i < 10; i++) {
            String status = (respostas[i] == gabarito[i])
                ? "✔️ Correto"
                : "❌ Errado (Certa: " + gabarito[i] + ")";
            System.out.println("Q" + (i + 1) + ": Sua resposta: " + respostas[i] + " - " + status);
        }

        scanner.close();
    }
}
