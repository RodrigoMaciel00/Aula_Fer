import java.util.Scanner;


class Conta {
    protected String titular;
    protected double saldo;


    public Conta(String titular) {
        this.titular = titular;
        this.saldo = 0.0;
    }


    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$ " + valor + " realizado com sucesso.");
    }


    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente para realizar o saque.");
        }
    }


    public void exibirDados() {
        System.out.println("\nDados da Conta:");
        System.out.println("Titular: " + titular);
        System.out.println("Saldo: R$ " + saldo);
    }
}


class ContaCorrente extends Conta {
    private double limiteChequeEspecial;


    public ContaCorrente(String titular) {
        super(titular);
        this.limiteChequeEspecial = 1000.0;
    }


    public void usarChequeEspecial(double valor) {
        if (valor <= saldo + limiteChequeEspecial) {
            saldo -= valor;
            System.out.println("Uso de cheque especial de R$ " + valor + " realizado com sucesso.");
        } else {
            System.out.println("Limite do cheque especial excedido.");
        }
    }
}


class ContaPoupanca extends Conta {

    public ContaPoupanca(String titular) {
        super(titular);
    }


    public double calcularRendimento(double selic) {
        if (selic > 8.5) {
            return 0.005 * saldo;
        } else {
            return 0.007 * selic * saldo;
        }
    }
}

// Classe Main
public class SistemaB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Sistema Bancário");


        System.out.println("Selecione o tipo de conta:");
        System.out.println("1. Conta Corrente");
        System.out.println("2. Conta Poupança");
        System.out.print("Opção: ");
        int opcaoConta = scanner.nextInt();


        System.out.print("Digite o nome do titular da conta: ");
        scanner.nextLine();
        String titular = scanner.nextLine();


        Conta conta;
        if (opcaoConta == 1) {
            conta = new ContaCorrente(titular);
        } else {
            conta = new ContaPoupanca(titular);
        }


        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Depositar");
            System.out.println("2. Sacar");
            if (opcaoConta == 1) {
                System.out.println("3. Usar Cheque Especial");
            } else {
                System.out.println("3. Calcular Rendimento");
            }
            System.out.println("4. Exibir Dados da Conta");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");


            if (scanner.hasNextInt()) {
                int opcao = scanner.nextInt();
                switch (opcao) {
                    case 1:
                        System.out.print("Digite o valor para depósito: ");
                        double valorDeposito = scanner.nextDouble();
                        conta.depositar(valorDeposito);
                        break;
                    case 2:
                        System.out.print("Digite o valor para saque: ");
                        double valorSaque = scanner.nextDouble();
                        conta.sacar(valorSaque);
                        break;
                    case 3:
                        if (opcaoConta == 1) {
                            System.out.print("Digite o valor para uso do cheque especial: ");
                            double valorChequeEspecial = scanner.nextDouble();
                            ((ContaCorrente) conta).usarChequeEspecial(valorChequeEspecial);
                        } else {
                            System.out.print("Digite a taxa Selic: ");
                            double selic = scanner.nextDouble();
                            double rendimento = ((ContaPoupanca) conta).calcularRendimento(selic);
                            System.out.println("Rendimento da poupança: R$ " + rendimento);
                        }
                        break;
                    case 4:
                        conta.exibirDados();
                        break;
                    case 5:
                        System.out.println("Saindo do programa...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opção inválida.");
                }
            } else {
                System.out.println("Por favor, insira um número inteiro.");
                scanner.next();
            }
        }
    }
}
