import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PessoaDAO dao = new PessoaDAO();

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Listar Pessoas");
            System.out.println("2. Inserir Pessoa");
            System.out.println("3. Atualizar Pessoa");
            System.out.println("4. Excluir Pessoa");
            System.out.println("5. Sair");
            System.out.print("Escolha: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha

            switch (opcao) {
                case 1:
                    List<Pessoa> lista = dao.listar();
                    for (Pessoa p : lista) {
                        System.out.println(p.getId() + " - " + p.getNome() + " - " + p.getIdade() + " anos");
                    }
                    break;
                case 2:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Idade: ");
                    int idade = scanner.nextInt();
                    dao.inserir(new Pessoa(0, nome, idade));
                    System.out.println("Pessoa adicionada com sucesso!");
                    break;
                case 3:
                    System.out.print("ID da pessoa a atualizar: ");
                    int idAtualizar = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Novo Nome: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Nova Idade: ");
                    int novaIdade = scanner.nextInt();
                    dao.atualizar(new Pessoa(idAtualizar, novoNome, novaIdade));
                    System.out.println("Pessoa atualizada com sucesso!");
                    break;
                case 4:
                    System.out.print("ID da pessoa a excluir: ");
                    int idExcluir = scanner.nextInt();
                    dao.excluir(idExcluir);
                    System.out.println("Pessoa removida com sucesso!");
                    break;
                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
