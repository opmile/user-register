public class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String toLine() {
        return name + "-" + email;
    }

    public static User fromUser(String line) {
        String[] dataUser = line.split("-");
        return new User(dataUser[0], dataUser[1]);
    }
}
