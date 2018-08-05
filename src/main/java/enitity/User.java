package enitity;

public class User {
    private String name;
    private String pass;

    public User(String n, String p) {
        this.name = n;
        this.pass = p;
    }

    public Integer getCredentialHash() {
        String password = name + pass;
        return password.hashCode();
    }

}
