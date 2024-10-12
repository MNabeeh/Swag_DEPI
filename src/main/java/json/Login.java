package json;

public class Login {
    private String username;
   private String passWord;

    public Login(String username, String passWord) {
        this.username = username;
        this.passWord = passWord;
    }

    public String getUsername() {
        return username;
    }


    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}
