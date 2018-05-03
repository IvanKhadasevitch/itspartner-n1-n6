package net.itspartner.test.n6;

public class PasswordEmail {
    private String password;
    private String email;

    public PasswordEmail(String password, String email) {
        this.password = password;
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
