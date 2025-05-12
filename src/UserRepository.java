import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private static final String USER_FILE = "users.txt";

    public void save(User user) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(USER_FILE, true))) {
            bw.write(user.toLine());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("não foi possível abrir o arquivo");
        }
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(USER_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                users.add(User.fromUser(line));
            }
        } catch (FileNotFoundException e) {
            System.out.println("arquivo não encontrado");
        } catch (IOException e) {
            System.out.println("não foi possível abrir o arquivo");
        }
        return users;
    }

    public void update(User updatedUser) {
        List<User> users = (List<User>) findAll();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(USER_FILE))) {
            for (User user : users) {
                if (user.getEmail().equalsIgnoreCase(updatedUser.getEmail())) {
                    bw.write(updatedUser.toLine());
                } else {
                    bw.write(user.toLine());
                }
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("não foi possível abrir o arquivo");
        }
    }

    public void deleteByEmail(String email) {
        List<User> users = findAll();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(USER_FILE))) {
            for (User user : users) {
                if (!user.getEmail().equalsIgnoreCase(email)) {
                    bw.write(user.toLine());
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("não foi possível abrir o arquivo");
        }
    }

    public User findByEmail(String email) {
        for (User user : findAll()) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return user;
            }
        }
        return null;
    }
}
