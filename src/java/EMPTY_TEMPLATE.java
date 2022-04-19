/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.RequestScoped;

@ManagedBean (name="your_class_name")
@RequestScoped // bean nesnesinin sadece bir request boyunca yaşaması anlamına gelir. Bir sonraki requestte bean sıfırlanır.
//@SessionScoped
public class EMPTY_TEMPLATE {
    // variables
    String xxx = "xxx";
    
    // getters and setters
    public void setXxx(String xxx) { 
        this.xxx = xxx;
    }
    
    public String getXxx() {
        return this.xxx;
    }
    
    // special functions
}
