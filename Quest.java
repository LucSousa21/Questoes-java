import java.util.Scanner;

public class CorretorProva {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Gabarito oficial (100 questões)
        char[] gabarito = {
            'A', 'D', 'B', 'E', 'A', 'D', 'E', 'B', 'A', 'E',
            'B', 'E', 'A', 'D', 'B', 'E', 'B', 'A', 'D', 'E',
            'B', 'A', 'D', 'B', 'C', 'A', 'B', 'E', 'C', 'D',
            'A', 'C', 'D', 'A', 'E', 'C', 'A', 'D', 'E', 'B',
            'A', 'D', 'A', 'C', 'E', 'D', 'A', 'B', 'D', 'C',
            'A', 'C', 'B', 'D', 'C', 'A', 'E', 'C', 'A', 'B',
            'B', 'C', 'A', 'B', 'E', 'C', 'A', 'E', 'A', 'D',
            'D', 'E', 'B', 'D', 'E', 'A', 'A', 'E', 'A', 'E',
            'A', 'C', 'B', 'A', 'C', 'A', 'C', 'B', 'B', 'D',
            'A', 'C', 'C', 'A', 'C', 'B', 'B', 'D', 'B', 'D'
        };

        char[] respostas = new char[100];
        int acertos = 0;

        System.out.println("=== CORRETOR DE PROVA ===");
        System.out.println("Você irá responder 100 questões com alternativas de A a E.");
        System.out.println("Pressione ENTER para começar...");
        scanner.nextLine(); // Aguarda ENTER para iniciar

        // Ler as respostas do usuário
        for (int i = 0; i < 100; i++) {
            System.out.print("Questão " + (i + 1) + ": ");
            String entrada = scanner.next().trim(); // Lê a resposta e remove espaços

            // Validação da resposta
            while (entrada.isEmpty() || entrada.length() != 1 ||
                   !"ABCDEabcde".contains(entrada)) {
                System.out.print("Resposta inválida. Digite apenas A, B, C, D ou E: ");
                entrada = scanner.next().trim();
            }

            respostas[i] = Character.toUpperCase(entrada.charAt(0));
        }

        // Corrigir e contar os acertos
        for (int i = 0; i < 100; i++) {
            if (respostas[i] == gabarito[i]) {
                acertos++;
            }
        }

        // Exibir resultado
        System.out.println("\nVocê acertou " + acertos + " de 100 questões.");

        // Nova regra: mínimo 58 acertos para aprovação
        if (acertos >= 58) {
            System.out.println("Resultado: ✅ Aprovado!");
        } else {
            System.out.println("Resultado: ❌ Reprovado.");
        }

        // Exibir correção individual
        System.out.println("\nCorreção:");
        for (int i = 0; i < 100; i++) {
            String status = (respostas[i] == gabarito[i])
                ? "✔️ Correto"
                : "❌ Errado (Certa: " + gabarito[i] + ")";
            System.out.println("Q" + (i + 1) + ": Sua resposta: " + respostas[i] + " - " + status);
        }

        scanner.close();
    }
}