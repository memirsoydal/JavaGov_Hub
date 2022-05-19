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

@ManagedBean (name="user")
@RequestScoped // bean nesnesinin sadece bir request boyunca yaşaması anlamına gelir. Bir sonraki requestte bean sıfırlanır.
//@SessionScoped
public class Database {
    // TODO :: find a better way to not connect to the db in every function call 
   
    public static boolean loginUser(String tcNo, String password) throws SQLException {
        // check whether dataSource was injected by the server
        Context ctx = null;
        DataSource dataSource = null;
        
        try {
            ctx = new InitialContext();
            dataSource = (DataSource)ctx.lookup("jdbc/sample");
        } catch (NamingException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        if ( dataSource == null )
            throw new SQLException( "Unable to obtain DataSource" );

        Connection connection = dataSource.getConnection();
        CachedRowSet rowSet = null;
        PreparedStatement ps;

        // check whether connection was successful
        if ( connection == null )
            throw new SQLException( "Unable to connect to DataSource" );
        else System.out.println("connected to db");
            
        try {
            System.out.println(tcNo);
            System.out.println(password);
//            System.out.println(connection);
            
            ps = connection.prepareStatement( "select tc_no, name " +
               " from USER_SIGNUP " + 
               " where tc_no=? and password=?");
            
            ps.setString(1, tcNo);
            ps.setString(2, password);
            
            rowSet = new com.sun.rowset.CachedRowSetImpl();
            rowSet.populate( ps.executeQuery() );
            
            String name = "";
            
            while (rowSet.next()) {
                
                name = rowSet.getString("name");
            }
            
            return (name.length() > 0 ? true : false);
            
        } finally {
            connection.close(); // return this connection to pool
        } // end finally
    }
    public static ResultSet applyForm(String TcNo) throws SQLException {
                // check whether dataSource was injected by the server
        Context ctx = null;
        DataSource dataSource = null;
        
        try {
            ctx = new InitialContext();
            dataSource = (DataSource)ctx.lookup("jdbc/sample");
        } catch (NamingException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        if ( dataSource == null )
            throw new SQLException( "Unable to obtain DataSource" );

        Connection connection = dataSource.getConnection();
        CachedRowSet rowSet = null;
        PreparedStatement ps;

        // check whether connection was successful
        if ( connection == null )
            throw new SQLException( "Unable to connect to DataSource" );
        else System.out.println("connected to db");
        try {
            ps = connection.prepareStatement( "select KIMLIK.tc_no, address, dogumYeri, dogumTarihi" +
               " from KIMLIK, IKAMETGAH " + 
               " where tc_no=?");
            
            ps.setString(1, TcNo);
            
            rowSet = new com.sun.rowset.CachedRowSetImpl();
            rowSet.populate( ps.executeQuery() );
            return rowSet;
            
        } finally {
            connection.close(); // return this connection to pool
        } // end finally
    }
    public static ResultSet askerlikForm(String TcNo) throws SQLException {
                // check whether dataSource was injected by the server
        Context ctx = null;
        DataSource dataSource = null;
        
        try {
            ctx = new InitialContext();
            dataSource = (DataSource)ctx.lookup("jdbc/sample");
        } catch (NamingException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        if ( dataSource == null )
            throw new SQLException( "Unable to obtain DataSource" );

        Connection connection = dataSource.getConnection();
        CachedRowSet rowSet = null;
        PreparedStatement ps;

        // check whether connection was successful
        if ( connection == null )
            throw new SQLException( "Unable to connect to DataSource" );
        else System.out.println("connected to db");
        try {
            ps = connection.prepareStatement( "select KIMLIK.tc_no, askerlik, askerlikTarih" +
               " from KIMLIK, ASKERLIK " + 
               " where tc_no=?");
            
            ps.setString(1, TcNo);
            
            rowSet = new com.sun.rowset.CachedRowSetImpl();
            rowSet.populate( ps.executeQuery() );
            return rowSet;
            
        } finally {
            connection.close(); // return this connection to pool
        } // end finally
    }
        public static ResultSet cezaForm(String TcNo) throws SQLException {
                // check whether dataSource was injected by the server
        Context ctx = null;
        DataSource dataSource = null;
        
        try {
            ctx = new InitialContext();
            dataSource = (DataSource)ctx.lookup("jdbc/sample");
        } catch (NamingException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        if ( dataSource == null )
            throw new SQLException( "Unable to obtain DataSource" );

        Connection connection = dataSource.getConnection();
        CachedRowSet rowSet = null;
        PreparedStatement ps;

        // check whether connection was successful
        if ( connection == null )
            throw new SQLException( "Unable to connect to DataSource" );
        else System.out.println("connected to db");
        try {
            ps = connection.prepareStatement( "select KIMLIK.tc_no, cezaSebep, cezaMiktar, cezaTarih" +
               " from KIMLIK, CEZA " + 
               " where tc_no=?");
            
            ps.setString(1, TcNo);
            
            rowSet = new com.sun.rowset.CachedRowSetImpl();
            rowSet.populate( ps.executeQuery() );
            return rowSet;
            
        } finally {
            connection.close(); // return this connection to pool
        } // end finally
    }
        public static ResultSet sigortaForm(String TcNo) throws SQLException {
                // check whether dataSource was injected by the server
        Context ctx = null;
        DataSource dataSource = null;
        
        try {
            ctx = new InitialContext();
            dataSource = (DataSource)ctx.lookup("jdbc/sample");
        } catch (NamingException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        if ( dataSource == null )
            throw new SQLException( "Unable to obtain DataSource" );

        Connection connection = dataSource.getConnection();
        CachedRowSet rowSet = null;
        PreparedStatement ps;

        // check whether connection was successful
        if ( connection == null )
            throw new SQLException( "Unable to connect to DataSource" );
        else System.out.println("connected to db");
        try {
            ps = connection.prepareStatement( "select KIMLIK.tc_no, emekli, calisiyor, emekliyasisure, sigortasure " +
               " from KIMLIK, SIGORTA " + 
               " where tc_no=?");
            
            ps.setString(1, TcNo);
            
            rowSet = new com.sun.rowset.CachedRowSetImpl();
            rowSet.populate( ps.executeQuery() );
            return rowSet;
            
        } finally {
            connection.close(); // return this connection to pool
        } // end finally
    }
        public static ResultSet ikametgahForm(String TcNo) throws SQLException {
                // check whether dataSource was injected by the server
        Context ctx = null;
        DataSource dataSource = null;
        
        try {
            ctx = new InitialContext();
            dataSource = (DataSource)ctx.lookup("jdbc/sample");
        } catch (NamingException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        if ( dataSource == null )
            throw new SQLException( "Unable to obtain DataSource" );

        Connection connection = dataSource.getConnection();
        CachedRowSet rowSet = null;
        PreparedStatement ps;

        // check whether connection was successful
        if ( connection == null )
            throw new SQLException( "Unable to connect to DataSource" );
        else System.out.println("connected to db");
        try {
            ps = connection.prepareStatement( "select KIMLIK.tc_no, tapuluMal, ikametgahKisi, ikametgahTarih, ikametgahm2" +
               " from KIMLIK, IKAMETGAH " + 
               " where tc_no=?");
            
            ps.setString(1, TcNo);
            
            rowSet = new com.sun.rowset.CachedRowSetImpl();
            rowSet.populate( ps.executeQuery() );
            return rowSet;
            
        } finally {
            connection.close(); // return this connection to pool
        } // end finally
    }
}