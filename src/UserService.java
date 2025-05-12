public class UserService {
    UserRepository repository = new UserRepository();

    public boolean registerUser(User user) {
        if (repository.findByEmail(user.getEmail()) != null) {
            System.out.println("esse usuário já existe no sistema");
            return false;
        }
        repository.save(user);
        return true;
    }

    public boolean updateUser(User user) {
        if (repository.findByEmail(user.getEmail()) == null) {
            System.out.println("usuário não registrado no sistema");
            return false;
        }
        repository.update(user);
        return true;
    }

    public boolean deteleUser(String email) {
        if (repository.findByEmail(email) == null) {
            System.out.println("usuário não registrado no sistema");
            return false;
        }
        repository.deleteByEmail(email);
        return true;
    }

    public void listUsers() {
        for (User user : repository.findAll()) {
            System.out.println(user.getName() + " - " + user.getEmail());
        }
    }

}
