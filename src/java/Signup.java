/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.RequestScoped;

@ManagedBean (name="signup")
@RequestScoped 
//@SessionScoped
public class Signup {
    // variables
    String password, tcNo;
    String errorText = "";
    
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
    
    public void setTcNo(String tcNo) { 
        this.tcNo = tcNo;
    }
    
    public String getTcNo() {
        return this.tcNo;
    }
    
    public String signup() {
        System.out.println(this.errorText);
        
        if (this.errorText.length() != 0) {
            // do not redirect
            return "/signup.xhtml?faces-redirect=true";
        }
        
        return "/resetPassword.xhtml?faces-redirect=true";
    }
}
