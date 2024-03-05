import java.util.Scanner;

public class CustoMacas {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número de maçãs compradas: ");
        int quantidadeMacas = scanner.nextInt();

        double custoTotal;
        if (quantidadeMacas < 12) {
            custoTotal = quantidadeMacas * 1.30;
        } else {
            custoTotal = quantidadeMacas * 1.00;
        }

        System.out.println("O custo total da compra é: R$ " + custoTotal);

        scanner.close();
    }
}
