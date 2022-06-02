package db;

/**
 *
 * @author emirm
 */

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.RequestScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.sql.rowset.CachedRowSet;

@ManagedBean(name = "jhkjhk")
@SessionScoped // bean nesnesinin sadece bir request boyunca yaşaması anlamına gelir. Bir sonraki requestte bean sıfırlanır.

public class Database {
    // TODO :: find a better way to not connect to the db in every function call 

    public static boolean loginUser(String tcNo, String password) throws SQLException {
        // check whether dataSource was injected by the server
        Context ctx = null;
        DataSource dataSource = null;

        try {
            ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup("jdbc/sample");
        } catch (NamingException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (dataSource == null) {
            throw new SQLException("Unable to obtain DataSource");
        }

        Connection connection = dataSource.getConnection();
        CachedRowSet rowSet = null;
        PreparedStatement ps;

        // check whether connection was successful
        if (connection == null) {
            throw new SQLException("Unable to connect to DataSource");
        } else {
            System.out.println("connected to db");
        }

        try {
            System.out.println(tcNo);
            System.out.println(password);

            ps = connection.prepareStatement("select id, name "
                    + " from GENEL "
                    + " where id=? and password=?");

            ps.setInt(1, Integer.parseInt(tcNo));
            ps.setString(2, password);

            rowSet = new com.sun.rowset.CachedRowSetImpl();
            rowSet.populate(ps.executeQuery());

            String name = "";
            int id = 0;
            
            while (rowSet.next()) {
                name = rowSet.getString("name");
                id = rowSet.getInt("id");
            }
            
            if (name.length() > 0) {
                user.User.id = id;
                user.User.name = name;
                System.out.println("name burasi: " + name);
                
                return true;
            }

            return false;
        } finally {
            connection.close(); // return this connection to pool
        } // end finally
    }

    public static ResultSet applyForm(int ID) throws SQLException {
        // check whether dataSource was injected by the server
        Context ctx = null;
        DataSource dataSource = null;

        try {
            ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup("jdbc/sample");
        } catch (NamingException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (dataSource == null) {
            throw new SQLException("Unable to obtain DataSource");
        }

        Connection connection = dataSource.getConnection();
        CachedRowSet rowSet = null;
        PreparedStatement ps;

        // check whether connection was successful
        if (connection == null) {
            throw new SQLException("Unable to connect to DataSource");
        } else {
            System.out.println("connected to db");
        }
        try {
            ps = connection.prepareStatement("select VATANDAS.ID, cinsiyet, adres, dogum_yeri, dogum_tarihi"
                    + " from VATANDAS, IKAMETGAH "
                    + " where VATANDAS.ID=1235882");

//            ps.setInt(0, ID);

            rowSet = new com.sun.rowset.CachedRowSetImpl();
            rowSet.populate(ps.executeQuery());
            return rowSet;

        } finally {
            connection.close(); // return this connection to pool
        } // end finally
    }

    public static ResultSet askerlikForm(int ID) throws SQLException {
        // check whether dataSource was injected by the server
        Context ctx = null;
        DataSource dataSource = null;

        try {
            ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup("jdbc/sample");
        } catch (NamingException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (dataSource == null) {
            throw new SQLException("Unable to obtain DataSource");
        }

        Connection connection = dataSource.getConnection();
        CachedRowSet rowSet = null;
        PreparedStatement ps;

        // check whether connection was successful
        if (connection == null) {
            throw new SQLException("Unable to connect to DataSource");
        } else {
            System.out.println("connected to db");
        }
        try {
            ps = connection.prepareStatement("select VATANDAS.ID, ASKERLIK_YAPTI, ASKER_KACAGI"
                    + " from VATANDAS, ASKERLIK "
                    + " where id=?");

            ps.setInt(1, ID);

            rowSet = new com.sun.rowset.CachedRowSetImpl();
            rowSet.populate(ps.executeQuery());
            return rowSet;

        } finally {
            connection.close(); // return this connection to pool
        } // end finally
    }

    public static ResultSet cezaForm(int ID) throws SQLException {
        // check whether dataSource was injected by the server
        Context ctx = null;
        DataSource dataSource = null;

        try {
            ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup("jdbc/sample");
        } catch (NamingException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (dataSource == null) {
            throw new SQLException("Unable to obtain DataSource");
        }

        Connection connection = dataSource.getConnection();
        CachedRowSet rowSet = null;
        PreparedStatement ps;

        // check whether connection was successful
        if (connection == null) {
            throw new SQLException("Unable to connect to DataSource");
        } else {
            System.out.println("connected to db");
        }
        try {
            ps = connection.prepareStatement("select VATANDAS.ID, ceza_sebep, ceza_miktar, ceza_alinan_tarih"
                    + " from VATANDAS, CEZA "
                    + " where id=?");

            ps.setInt(1, ID);

            rowSet = new com.sun.rowset.CachedRowSetImpl();
            rowSet.populate(ps.executeQuery());
            return rowSet;

        } finally {
            connection.close(); // return this connection to pool
        } // end finally
    }

    public static ResultSet sigortaForm(int ID) throws SQLException {
        // check whether dataSource was injected by the server
        Context ctx = null;
        DataSource dataSource = null;

        try {
            ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup("jdbc/sample");
        } catch (NamingException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (dataSource == null) {
            throw new SQLException("Unable to obtain DataSource");
        }

        Connection connection = dataSource.getConnection();
        CachedRowSet rowSet = null;
        PreparedStatement ps;

        // check whether connection was successful
        if (connection == null) {
            throw new SQLException("Unable to connect to DataSource");
        } else {
            System.out.println("connected to db");
        }
        try {
            ps = connection.prepareStatement("select VATANDAS.ID, emekli, calisiyor, emeklilik_baslangici "
                    + " from VATANDAS, SIGORTA "
                    + " where id=?");

            ps.setInt(1, ID);

            rowSet = new com.sun.rowset.CachedRowSetImpl();
            rowSet.populate(ps.executeQuery());
            return rowSet;

        } finally {
            connection.close(); // return this connection to pool
        } // end finally
    }

    public static ResultSet ikametgahForm(int ID) throws SQLException {
        // check whether dataSource was injected by the server
        Context ctx = null;
        DataSource dataSource = null;

        try {
            ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup("jdbc/sample");
        } catch (NamingException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (dataSource == null) {
            throw new SQLException("Unable to obtain DataSource");
        }

        Connection connection = dataSource.getConnection();
        CachedRowSet rowSet = null;
        PreparedStatement ps;

        // check whether connection was successful
        if (connection == null) {
            throw new SQLException("Unable to connect to DataSource");
        } else {
            System.out.println("connected to db");
        }
        try {
            ps = connection.prepareStatement("select VATANDAS.ID, adres, kisi_sayisi, tarih, metrekare"
                    + " from VATANDAS, IKAMETGAH "
                    + " where id=?");

            ps.setInt(1, ID);

            rowSet = new com.sun.rowset.CachedRowSetImpl();
            rowSet.populate(ps.executeQuery());
            return rowSet;

        } finally {
            connection.close(); // return this connection to pool
        } // end finally
    }

    public static ResultSet basvuruForm(int ID) throws SQLException {
        // check whether dataSource was injected by the server
        Context ctx = null;
        DataSource dataSource = null;

        try {
            ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup("jdbc/sample");
        } catch (NamingException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (dataSource == null) {
            throw new SQLException("Unable to obtain DataSource");
        }

        Connection connection = dataSource.getConnection();
        CachedRowSet rowSet = null;
        PreparedStatement ps;

        // check whether connection was successful
        if (connection == null) {
            throw new SQLException("Unable to connect to DataSource");
        } else {
            System.out.println("connected to db");
        }
        try {
            ps = connection.prepareStatement("select BASVURULAR.ID, KURUM_ID, BASVURU_DURUMU, BASVURU_TARIHI"
                    + " from BASVURULAR "
                    + " where id=?");

            ps.setInt(1, ID);

            rowSet = new com.sun.rowset.CachedRowSetImpl();
            rowSet.populate(ps.executeQuery());
            return rowSet;

        } finally {
            connection.close(); // return this connection to pool
        } // end finally
    }
        public static ResultSet kurumForm(int ID) throws SQLException {
        // check whether dataSource was injected by the server
        Context ctx = null;
        DataSource dataSource = null;

        try {
            ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup("jdbc/sample");
        } catch (NamingException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (dataSource == null) {
            throw new SQLException("Unable to obtain DataSource");
        }

        Connection connection = dataSource.getConnection();
        CachedRowSet rowSet = null;
        PreparedStatement ps;

        // check whether connection was successful
        if (connection == null) {
            throw new SQLException("Unable to connect to DataSource");
        } else {
            System.out.println("connected to db");
        }
        try {
            ps = connection.prepareStatement("select ID, KURUM_ADI, KURULUS_YILI "
                    + " from YARDIM_KURUMLARI "
                    + " where ID=?");

            ps.setInt(1, ID);

            rowSet = new com.sun.rowset.CachedRowSetImpl();
            rowSet.populate(ps.executeQuery());
            return rowSet;

        } finally {
            connection.close(); // return this connection to pool
        } // end finally
    }
    public static ResultSet addBasvuru(int ID, int KURUM_ID, boolean BASVURU_DURUMU, String BASVURU_TARIHI) throws SQLException {
        // check whether dataSource was injected by the server
        Context ctx = null;
        DataSource dataSource = null;

        try {
            ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup("jdbc/sample");
        } catch (NamingException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (dataSource == null) {
            throw new SQLException("Unable to obtain DataSource");
        }

        Connection connection = dataSource.getConnection();
        CachedRowSet rowSet = null;
        PreparedStatement ps;

        // check whether connection was successful
        if (connection == null) {
            throw new SQLException("Unable to connect to DataSource");
        } else {
            System.out.println("connected to db");
        }
        try {
            ps = connection.prepareStatement("INSERT INTO BASVURULAR (ID, KURUM_ID, BASVURU_DURUMU, BASVURU_TARIHI)" 
                    + " VALUES(?,?,?,?)");

            ps.setInt(1, ID);
            ps.setInt(2, KURUM_ID);
            ps.setBoolean(3, BASVURU_DURUMU);
            ps.setString(4, BASVURU_TARIHI);

            rowSet = new com.sun.rowset.CachedRowSetImpl();
            rowSet.populate(ps.executeQuery());
            return rowSet;

        } finally {
            connection.close(); // return this connection to pool
        } // end finally
    }
}
