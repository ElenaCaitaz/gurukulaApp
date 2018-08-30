package fixtures;

public class InputData {
    private String login;
    private String email;
    private String newPassword;
    private String confirmPassword;

    public InputData(String login,
                     String email,
                     String newPassword,
                     String confirmPassword) {
        this.login = login;
        this.email = email;
        this.newPassword = newPassword;
        this.confirmPassword = confirmPassword;

    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
