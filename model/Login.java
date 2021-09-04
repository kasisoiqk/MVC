/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package New.model;

/**
 *
 * @author Laptopkhanhtran.vn
 */
public class Login {
    private int id;
    private String userName;
    private String pass;
    private String fullName;

    public Login() {
    }

    public Login(int id, String userName, String pass, String fullName) {
        this.id = id;
        this.userName = userName;
        this.pass = pass;
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Login{" + "id=" + id + ", userName=" + userName + ", pass=" + pass + ", fullName=" + fullName + '}';
    }
    
    
}
