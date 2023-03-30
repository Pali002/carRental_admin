package models.api;

public class User {
    int id;
    String email;
    String password;
    String confirm_password;
    public User(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }    
}
