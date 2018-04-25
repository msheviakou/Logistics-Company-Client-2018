package edu.bsuir.form;

public class UsersForm {
    private int id;
    private String post;
    private String login;
    private String password;
    private String name;

    public UsersForm() {}

    public UsersForm(int id, String name, String post, String login, String password) {
        this.id = id;
        this.post = post;
        this.login = login;
        this.password = password;
        this.name = name;
    }

    public UsersForm(String name, String post, String login, String password) {
        this.post = post;
        this.login = login;
        this.password = password;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
