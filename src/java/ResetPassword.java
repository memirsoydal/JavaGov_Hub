/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import db.Database;
import java.sql.SQLException;
import user.User;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;

@ManagedBean (name="reset_password")
@ApplicationScoped 
public class ResetPassword {
    // variables
    String password, password2, tcNo;
    String errorText = ".";
    
    // getters and setters
    public void setErrorText(String error) { 
        this.errorText = error;
    }
    
    public String getErrorText() {
        return this.errorText;
    }
    
    public void setPassword(String password) { 
        this.password = password;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword2(String password2) { 
        this.password2 = password2;
    }
    
    public String getPassword2() {
        return this.password2;
    }
    
    public void setTcNo(String tcNo) { 
        this.tcNo = tcNo;
    }
    
    public String getTcNo() {
        return this.tcNo;
    }
    
    public String reset() throws SQLException {
        System.out.println(this.password + "  " + this.password2);
        if (this.password.equals(this.password2)) {
            this.errorText = "Yeni bir parola giriniz.";
            return "/resetPassword.xhtml?faces-redirect=true";
        } else if (this.password2.length() < 5) { 
            this.errorText = "Girilen parola çok kısa.";
            return "/resetPassword.xhtml?faces-redirect=true";
        } else if (!Database.resetPassword(tcNo, password, password2)) {
            this.errorText = "Girdiğiniz şifre yanlış.";
            return "/resetPassword.xhtml?faces-redirect=true";
        } else {
            this.errorText = "";
        }
        
        if (this.errorText.length() != 0) {
            // do not redirect
            return "/resetPassword.xhtml?faces-redirect=true";
        }
        return "/signup.xhtml?faces-redirect=true";
    }
    
    // special functions
}
