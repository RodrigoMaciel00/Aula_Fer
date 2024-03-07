import java.util.Scanner;


class Produto {
    protected String nome;
    protected int estoque;
    protected double preco;


    public Produto(String nome, int estoque, double preco) {
        this.nome = nome;
        this.estoque = estoque;
        this.preco = preco;
    }


    public void exibirDados() {
        System.out.println("\nDados do Produto:");
        System.out.println("Nome: " + nome);
        System.out.println("Estoque: " + estoque);
        System.out.println("Preço: R$ " + preco);
    }


    public void vender(int quantidade) {
        if (estoque >= quantidade) {
            estoque -= quantidade;
            System.out.println("Venda realizada com sucesso!");
        } else {
            System.out.println("Estoque insuficiente para realizar a venda.");
        }
    }
}


public class Vendas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Produto televisao = new Produto("Televisão", 10, 1500.0);
        Produto smartphone = new Produto("Smartphone", 20, 2000.0);


        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Vender Televisão");
            System.out.println("2. Vender Smartphone");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    televisao.exibirDados();
                    System.out.print("Quantidade desejada: ");
                    int quantidadeTV = scanner.nextInt();
                    televisao.vender(quantidadeTV);
                    break;
                case 2:
                    smartphone.exibirDados();
                    System.out.print("Quantidade desejada: ");
                    int quantidadeSmartphone = scanner.nextInt();
                    smartphone.vender(quantidadeSmartphone);
                    break;
                case 3:
                    System.out.println("Saindo do programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
