/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.RequestScoped;

@ManagedBean (name="search")
@ApplicationScoped
public class Search {
    // variables
    String searchText = "";
    
    // getters and setters
    public void setSearchText(String searchText) { 
        this.searchText = searchText;
    }
    
    public String getSearchText() {
        return this.searchText;
    }
}