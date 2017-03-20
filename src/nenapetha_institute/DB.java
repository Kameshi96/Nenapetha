/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nenapetha_institute;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author Nethmi
 */
public class DB {
    
     private static java.sql.Connection c;
    private static void createNewConnection() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        c=DriverManager.getConnection("jdbc:mysql://localhost:3307/nenapetha", "root", "123");
    }
    
    public static void iud(String sql) throws Exception{
        if (c==null) {
            createNewConnection();
        }
         c.createStatement().executeUpdate(sql);
        
    }
    
    public static ResultSet search(String sql) throws Exception{
        if (c==null) {
            createNewConnection();
        }
        return c.createStatement().executeQuery(sql);
    }
    
    
    public static Connection getMyConnection() throws Exception{
        if (c==null) {
            createNewConnection();
        }
        return c;
    }
    
}
