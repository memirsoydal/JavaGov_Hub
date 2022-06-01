package user;

/**
 *
 * @author emirm
 */

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.RequestScoped;

@ManagedBean (name="user")
@ApplicationScoped // bean nesnesinin sadece bir request boyunca yaşaması anlamına gelir. Bir sonraki requestte bean sıfırlanır.
//@SessionScoped
public class User {
    // variables
    public static int id = 0;
    public static String email = "", name = "", surname = "";

    // special functions

    public static String getName() {
        return name;
    }
    
    public static int getId() {
        return id;
    }
    
}