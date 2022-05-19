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
@SessionScoped
public class Services_Form {
    // variables
    String TcNo,Name,Surname,Address,DogumYeri,DogumTarihi;
    String AskerlikTarih;
    boolean Askerlik;
    String CezaSebep, CezaMiktar, CezaTarih;
    String EmekliYasiSure,SigortaSure;
    boolean Emekli,Calisiyor;
    String TapuluMal,IkametgahTarih,IkametgahKisi,Ikametgahm2;
    // getters and setters
//    setters will need to be changed to SQL UPDATE later. address, Calisiyor, Emekli, tapuluMal, IkametgahTarih, IkametgahKisi, Ikametgahm2
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
    public void setAskerlik(boolean Askerlik){
        this.Askerlik = Askerlik;
    }
    public boolean getAskerlik() {
        return this.Askerlik;
    }
    public void setAskerlikTarih(String AskerlikTarih){
        this.AskerlikTarih = AskerlikTarih;
    }
    public String getAskerlikTarih(){
        return this.AskerlikTarih;
    }
    public void setCezaSebep(String CezaSebep){
        this.CezaSebep = CezaSebep;
    }
    public String getCezaSebep(){
        return this.CezaSebep;
    }
    public void setCezaMiktar(String CezaMiktar){
        this.CezaMiktar = CezaMiktar;
    }
    public String getCezaMiktar(){
        return this.CezaMiktar;
    }
    public void setCezaTarih(String CezaTarih){
        this.CezaTarih = CezaTarih;
    }
    public String getCezaTarih(){
        return this.CezaTarih;
    }
    public void setEmekliYasiSure(String EmekliYasiSure){
        this.EmekliYasiSure = EmekliYasiSure;
    }
    public String getEmekliYasiSure(){
        return this.EmekliYasiSure;
    }
    public void setSigortaSure(String SigortaSure){
        this.SigortaSure = SigortaSure;
    }
    public String getSigortaSure(){
        return this.SigortaSure;
    }
    public void setEmekli(boolean Emekli){
        this.Emekli = Emekli;
    }
    public boolean getEmekli(){
        return this.Emekli;
    }
    public void setCalisiyor(boolean Calisiyor){
        this.Calisiyor = Calisiyor;
    }
    public boolean getCalisiyor(){
        return this.Calisiyor;
    }
    public void setTapuluMal(String TapuluMal){
        this.TapuluMal = TapuluMal;
    }
    public String getTapuluMal(){
        return this.TapuluMal;
    }
    public void setIkametgahTarih(String IkametgahTarih){
        this.IkametgahTarih = IkametgahTarih;
    }
    public String getIkametgahTarih(){
        return this.IkametgahTarih;
    }
    public void setIkametgahKisi(String IkametgahKisi){
        this.IkametgahKisi = IkametgahKisi;
    }
    public String getIkametgahKisi(){
        return this.IkametgahKisi;
    }
    public void setIkametgahm2(String Ikametgahm2){
        this.Ikametgahm2 = Ikametgahm2;
    }
    public String getIkametgahm2(){
        return this.Ikametgahm2;
    }
    public void getFormValues() throws SQLException{
        ResultSet myVariable = Database.applyForm(this.TcNo);
        this.Address = myVariable.getString("address");
        this.DogumYeri = myVariable.getString("dogumYeri");
        this.DogumTarihi = myVariable.getString("dogumTarihi");
    }    
    public void getAskerlikValues() throws SQLException{
        ResultSet myVariable = Database.askerlikForm(this.TcNo);
        this.Askerlik = myVariable.getBoolean("askerlik");
        this.AskerlikTarih = myVariable.getString("askerlikTarih");
    }
    public void getCezaValues() throws SQLException{
        ResultSet myVariable = Database.cezaForm(this.TcNo);
        this.CezaSebep = myVariable.getString("cezaSebep");
        this.CezaMiktar = myVariable.getString("cezaMiktar");
        this.CezaTarih = myVariable.getString("cezaTarih");
    }
    public void getSigortaValues() throws SQLException{
        ResultSet myVariable = Database.sigortaForm(this.TcNo);
        this.Emekli = myVariable.getBoolean("emekli");
        this.Calisiyor = myVariable.getBoolean("calisiyor");
        this.EmekliYasiSure = myVariable.getString("emekliyasisure");
        this.SigortaSure = myVariable.getString("sigortasure");
    }
    public void getIkametgahValues() throws SQLException{
        ResultSet myVariable = Database.ikametgahForm(this.TcNo);
        this.TapuluMal = myVariable.getString("tapuluMal");
        this.IkametgahKisi = myVariable.getString("ikametgahKisi");
        this.IkametgahTarih = myVariable.getString("ikametgahTarih");
        this.Ikametgahm2 = myVariable.getString("ikametgahm2");
    }
}