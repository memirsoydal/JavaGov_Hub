/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import db.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.RequestScoped;

@ManagedBean (name="services")
@ApplicationScoped
public class Services {
    // variables
    int ID = user.User.id;
    String Name,Surname,Gender,Address="",DogumYeri,DogumTarihi;
    String Askerlik,AskerlikKacagi;
    String CezaSebep,CezaTarih;
    int CezaMiktar;
    String EmeklilikBaslangici;
    String Emekli,Calisiyor;
    String tapuAdres,IkametgahTarih,IkametgahKisi,IkametgahMetrekare;
    int KURUM_ID;
    String BASVURU_DURUMU;
    String BASVURU_TARIHI;
    String KURUM_ADI, KURULUS_YILI;

    
    public int getID() {
        return this.ID;
    }
    public String getName() {
        return this.Name;
    }
    public String getSurname() {
        return this.Surname;
    }
    public String getGender() {
        return this.Gender;
    }
    
    public String getAddress() {
        return this.Address;
    }
    public String getAskerlik() {
        return this.Askerlik;
    }
    public String getAskerlikKacagi(){
        return this.AskerlikKacagi;
    }
    public String getCezaSebep(){
        return this.CezaSebep;
    }
    public int getCezaMiktar(){
        return this.CezaMiktar;
    }
    public String getCezaTarih(){
        return this.CezaTarih;
    }
    public String getEmeklilikBaslangici(){
        return this.EmeklilikBaslangici;
    }
    public String getEmekli(){
        return this.Emekli;
    }
    public String getCalisiyor(){
        return this.Calisiyor;
    }
    public String getTapuluAdres(){
        return this.tapuAdres;
    }
    public String getIkametgahTarih(){
        return this.IkametgahTarih;
    }
    public String getIkametgahKisi(){
        return this.IkametgahKisi;
    }
    public String getIkametgahMetrekare(){
        return this.IkametgahMetrekare;
    }
    public int getKurumID (){
        return this.KURUM_ID;
    }
    public String getBasvuruDurumu (){
        return this.BASVURU_DURUMU;
    }
    public String getBasvuruTarihi (){
        return this.BASVURU_TARIHI;
    }
    public String getKurumAdi(){
        return this.KURUM_ADI;
    }
    public String getKurulusYili(){
        return this.KURULUS_YILI;
    }
    public String getDogumYeri(){
        return this.DogumYeri;
    }
    public String getDogumTarihi(){
        return this.DogumTarihi;
    }
    public void getApplyValues() throws SQLException{
        ResultSet myVariable = Database.applyForm(user.User.id);
        while (myVariable.next()) {
            this.Gender = myVariable.getString("cinsiyet");
            this.Address = myVariable.getString("adres");
            this.DogumYeri = myVariable.getString("dogum_yeri");
            this.DogumTarihi = myVariable.getString("dogum_tarihi");
        }
    }    
    public void getAskerlikValues() throws SQLException{
        ResultSet myVariable = Database.askerlikForm(user.User.id);
        while (myVariable.next()) {
            this.Askerlik = myVariable.getString("ASKERLIK_YAPTI");
            this.AskerlikKacagi = myVariable.getString("ASKER_KACAGI");
        }
    }
    public void getCezaValues() throws SQLException{
        ResultSet myVariable = Database.cezaForm(user.User.id);
        boolean cezaFound = false;
        while (myVariable.next()) {
            cezaFound = true;
            this.CezaSebep = myVariable.getString("ceza_sebep");
            this.CezaMiktar = myVariable.getInt("ceza_miktar");
            this.CezaTarih = myVariable.getString("ceza_alinan_tarih");
        }
        if (!cezaFound){
            this.CezaSebep = "YOKTUR";
            this.CezaMiktar = 0;
            this.CezaTarih = "YOKTUR";   
        }
    }
    public void getSigortaValues() throws SQLException{
        ResultSet myVariable = Database.sigortaForm(user.User.id);
        while (myVariable.next()) {
            this.Emekli = myVariable.getString("emekli");
            this.Calisiyor = myVariable.getString("calisiyor");
            this.EmeklilikBaslangici = myVariable.getString("emeklilik_baslangici");
        }
    }
    public void getIkametgahValues() throws SQLException{
        ResultSet myVariable = Database.ikametgahForm(user.User.id);
        while (myVariable.next()) {
            this.tapuAdres = myVariable.getString("adres");
            this.IkametgahKisi = myVariable.getString("kisi_sayisi");
            this.IkametgahTarih = myVariable.getString("tarih");
            this.IkametgahMetrekare = myVariable.getString("metrekare");
        }
    }
    public void getBasvuruValues() throws SQLException{
        ResultSet myVariable = Database.basvuruForm(user.User.id);
        while (myVariable.next()) 
        {
            this.KURUM_ID = myVariable.getInt("KURUM_ID");
            this.BASVURU_DURUMU = myVariable.getString("BASVURU_DURUMU");
            this.BASVURU_TARIHI = myVariable.getString("BASVURU_TARIHI");
        }
        getApplyValues();
        getKurumValues();
    }
    public void getKurumValues() throws SQLException{
        ResultSet myVariable = Database.kurumForm(this.KURUM_ID);
        while (myVariable.next()) {
            this.KURUM_ADI = myVariable.getString("KURUM_ADI");
            this.KURULUS_YILI = myVariable.getString("KURULUS_YILI");
        }   
    }
    public void addBasvuru() throws SQLException{
        Database.addBasvuru(ID, KURUM_ID, BASVURU_DURUMU, BASVURU_TARIHI);
    }
    
}