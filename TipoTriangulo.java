import java.util.Scanner;

public class TipoTriangulo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite os comprimentos dos lados do triângulo:");
        System.out.print("Lado 1: ");
        double lado1 = scanner.nextDouble();
        System.out.print("Lado 2: ");
        double lado2 = scanner.nextDouble();
        System.out.print("Lado 3: ");
        double lado3 = scanner.nextDouble();

        if (lado1 + lado2 > lado3 && lado1 + lado3 > lado2 && lado2 + lado3 > lado1) {
            // Verificando o tipo de triângulo
            if (lado1 == lado2 && lado2 == lado3) {
                System.out.println("Triângulo Equilátero");
            } else if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3) {
                System.out.println("Triângulo Isósceles");
            } else {
                System.out.println("Triângulo Escaleno");
            }
        } else {
            System.out.println("Os comprimentos dos lados não formam um triângulo.");
        }
        scanner.close();
    }
}
