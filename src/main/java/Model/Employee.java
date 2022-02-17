package Model;

public class Employee {

    private final String username;
    private final String password;

    public Employee(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
