import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("1. Inserir elemento");
            System.out.println("2. Remover elemento");
            System.out.println("3. Imprimir árvore");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Digite o número para inserir: ");
                    int value = scanner.nextInt();
                    tree.insert(value);
                    break;
                case 2:
                    System.out.print("Digite o número para remover: ");
                    value = scanner.nextInt();
                    tree.delete(value);
                    break;
                case 3:
                    BTreePrinter.printNode(tree.root);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (option != 0);

        scanner.close();
    }
}
