import java.util.Scanner;

class Funcionario {
    protected String nome;
    protected double salario;


    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }


    public double calcularBonus() {
        return salario * 0.10; // 10% do salário
    }


    public void exibirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Salário: R$ " + salario);
    }
}

class Gerente extends Funcionario {
    private String departamento;


    public Gerente(String nome, double salario, String departamento) {
        super(nome, salario);
        this.departamento = departamento;
    }


    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Departamento: " + departamento);
    }
}


class Diretor extends Funcionario {
    private int acoes;


    public Diretor(String nome, double salario, int acoes) {
        super(nome, salario);
        this.acoes = acoes;
    }


    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Ações: " + acoes);
    }
}


public class Dados {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Cadastro de Funcionários");

        System.out.print("Nome do funcionário: ");
        String nome = scanner.nextLine();
        System.out.print("Salário: ");
        double salario = scanner.nextDouble();


        Funcionario funcionario = new Funcionario(nome, salario);

        System.out.println("\nDados do Funcionário:");
        funcionario.exibirDados();

        System.out.println("\nCadastro de Gerente");
        System.out.print("Departamento: ");
        scanner.nextLine();
        String departamento = scanner.nextLine();


        Gerente gerente = new Gerente(nome, salario, departamento);

        System.out.println("\nDados do Gerente:");
        gerente.exibirDados();

        System.out.println("\nCadastro de Diretor");
        System.out.print("Número de ações: ");
        int acoes = scanner.nextInt();


        Diretor diretor = new Diretor(nome, salario, acoes);

        System.out.println("\nDados do Diretor:");
        diretor.exibirDados();

        scanner.close();
    }
}
