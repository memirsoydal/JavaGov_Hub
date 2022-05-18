/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import db.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.RequestScoped;

@ManagedBean (name="services_form")
@RequestScoped // bean nesnesinin sadece bir request boyunca yaşaması anlamına gelir. Bir sonraki requestte bean sıfırlanır.
//@SessionScoped
public class Services_Form {
    // variables
    String TcNo,Name,Surname,Address;
    
    // getters and setters
    public void setTcNo(String TcNo) { 
        this.TcNo = TcNo;
    }
    
    public String getTcNo() {
        return this.TcNo;
    }
    public void setName(String Name) { 
        this.Name = Name;
    }
    
    public String getName() {
        return this.Name;
    }
    public void setSurname(String Surname) { 
        this.Surname = Surname;
    }
    
    public String getSurname() {
        return this.Surname;
    }
    public void setAddress(String Address) { 
        this.Address = Address;
    }
    
    public String getAddress() {
        return this.Address;
    }
    public void setFormValues() throws SQLException{
        ResultSet myVariable = Database.applyForm(this.TcNo);
        this.Name = myVariable.getString("name");
        this.Surname = myVariable.getString("surname");
        this.Address = myVariable.getString("address");
    }
}