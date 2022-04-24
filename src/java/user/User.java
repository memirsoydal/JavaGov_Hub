package user;

/**
 *
 * @author emirm
 */

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.RequestScoped;

@ManagedBean (name="user")
@RequestScoped // bean nesnesinin sadece bir request boyunca yaşaması anlamına gelir. Bir sonraki requestte bean sıfırlanır.
//@SessionScoped
public class User {
    // variables
    public static String tcNo = "", email = "", name = "", surname = "";

    // special functions
}