package tp2_dpbo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author indah
 */
public class Config {
    private Statement stmt = null;
    private Connection conn = null;
    private static Connection mysqlconfig;
    public static Connection configDB() throws SQLException{
        try{
            String url="jdbc:mysql://localhost:3306/db_tp2_dpbo";
            String username="root";
            String password="";
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            mysqlconfig = DriverManager.getConnection(url, username, password);
        }catch(Exception e){
            System.err.println("Koneksi gagal "+ e.getMessage());
        }
        return mysqlconfig;
    }  
    
    //for select query
    public ResultSet selectQuery(String sql){
        try{
            stmt.executeQuery(sql);
            return stmt.getResultSet();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    //for insert, update, delete query
    public int updateQuery(String sql){
        try{
            return stmt.executeUpdate(sql);
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return 0;
    }
    
    public Statement getStatement(){
        return stmt;
    }
    
}
