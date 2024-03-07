import java.util.Scanner;

public class Cadastro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Você é professor ou aluno? (Digite 'professor' ou 'aluno')");
        String tipoUsuario = scanner.nextLine();

        if (tipoUsuario.equalsIgnoreCase("aluno")) {
            System.out.println("Cadastro de Aluno");
            System.out.print("Matrícula (4 dígitos): ");
            int matricula = scanner.nextInt();
            System.out.print("Nota 1: ");
            double nota1 = scanner.nextDouble();
            System.out.print("Nota 2: ");
            double nota2 = scanner.nextDouble();

            double media = (nota1 + nota2) / 2;
            System.out.println("\nDados do Aluno:");
            System.out.println("Matrícula: " + matricula);
            System.out.println("Nota 1: " + nota1);
            System.out.println("Nota 2: " + nota2);
            System.out.println("Média: " + media);
        } else if (tipoUsuario.equalsIgnoreCase("professor")) {
            System.out.println("Cadastro de Professor");
            System.out.print("Matrícula (4 dígitos): ");
            int matricula = scanner.nextInt();
            System.out.print("Salário: ");
            double salario = scanner.nextDouble();

            System.out.println("\nDados do Professor:");
            System.out.println("Matrícula: " + matricula);
            System.out.println("Salário: " + salario);
        } else {
            System.out.println("Tipo de usuário inválido.");
        }

        scanner.close();
    }
}
