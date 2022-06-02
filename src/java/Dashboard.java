/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.RequestScoped;

@ManagedBean (name="dashboard")
@RequestScoped 
//@SessionScoped
public class Dashboard {
    // variables
    String searchText;
    String name = user.User.name;
    
    // getters and setters
    public void setSearchText(String text) { 
        this.searchText = text;
    }
    
    public String getSearchText() { 
        return this.searchText;
    }
    
    public void setName(String name) { 
        this.name = name;
    }
    
    public String getName() { 
        return this.name;
    }
    
    public String b1() {
        return "./kimlik.xhtml";
    }
    
    public String b2() {
        return "./tapu.xhtml";
    }
    
    public String b3() {
        return "./ceza.xhtml";
    }
    
    public String b4() {
        return "./emeklilik.xhtml";
    }
    
    public String b5() {
        return "./basvuru.xhtml";
    }
    
    public String dashboard() {
        return "/dashboard.xhtml";
    }
}
