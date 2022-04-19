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
    private String text = "abc";
    
    public void setText(String text) {
        this.text = text;
    }
    
    public String getText() {
        return this.text;
    }
}
