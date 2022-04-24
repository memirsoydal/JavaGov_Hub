/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import user.User;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;

import user.User;

@ManagedBean (name="reset_password")
@ApplicationScoped 
public class ResetPassword {
    // variables
    String password, password2, tcNo;
    String errorText = "Girilen T.C. Kimlik Numarasına sahip bir vatandaş bulunamadı";
    
    public ResetPassword() {
        System.out.println("test, inside reset pass");
        System.out.println("inside constructor password: " + password);
        System.out.println("inside constructor password2: " + password2);
    }
    
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
    
    public String redirect() {
        if (!this.password.equals(this.password2)) {
            this.errorText = "Girilen parolalar eşit değil.";
            return "/ResetPassword/resetPassword.xhtml?faces-redirect=true";
        } else {
            this.errorText = "";
        }
        
        if (this.errorText.length() != 0) {
            // do not redirect
            return "/ResetPassword/resetPassword.xhtml?faces-redirect=true";
        }
        
        return "/Signup/signup.xhtml?faces-redirect=true";
    }
    
    // special functions
}
