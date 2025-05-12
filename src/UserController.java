import java.sql.SQLOutput;
import java.util.Scanner;

public class UserController{
    private final UserService service = new UserService();
    private final Scanner scanner = new Scanner(System.in);

    public void run() {
        System.out.println("""
                1 - registrar novo usuário
                2 - listar usuários
                3 - atualizar usuário por email
                4 - deletar usuário por email
                0 - sair
                """);

        do {
            try {
                int option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1:
                        System.out.println("nome: ");
                        String name = scanner.nextLine();
                        System.out.println("email: ");
                        String email = scanner.nextLine();
                        service.registerUser(new User(name, email));
                        break;
                    case 2:
                        service.listUsers();
                        break;
                    case 3:
                        System.out.println("email: ");
                        String currentEmail = scanner.nextLine();
                        System.out.println("novo nome: ");
                        String newName = scanner.nextLine();
                        service.updateUser(new User(newName, currentEmail));
                        break;
                    case 4:
                        System.out.println("email: ");
                        String deleteEmail = scanner.nextLine();
                        service.deteleUser(deleteEmail);
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("insira um número de entrada permitido");
                }
            } catch (NumberFormatException e) {
                System.out.println("insira um número de entrada válido");
            }
        } while (true);
    }


}
