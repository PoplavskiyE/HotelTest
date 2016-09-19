/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author fraian
 */
public class User {

    private Integer id/*idUser*/;
    private String login;
    private String password;
    private String email;
    private String phone;

    public User() {
    }

    public User(Integer id, String login, String password, String email, String phone) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    public User(String login, String password, String email, String phone) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", login=" + login + ", password=" + password + ", email=" + email + ", phone=" + phone + '}';
    }

}
